package com.social.dev.common.exception;

import com.social.dev.common.api.IErrorCode;


public class ApiAsserts {
    /**
     * throw failure exception
     *
     * @param message description
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * throw failure exception
     *
     * @param errorCode status code
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
