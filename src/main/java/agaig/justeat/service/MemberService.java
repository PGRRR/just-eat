package agaig.justeat.service;

import agaig.justeat.domain.Member;
import agaig.justeat.dto.MemberResponseDto;
import agaig.justeat.dto.MemberSaveRequestDto;
import agaig.justeat.dto.MemberUpdateRequestDto;
import agaig.justeat.exception.ErrorCode;
import agaig.justeat.exception.SignInException;
import agaig.justeat.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(MemberSaveRequestDto requestDto) {
        Optional.ofNullable(memberRepository.findByEmail(requestDto.getEmail()))
                .ifPresent((member -> {
                    throw new SignInException("이미 존재하는 회원입니다.", ErrorCode.ADMIN_NOT_FOUND);
                }));
        return memberRepository.insert(requestDto.toEntity());
    }

    public MemberResponseDto signIn(String email, String password) {
        Member member = Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        if (!password.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
        return new MemberResponseDto(member);
    }

    public void signInCheck(HttpSession session) {
        Optional.ofNullable(session.getAttribute("session"))
                .orElseThrow(() ->
                        new SignInException("로그인이 필요합니다.", ErrorCode.ADMIN_NOT_FOUND));
    }

    public void verify(Long member_id, HttpSession session) {
        Object sessionAttribute = session.getAttribute("session");
        MemberResponseDto sessionMember = (MemberResponseDto) sessionAttribute;
        if (!member_id.equals(sessionMember.getMember_id())) {
            throw new SignInException("잘못된 접근입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public void passwordCheck(Long member_id, String password) {
        Member member = memberRepository.findById(member_id);
        if (!password.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public Long update(Long member_id, MemberUpdateRequestDto requestDto) {
        requestDto.setMember_id(member_id);
        return memberRepository.update(requestDto.toEntity());
    }

    public MemberResponseDto findInfoById(Long member_id) {
        Member member = Optional.ofNullable(memberRepository.findById(member_id)).orElseThrow(()->new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        return new MemberResponseDto(member);
    }
}
