package com.insedesign.communityadmin.common.resp;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */

public class ParameterInvalidItem {

    private String fieldName;

    private String message;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}