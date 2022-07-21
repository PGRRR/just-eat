package agaig.justeat.member.dto;

import agaig.justeat.member.domain.Information;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class InfoUpdateRequestDto {
    private String writer;
    private String title;
    private String content;
    private Date reg_date;
    private Long view_cnt;
    private Long comment_cnt;
    private Long member_id;

    @Builder
    public InfoUpdateRequestDto(Information information) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.view_cnt = view_cnt;
        this.comment_cnt = comment_cnt;
        this.member_id = member_id;
    }

    public Information toEntity() {
        return Information.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .reg_date(reg_date)
                .view_cnt(view_cnt)
                .comment_cnt(comment_cnt)
                .member_id(member_id)
                .build();
    }
}
