package agaig.justeat.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Information {
    private Long info_id;
    private String writer;
    private String title;
    private String content;
    private Date reg_date;
    private Date up_date;
    private Long view_cnt;
    private Long comment_cnt;
    private Long member_id;

    @Builder
    public Information(Long info_id,String writer, String title, String content, Date reg_date, Date up_date, Long view_cnt, Long comment_cnt, Long member_id) {
        this.info_id = info_id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.up_date = up_date;
        this.view_cnt = view_cnt;
        this.comment_cnt = comment_cnt;
        this.member_id = member_id;
    }
}
