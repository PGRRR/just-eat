package agaig.justeat.member.dto;

import agaig.justeat.member.domain.Information;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class InfoBoardResponseDto {
    private Long Info_id;
    private String writer;
    private String title;
    private Date reg_date;
    private Long view_cnt;
    private Long comment_cnt;

    public InfoBoardResponseDto(Information information) {
        this.Info_id = information.getInfo_id();
        this.writer = information.getWriter();
        this.title = information.getTitle();
        this.reg_date = information.getReg_date();
        this.view_cnt = information.getView_cnt();
        this.comment_cnt = information.getComment_cnt();
    }
}
