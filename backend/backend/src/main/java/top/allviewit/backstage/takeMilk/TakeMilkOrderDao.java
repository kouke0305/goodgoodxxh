package top.allviewit.backstage.takeMilk;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TakeMilkOrderDao extends BaseMapper<TakeMilkOrderModel> {
    List<TakeMilkOrderModel> selectList(PageQuery query);
    }

