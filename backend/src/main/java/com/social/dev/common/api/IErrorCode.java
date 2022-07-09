package com.social.dev.common.api;


public interface IErrorCode {
    /**
     * Error code: -1 for failure; 200 for success
     *
     * @return Error code
     */
    Integer getCode();

    /**
     * Error description
     *
     * @return Error description
     */
    String getMessage();
}
