package top.allviewit.backstage.wxauthorization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
import top.allviewit.backstage.common.HttpRequest;

import java.io.IOException;

/**
 * @Auther: wubing
 * @Date: 2019/4/3 10:39
 * @Description:
 */
@Controller
@RequestMapping("wxlogin")
public class WXLogin {

    String appid = "wx965549ffe0b8e536";
    String secret = "8472babea3229d10f558a5fae3cce415";
    String domain = "http://jiabao.jnaw.top";
    String openid;
    String access_token;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("i")
    public String index() {
        String redirect_uri = domain + "/wxlogin/getUserInfo";
        return "redirect:" + "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri="
                + UriUtils.encode(redirect_uri, "utf-8")
                + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }

    @RequestMapping("getUserInfo")
    public ModelAndView index(@RequestParam("code") String code) throws Exception {
        // 获取accesstoken
        StringBuilder accessTokenUrl = new StringBuilder();
        accessTokenUrl.append("appid=").append(appid).append("&secret=").append(secret).append("&code=").append(code)
                .append("&grant_type=authorization_code");
        String accessToken = HttpRequest.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token",
                accessTokenUrl.toString());
        JsonNode web_accessTokenJson;
        try {
            web_accessTokenJson = new ObjectMapper().readTree(accessToken);
            openid = web_accessTokenJson.path("openid").asText();
            access_token = web_accessTokenJson.path("access_token").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取用户基本信息
        StringBuilder userInfoUrl = new StringBuilder();
        userInfoUrl.append("access_token=").append(access_token).append("&openid=").append(openid)
                .append("&lang=zh_CN");
        String web_userInfoStr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/userinfo", userInfoUrl.toString());

        JsonNode web_userInfoJson = new ObjectMapper().readTree(web_userInfoStr);
        String nickname = web_userInfoJson.path("nickname").asText();
        String sex = web_userInfoJson.path("sex").asText();
        String city = web_userInfoJson.path("city").asText();
        String province = web_userInfoJson.path("province").asText();
        String country = web_userInfoJson.path("country").asText();
        String headimgurl = web_userInfoJson.path("headimgurl").asText();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("openid", openid);
        modelAndView.addObject("code", code);
        modelAndView.addObject("nickname", nickname);
        modelAndView.addObject("sex", sex);
        modelAndView.addObject("city", city);
        modelAndView.addObject("province", province);
        modelAndView.addObject("country", country);
        modelAndView.addObject("headimgurl", headimgurl);
        modelAndView.setViewName("wxbind");
        return modelAndView;
    }
}
