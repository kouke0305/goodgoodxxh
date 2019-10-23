package top.allviewit.backstage.takeMilk;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;

@Table(name = "dispatching")
public class TakeMilkOrderModel extends TailBean {
    //配送单表id
    private Integer id;
    //订单编号
    private String snumber;

    //订单详情id
    //private String oid;

    //客户id
    private String cid;
    //客户地址id
    private  Integer caid;
    //收货人地址
    private String address;
    //收货人电话
    private String phone;
    //奶站id
    private String sid;
    //员工id
    private String eid;
    //商品名
    private String goods;
    //商品数量
    private Integer number;
    //配送开始时间
    private String start;
    //配送结束时间
    private String end;
    //配送状态
    private Integer status;
    //订单异常信息id
    private String errorid;
    //异常名称
    private String errorname;
    //收货人姓名
    private String cneename;
    //配送单编号
    private String dispatchid;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getDispatchid() {
        return dispatchid;
    }

    public void setDispatchid(String dispatchid) {
        this.dispatchid = dispatchid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorid() {
        return errorid;
    }

    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }

    public String getCneename() {
        return cneename;
    }

    public void setCneename(String cneename) {
        this.cneename = cneename;
    }

    public String getErrorname() {
        return errorname;
    }

    public void setErrorname(String errorname) {
        this.errorname = errorname;
    }

//    public String getOid() {
//        return oid;
//    }
//
//    public void setOid(String oid) {
//        this.oid = oid;
//    }
}