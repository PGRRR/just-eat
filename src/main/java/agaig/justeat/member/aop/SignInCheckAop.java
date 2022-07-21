package agaig.justeat.member.aop;

import agaig.justeat.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
@RequiredArgsConstructor
public class SignInCheckAop {

    private final MemberService memberService;

//    @Before("execution(* agaig.justeat.member.controller.MainController.*(..))")
    @Before("@annotation(agaig.justeat.annotation.MemberSignInCheck)")
    public void execute() throws Throwable {
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        memberService.signInCheck(session);
    }
}
