package com.example.common;

public class CommonActionResults {

    private static final String SUCCESS_MESSAGE = "success";
    private static final int SUCCESS_CODE = 1;
    private static final String FAIL_MESSAGE = "fail";
    private static final int FAIL_CODE = -1;


    private static ActionResult commonSet(Object data) {
        ActionResult result = new ActionResult();
        result.setData(data);
        return result;
    }

    public static ActionResult success(Object data) {
        ActionResult result = commonSet(data);
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        return result;
    }

    public static ActionResult fail(Object data) {
        ActionResult result = commonSet(data);
        result.setCode(FAIL_CODE);
        result.setMessage(FAIL_MESSAGE);
        return result;
    }


    public static ActionResult success(Object data, String message) {
        ActionResult result = commonSet(data);
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        return result;
    }

    public static ActionResult fail(Object data, String message) {
        ActionResult result = commonSet(data);
        result.setCode(FAIL_CODE);
        result.setMessage(message);
        return result;
    }


}
