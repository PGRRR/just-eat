package agaig.justeat.member.exception;

import lombok.Getter;

@Getter
public class SignInException extends RuntimeException{
    private final ErrorCode errorCode;

    public SignInException(String message, ErrorCode errorCode) {
        super(errorCode.getMessage() + message);
        this.errorCode = errorCode;
    }
}
