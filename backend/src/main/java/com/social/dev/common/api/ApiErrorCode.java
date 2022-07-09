package com.social.dev.common.api;


public enum ApiErrorCode implements IErrorCode {

    /**
     * SUCCESS
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * FAILED
     */
    FAILED(-1, "FAILED"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    /**
     * FORBIDDEN
     */
    FORBIDDEN(403, "FORBIDDEN"),
    /**
     * VALIDATE_FAILED
     */
    VALIDATE_FAILED(404, "VALIDATE_FAILED");

    private final Integer code;
    private final String message;

    ApiErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
