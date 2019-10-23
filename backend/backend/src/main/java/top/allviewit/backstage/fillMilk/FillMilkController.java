package top.allviewit.backstage.fillMilk;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.allviewit.backstage.common.RedisOperator;
import top.allviewit.backstage.common.RespModel;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wubing
 * @Date: 2019/3/18 16:48
 * @Description:
 */
@RestController
@RequestMapping("fillMilk")
public class FillMilkController {

    @Autowired
    private RedisOperator redis;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FillMilkDao fillMilkDao;

    @RequestMapping("list")
    public RespModel getList(@RequestParam(value = "page", defaultValue = "1") Long page,
                             @RequestParam(value = "pageSize", defaultValue = "50") Long pageSize,
                             @RequestParam(value = "phone", required = false) String phone) {
        PageQuery query = new PageQuery();
        if(!"".equals(phone)){
            query.setPageSize(pageSize);
            query.setPageNumber(page);
            query.setPara("phone", phone);
            fillMilkDao.selectFillOrder(query);
            return new RespModel(true, "补奶列表", query);
        }else{
            return new RespModel(false, "手机号为null", query);
        }
    }
}
