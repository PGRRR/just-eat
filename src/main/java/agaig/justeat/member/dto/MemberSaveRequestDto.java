package agaig.justeat.member.dto;

import agaig.justeat.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private String birth;

    @Builder
    public MemberSaveRequestDto(String email, String password, String name, String phone, String address, String gender, String birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
    }

    // request DTO 로 받은 Member 객체를 Entity 화하여 저장하는 용도
    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .address(address)
                .gender(gender)
                .birth(birth)
                .build();
    }
}
