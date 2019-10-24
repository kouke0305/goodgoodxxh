package top.allviewit.backstage.user;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;

@Table(name="user")
public class UserModel extends TailBean {
    //微信用户id
    private Integer id;
    //用户姓名
    private String name;
    //手机号
    private String phone;
    //创建时间
    private String createtime;
    //微信openid
    private String app_openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getApp_openid() {
        return app_openid;
    }

    public void setApp_openid(String app_openid) {
        this.app_openid = app_openid;
    }
}
