package top.allviewit.backstage.testauthentication;


import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestCodeDao  extends BaseMapper<TestCodeModel> {
    List<TestCodeModel> getCode(@Param("code") String code);
}
