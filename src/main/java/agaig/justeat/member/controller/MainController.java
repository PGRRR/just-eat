package agaig.justeat.member.controller;

import agaig.justeat.member.annotation.MemberSignInCheck;
import agaig.justeat.member.domain.Member;
import agaig.justeat.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("")
    public String main(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "index";
    }

    @MemberSignInCheck
    @GetMapping("/self")
    public String self(HttpServletRequest request, HttpSession session) {
        return "/selftest/SelfTestFoundation";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String loginCatcher(Exception e, HttpServletRequest request) {
        return "redirect:/members/?toURL=" + request.getRequestURL();

    }
}
