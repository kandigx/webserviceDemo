package ciecc.swzf.common.entity;

import ciecc.swzf.common.constant.PromptMessageConsts;

/**
 * @author kandigx
 * @create 2017-09-19 16:41
 */
public class ErrorMsgVO {

    private String errorCode;
    private String errorDescr;
    private String detail;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescr() {
        return errorDescr;
    }

    public void setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ErrorMsgVO() {
    }

    public ErrorMsgVO(String errorCode, String detail) {
        this.errorCode = errorCode;
        this.errorDescr = PromptMessageConsts.getErrorMsgMap().get(errorCode);
        this.detail = detail;
    }

    public ErrorMsgVO(String errorCode, String errorDescr, String detail) {
        this.errorCode = errorCode;
        this.errorDescr = errorDescr;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return errorCode + ":" + detail;
    }
}
