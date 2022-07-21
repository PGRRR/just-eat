package agaig.justeat.member.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ADMIN_NOT_FOUND(400, "ANF1", "접근 권한이 없습니다.");
    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
