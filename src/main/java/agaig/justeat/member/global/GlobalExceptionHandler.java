package agaig.justeat.member.global;

import agaig.justeat.member.exception.SignInException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SignInException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String catcher(Exception e) {
        System.out.println("접근 권한이 필요합니다.");
        return "/member/signIn";
    }
}
