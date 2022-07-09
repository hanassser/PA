package com.social.dev.common.api;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;


@Data
@NoArgsConstructor
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = -4153430394359594346L;
    /**
     * status code
     */
    private long code;
    /**
     * result set
     */
    private T data;
    /**
     * interface description
     */
    private String message;

    /**
     * 全参
     *
     * @param code    status code
     * @param message description
     * @param data    dataset
     */
    public ApiResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(ApiErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 成功
     *
     * @param data dataset
     * @return {code:200,message:operation succeed ,data:customize}
     */
    public static <T> ApiResult<T> success() {
        return new ApiResult<T>(ApiErrorCode.SUCCESS.getCode(), ApiErrorCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     *
     * @param data dataset
     * @return {code:200,message:operation succeed ,data:customize}
     */
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(ApiErrorCode.SUCCESS.getCode(), ApiErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     *
     * @param data    dataset
     * @param message customized warning inforamtion
     * @return {code:200,message:自定义,data:自定义}
     */
    public static <T> ApiResult<T> success(T data, String message) {
        return new ApiResult<T>(ApiErrorCode.SUCCESS.getCode(), message, data);
    }

    /**
     * fail return result
     */
    public static <T> ApiResult<T> failed() {
        return failed(ApiErrorCode.FAILED);
    }

    /**
     * fail return result
     *
     * @param message warning information
     * @return {code:code:get from emun ApiErrorCode,message:customize,data:null}
     */
    public static <T> ApiResult<T> failed(String message) {
        return new ApiResult<T>(ApiErrorCode.FAILED.getCode(), message, null);
    }

    /**
     * fail
     *
     * @param errorCode error code
     * @return {code:get from package interface,message: get from package interface,data:null}
     */
    public static <T> ApiResult<T> failed(IErrorCode errorCode) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * error return result
     *
     * @param errorCode error code
     * @param message   error information
     * @return {code:get from emun ApiErrorCode,message:customize,data:null}
     */
    public static <T> ApiResult<T> failed(IErrorCode errorCode, String message) {
        return new ApiResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * Parameter validation failed to return the result
     */
    public static <T> ApiResult<T> validateFailed() {
        return failed(ApiErrorCode.VALIDATE_FAILED);
    }

    /**
     * Parameter validation failed to return the result
     *
     * @param message warning information
     */
    public static <T> ApiResult<T> validateFailed(String message) {
        return new ApiResult<T>(ApiErrorCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * Not logged in return result
     */
    public static <T> ApiResult<T> unauthorized(T data) {
        return new ApiResult<T>(ApiErrorCode.UNAUTHORIZED.getCode(), ApiErrorCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * Unauthorized return result
     */
    public static <T> ApiResult<T> forbidden(T data) {
        return new ApiResult<T>(ApiErrorCode.FORBIDDEN.getCode(), ApiErrorCode.FORBIDDEN.getMessage(), data);
    }
}
