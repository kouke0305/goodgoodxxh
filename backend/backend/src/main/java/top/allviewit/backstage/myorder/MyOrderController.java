package top.allviewit.backstage.myorder;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.allviewit.backstage.common.RedisOperator;
import top.allviewit.backstage.common.RespModel;

/**
 * @Auther: wubing
 * @Date: 2019/3/18 16:48
 * @Description:
 */
@RestController
@RequestMapping("myOrder")
public class MyOrderController {

    @Autowired
    private RedisOperator redis;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MyOrderDao myOrderDao;

    @RequestMapping("list")
    public RespModel getList(@RequestParam(value = "page", defaultValue = "1") Long page,
                             @RequestParam(value = "pageSize", defaultValue = "50") Long pageSize,
                             @RequestParam(value = "phone", required = false) String phone) {
            PageQuery query = new PageQuery();
            query.setPageSize(pageSize);
            query.setPageNumber(page);
            query.setPara("phone", phone);
            myOrderDao.selectOrderByPhone(query);
            return new RespModel(true, "我的订单列表", query);
    }

    
}
