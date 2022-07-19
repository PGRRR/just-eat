package agaig.justeat.controller;

import agaig.justeat.annotation.MemberSignInCheck;
import agaig.justeat.domain.Information;
import agaig.justeat.domain.PageHandler;
import agaig.justeat.dto.InfoResponseDto;
import agaig.justeat.dto.InfoSaveRequestDto;
import agaig.justeat.dto.MemberResponseDto;
import agaig.justeat.service.InformationService;
import agaig.justeat.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class InformationController {

    private final InformationService informationService;
    private final MemberService memberService;

    @Autowired
    public InformationController(InformationService informationService, MemberService memberService) {
        this.informationService = informationService;
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public String list(Integer page, Integer pageSize, Model model) {
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        int totalCnt = informationService.getCount();
        PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Information> boardList = informationService.getPage(map);
        model.addAttribute("infoBoardList", boardList);
        model.addAttribute("pageHandler", pageHandler);
        return "information/infoList";
    }

    @GetMapping("/{info_id}")
    public String infoRead(@PathVariable Long info_id, Model model) {
        InfoResponseDto responseDto = informationService.read(info_id);
        model.addAttribute("info", responseDto);
        return "/information/info";
    }

    @MemberSignInCheck
    @GetMapping("/write")
    public String write() {
        return "/information/infoWrite";
    }

    @PostMapping("/write/{member_id}")
    public String writeSave(@PathVariable Long member_id, InfoSaveRequestDto requestDto) {
        MemberResponseDto memberResponseDto = memberService.findInfoById(member_id);
        requestDto.setWriter(memberResponseDto.getName());
        requestDto.setMember_id(member_id);
        informationService.write(requestDto);
        return "redirect:/info/list";
    }

    @GetMapping("/delete/{member_id}/{info_id}")
    public String infoDelete(@PathVariable Long member_id, @PathVariable Long info_id, HttpSession session) {
        memberService.verify(member_id, session);
        informationService.remove(info_id, member_id);
        return "redirect:/info/list";
    }
}
