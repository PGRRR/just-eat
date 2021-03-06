package agaig.justeat.member.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.dto.MemberSaveRequestDto;
import agaig.justeat.member.dto.MemberUpdateRequestDto;
import agaig.justeat.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @MemberSignInCheck
    @GetMapping("")
    public String getSignIn() {
        return "redirect:/";
    }

    @PostMapping("")
    public String postSignIn(String email, String password, boolean rememberId, String toURL, HttpServletRequest request, HttpServletResponse response) {

        Long member_id = memberService.signIn(email, password);

        Cookie memberCookie = new Cookie("member_id", member_id.toString());
        response.addCookie(memberCookie);

        Cookie idCookie = new Cookie("email", email);
        if (!rememberId) {
            idCookie.setMaxAge(0);
        }
        response.addCookie(idCookie);

        HttpSession session = request.getSession();
        session.setAttribute("session", member_id);

        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:" + toURL;
    }

    @GetMapping("signUp")
    public String getSignUp() {
        return "/member/signUp";
    }

    @PostMapping("signUp")
    public String postSignUp(MemberSaveRequestDto requestDto) {
        memberService.join(requestDto);
        return "/member/signIn";
    }


    @GetMapping("/kakao")
    public String sns() {
        return "/member/sns";
    }

    @GetMapping("/logout")
    public String logout(@CookieValue(value = "member_id") Cookie memberCookie, HttpSession session, HttpServletResponse response) {
        memberCookie.setMaxAge(0);
        memberCookie.setPath("/");
        response.addCookie(memberCookie);
        session.invalidate();
        return "redirect:/";
    }

    @MemberSignInCheck
    @GetMapping("/{id}")
    public String memberInfo(@PathVariable Long id, Model model) {
        MemberUpdateResponseDto responseDto = memberService.findInfoById(id);
        model.addAttribute("updateMember", responseDto);
        return "/member/memberUpdate";
    }

    @MemberSignInCheck
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, String password,MemberUpdateRequestDto requestDto, Model model) {
        memberService.passwordCheck(id, password);
        memberService.update(id, requestDto);
        MemberUpdateResponseDto responseDto = memberService.findInfoById(id);
        model.addAttribute("updateMember", responseDto);
        return "/member/memberUpdate";
    }

}
