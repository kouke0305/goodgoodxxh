package top.allviewit.backstage.user;

/**
 * @Auther: wubing
 * @Date: 2019/2/14 11:11
 * @Description:
 */
    public class NoteBean {
    //手机号
    private String phone;
    //验证码
    private String snumber;
    //状态
    private String status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
