package top.allviewit.backstage.myorder;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyOrderDao extends BaseMapper<MyOrderModel> {

    List<MyOrderModel> selectOrderByPhone(PageQuery query);
}

