package top.allviewit.backstage.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.allviewit.backstage.common.RespModel;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public RespModel index() {
        return new RespModel(true, "message", "data");
    }
}