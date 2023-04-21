package com.zjubj.acs.nxacsplatfromengine.dto.Util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
public class ResultDTO<T> {

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Object data;

    @Getter
    @Setter
    private boolean success;

    public ResultDTO(ErrorEnum error) {
        this.code = error.getErrorCode();
        this.message = error.getErrorMsg();
    }

    public ResultDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultDTO() {
        this.code = 0;
        this.message = "success";
    }

    public ResultDTO(Object data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    public ResultDTO<T> sendFailedMessage(String msg) {
        this.success = false;
        this.message = msg;
        return this;
    }

    public ResultDTO<T> sendFailedMessage(Exception e) {
        this.success = false;
        this.message = e.getMessage();
        return this;
    }
}
