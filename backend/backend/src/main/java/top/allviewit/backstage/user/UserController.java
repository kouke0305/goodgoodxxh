package top.allviewit.backstage.user;

import com.alibaba.fastjson.JSON;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.allviewit.backstage.common.HttpRequest;
import top.allviewit.backstage.common.RedisOperator;
import top.allviewit.backstage.common.RespModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/weapp")
public class UserController {
    @Autowired
    UserDao userDao;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private RedisOperator redis;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //微信登陆
    @GetMapping("/login")
    public RespModel wxLogin(String code) {

        System.out.println("wxlogin - code: " + code);

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpRequest.doGet(url, param);
        System.out.println(wxResult);

        // 将json 字符串转换为对象
        WXSessionModel model = JSON.parseObject(wxResult,WXSessionModel.class);

        // 存入session到redis
//        redis.set("key:" + model.getOpenid(),
//                model.getSession_key());

        CodeAndStatusVoModel codeAndStatusVoModel=new CodeAndStatusVoModel();
        codeAndStatusVoModel.setSkey("key:"+model.getOpenid());
        // 查询此用户是否绑定账号
        UserModel user=userDao.getAppOpenIdUser(model.getOpenid());
        if(user==null) {
            codeAndStatusVoModel.setUserid("0");
        }else {
            codeAndStatusVoModel.setUserid(user.getId().toString());
        }
        System.out.println(codeAndStatusVoModel);
        return  new RespModel(true,"登录结果",codeAndStatusVoModel);
    }

    //获取用户信息存到微信
    @GetMapping("/getUserInfo")
    public RespModel getUserInfo(String userid){
        Integer uid = Integer.parseInt(userid);
        String openid=request.getHeader("sKey").substring(4);
        // 查询数据库中用户是否存在
        UserModel user=userDao.getUserByuserId(uid);
        return new RespModel(true,"用户信息",user);
    }

    //微信绑定
    @GetMapping("/bindingUserCode")
    public RespModel bindingAppUserCode(String phone,String username){
        // source 来源 1：小程序     2：PC

        String openid=request.getHeader("sKey").substring(4);
        UserModel userModel = userDao.selectUserByPhone(phone);
        if(userModel!=null) {
            // 查询数据库中用户是否存在
            userDao.updateAppUserOpenId(phone, openid);
        }else{
            // 添加用户
            UserModel user = new UserModel();
            user.setPhone(phone);
            user.setApp_openid(openid);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(timeZone);
            user.setCreatetime(simpleDateFormat.format(new Date()));
//            user.setName(username);
            userDao.insertTemplate(user);
        }
        UserModel user= userDao.getAppOpenIdUser(openid);

        return new RespModel(true,"绑定结果",(user!=null?user.getId():0));
    }

    @RequestMapping("/user")
    public RespModel authorization(@RequestParam("id") Integer id){
        UserModel userModel = userDao.selectuserinfo(id);

        return new RespModel(true,"success","操作成功");
    }

    //将验证码添加到消息组件(发短信)
    @RequestMapping("/sendSMS")
    public RespModel sendSMS(@RequestParam("phone") String phone){
        //发送短信  进组件
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        NoteBean nb = new NoteBean();
        nb.setStatus("8");
        nb.setPhone(phone);
        nb.setSnumber(verifyCode);
        rabbitTemplate.convertAndSend("sim.dispatch", JSON.toJSONString(nb));
        return new RespModel(true,"success",verifyCode);
    }

    /**
     * 判断某个字符是不是表情
     * @param codePoint
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
}
