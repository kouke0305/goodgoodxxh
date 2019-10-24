package top.allviewit.backstage.testauthentication;

import org.beetl.sql.core.annotatoin.Table;

@Table(name="testcode")
public class TestCodeModel {
    private Integer id;
    private String code;    //加密后字符串

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
