package top.allviewit.backstage.fillMilk;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FillMilkDao extends BaseMapper<FillMilkModel> {

    void selectFillOrder(PageQuery query);

    List<FillMilkModel> selectSnumber(@Param("phone") String phone);
}

