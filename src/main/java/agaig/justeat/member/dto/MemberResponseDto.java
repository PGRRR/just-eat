package agaig.justeat.member.dto;

import agaig.justeat.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long member_id;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String birth;

    // repository 를 통해 조회한 Entity 를 DTO 로 변환 용도
    public MemberResponseDto(Member member) {
        this.member_id = member.getMember_id();
        this.email = member.getEmail();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.birth = member.getBirth();
    }
}
