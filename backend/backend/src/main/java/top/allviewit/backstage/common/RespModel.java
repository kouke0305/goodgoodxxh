package top.allviewit.backstage.common;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class RespModel {
    public RespModel(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public RespModel() {
    }

    public boolean success;
    public Object data;
    public String message;

    public boolean getSuccess() {
        return this.success;
    }

    public void isSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    // 新增
    public static final String errorMsgKey = "errorMsg";

    public static final String successMsgKey = "successMsg";

    private String errorMsg;

    private String successMsg;

    public boolean isSuccess(){
        return errorMsg == null;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }


    public static RespModel errorMsg(String msg){
        RespModel respModel = new RespModel();
        respModel.setErrorMsg(msg);
        return respModel;
    }

    public static RespModel successMsg(String msg){
        RespModel respModel = new RespModel();
        respModel.setSuccessMsg(msg);
        return respModel;
    }


    public Map<String, String> asMap(){
        Map<String, String> map = Maps.newHashMap();
        map.put(successMsgKey, successMsg);
        map.put(errorMsgKey, errorMsg);
        return map;
    }

    public String asUrlParams(){
        Map<String, String> map = asMap();
        Map<String, String> newMap = Maps.newHashMap();
        map.forEach((k,v) -> {if(v!=null)
            try {
                newMap.put(k, URLEncoder.encode(v,"utf-8"));
            } catch (UnsupportedEncodingException e) {

            }});
        return Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(newMap);
    }

}