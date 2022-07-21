package agaig.justeat.member.dto;

import agaig.justeat.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private Long member_id;
    private String name;
    private String phone;
    private String address;
    private String birth;

    @Builder
    public MemberUpdateRequestDto(Long member_id, String name, String phone, String address, String birth) {
        this.member_id = member_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }

    // request DTO 로 받은 Member 객체를 Entity 화하여 저장하는 용도
    public Member toEntity() {
        return Member.builder()
                .member_id(member_id)
                .name(name)
                .phone(phone)
                .address(address)
                .birth(birth)
                .build();
    }
}
