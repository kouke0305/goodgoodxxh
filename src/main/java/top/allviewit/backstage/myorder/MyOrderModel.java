package top.allviewit.backstage.myorder;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;

import java.sql.Timestamp;

@Table(name = "oorder")
public class MyOrderModel extends TailBean {
    // 订单表id
    private String id;
    // 有赞订单编号
    private String snumber;
    // jboss订单编号
    private String jnumber;
    //省
    private String province;
    //市
    private String city;
    //区
    private String region;
    //客户地址id
    private Integer caid;
    // 客户id
    private String cid;
    // 收货人名
    private String name;
    // 收货人地址
    private String address;
    // 收货人电话
    private String phone;
    // 奶站id
    private String sid;
    // 奶站名
    private String mname;
    // 商品名
    private String goods;
    // 商品数量
    private Integer number;
    // 订单开始配送时间
    private String start;
    // 订单结束配送时间
    private String end;
    // 订单状态
    private String status;
    // 配送员id
    private String eid;
    // 配送员名
    private String ename;
    // 配送员电话
    private String ephone;
    // 分单时间
    private Timestamp time;
    // 订单进行的状态
    private Integer ostatus;
    // 商品编号
    private String itemsku;
    //价格
    private String price;
    //jbosscia ,jboss的客户编号
    private String jbosscid;
    // 配送周期
    private String dispatchper;
    // 创建时间
    private String createtime;
    // 创建时间
    private String updatetime;
    // 售货机编号
    private String vmachine;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDispatchper() {
        return dispatchper;
    }

    public void setDispatchper(String dispatchper) {
        this.dispatchper = dispatchper;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getJbosscid() {
        return jbosscid;
    }

    public void setJbosscid(String jbosscid) {
        this.jbosscid = jbosscid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getId() {
        return id;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getJnumber() {
        return jnumber;
    }

    public void setJnumber(String jnumber) {
        this.jnumber = jnumber;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public String getItemsku() {
        return itemsku;
    }

    public void setItemsku(String itemsku) {
        this.itemsku = itemsku;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getVmachine() {
        return vmachine;
    }

    public void setVmachine(String vmachine) {
        this.vmachine = vmachine;
    }
}
