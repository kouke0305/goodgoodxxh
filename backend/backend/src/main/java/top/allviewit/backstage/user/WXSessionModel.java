package top.allviewit.backstage.user;

/**
 * @author: Chunle Tian
 * @create: 2019/02/13 11:26
 * @description: 微信小程序Session模型
 **/
public class WXSessionModel {
    private String session_key;     //微信服务器的登录状态
    private String openid;          //微信openID

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
