package agaig.justeat.member.repository;

import agaig.justeat.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {

    Long insert(Member member);

    Long update(Member member);

    Member findById(Long id);

    Member findByEmail(String email);

    List<Member> findAll();
}
