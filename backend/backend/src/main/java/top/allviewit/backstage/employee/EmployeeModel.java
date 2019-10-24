package top.allviewit.backstage.employee;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Map;

@Table(name="employee")
public class EmployeeModel extends TailBean {
    //员工表id
    private Integer id;
    //员工编号
    private String empid;
    // 角色id
    private String roleid;
    //员工姓名
    private String name;
    //员工电话
    private String phone;
    //员工所属奶站
    private String station;
    //员工配送范围
    private String address;
    //员工状态
    private Integer state;
    //员工身份
    private Integer job;
    //奶站名
    private String sname;
    //员工家庭地址
    private String home;
    //员工性别
    private Integer sex;
    //员工配送单数
    private  Integer amount;
    //员工的微信openid
    private String openid;
    //公众号openid
    private String gzhopenid;
    //员工绑定码
    private String bindingCode;
    //员工实时坐标
    private String realCoord;
    //权限详情
    private Map<String,Boolean> roleDatils;
    //分单授权
    private Integer fdauthorization;

    public Map<String, Boolean> getRoleDatils() {
        return roleDatils;
    }

    public void setRoleDatils(Map<String, Boolean> roleDatils) {
        this.roleDatils = roleDatils;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBindingCode() {
        return bindingCode;
    }

    public void setBindingCode(String bindingCode) {
        this.bindingCode = bindingCode;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRealCoord() {
        return realCoord;
    }

    public void setRealCoord(String realCoord) {
        this.realCoord = realCoord;
    }

    public String getGzhopenid() {
        return gzhopenid;
    }

    public void setGzhopenid(String gzhopenid) {
        this.gzhopenid = gzhopenid;
    }

    public Integer getFdauthorization() {
        return fdauthorization;
    }

    public void setFdauthorization(Integer fdauthorization) {
        this.fdauthorization = fdauthorization;
    }
}
