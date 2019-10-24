package top.allviewit.backstage.user;

/**
 * @author: Chunle Tian
 * @create: 2019/02/13 14:50
 * @description: 微信小程序sKey与绑定账号状态
 **/
public class CodeAndStatusVoModel {
    private String skey;  //登录令牌
    private String userid;      //员工id

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
