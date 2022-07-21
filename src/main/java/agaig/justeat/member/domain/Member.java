package agaig.justeat.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private Long member_id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private String birth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return member_id.equals(member.member_id) && email.equals(member.email) && password.equals(member.password) && name.equals(member.name) && Objects.equals(phone, member.phone) && Objects.equals(address, member.address) && Objects.equals(gender, member.gender) && Objects.equals(birth, member.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_id, email, password, name, phone, address, gender, birth);
    }

    @Builder
    public Member(Long member_id, String email, String password, String name, String phone, String address, String gender, String birth) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
    }
}
