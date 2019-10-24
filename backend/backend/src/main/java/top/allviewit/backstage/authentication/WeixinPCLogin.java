//package top.allviewit.backstage.authentication;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import top.allviewit.backstage.common.HttpRequest;
//import top.allviewit.backstage.testauthentication.TestCodeDao;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
///**
// * @author: Chunle Tian
// * @create: 2019/03/12 15:05
// * @description: PC端微信登录
// **/
//@Controller
//public class WeixinPCLogin {
//
//    @Value("${wx.openAppid}")
//    private String openAppid;
//
//    @Value("${wx.openSecret}")
//    private String openSecret;
//    @Autowired
//    TestCodeDao testCodeDao;
//
//    @RequestMapping("/login")
//    public String login() {
//        System.out.println("login");
//        return "login";
//    }
//
//    @RequestMapping("/")
//    public String defaultIndex() {
//        System.out.println("/");
//        return "index";
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        System.out.println("index");
//        return "index";
//    }
//
//    @RequestMapping("/getUserInfo")
//    public String getUserInfo(String code, String state, HttpServletRequest req, HttpServletResponse response,
//            ModelMap modelMap) {
//        System.out.println("getuserinfo");
//        // String code = req.getParameter("code");
//
//        JsonNode web_userInfoJson = null;
//
//        HttpSession session = req.getSession();
//        try {
//            // 获取openid,access_token
//            StringBuilder accessTokenUrl = new StringBuilder();
//            accessTokenUrl.append("appid=").append(openAppid).append("&secret=").append(openSecret).append("&code=")
//                    .append(code).append("&grant_type=authorization_code");
//            // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
//
//            String web_accessTokenStr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token",
//                    accessTokenUrl.toString());
//
//            JsonNode web_accessTokenJson = null;
//
//            web_accessTokenJson = new ObjectMapper().readTree(web_accessTokenStr);
//
//            String openid = web_accessTokenJson.path("openid").asText();
//            String access_token = web_accessTokenJson.path("access_token").asText();
//
//            // 获取用户基本信息
//            StringBuilder userInfoUrl = new StringBuilder();
//            userInfoUrl.append("access_token=").append(access_token).append("&openid=").append(openid)
//                    .append("&lang=zh_CN");
//            String web_userInfoStr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/userinfo",
//                    userInfoUrl.toString());
//
//            web_userInfoJson = new ObjectMapper().readTree(web_userInfoStr);
//            String nickname = web_userInfoJson.path("nickname").asText();
//            String headimgurl = web_userInfoJson.path("headimgurl").asText();
//            String unionid = web_userInfoJson.path("unionid").asText();
//
//        } catch (IOException e) {
//            System.out.println("从微信获取用户数据出错了呦~！");
//        }
//        String openid = web_userInfoJson.path("openid").asText();
//        String nickname = web_userInfoJson.path("nickname").asText();
//        String headimgurl = web_userInfoJson.path("headimgurl").asText();
//        String unionid = web_userInfoJson.path("unionid").asText();
//
//        // 使用pc_openid 查询用户信息 查询用户信息
//        return unionid;
//    }
//
//    @RequestMapping("/checkLogin")
//    public String checkLogin(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        // session.setAttribute("emp",null);
//        // session.removeAttribute("emp");
//        return "redirect:login";
//
//    }
//
//    @RequestMapping(value = "/binding")
//    public String binding(HttpServletRequest req, HttpServletResponse response, ModelMap modelMap) {
//        System.out.println("binding");
//        HttpSession session = req.getSession();
//
//        String openid = req.getParameter("openid");
//        String phone = req.getParameter("phone");
//        String bcode = req.getParameter("bcode");
//
//        System.out.println(phone + ",,,绑定信息,," + bcode);
//        if (bcode == null || phone == null) {
//            modelMap.put("errorMsg", "请输入手机号或绑定码");
//            return "binding";
//        }
//
//        modelMap.put("openid", openid);
//        modelMap.put("errorMsg", "绑定码错误，请重新绑定！");
//        return "binding";
//    }
//
//    public String getMd5(String plainText) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(plainText.getBytes());
//            byte b[] = md.digest();
//
//            int i;
//
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");
//                buf.append(Integer.toHexString(i));
//            }
//            // 32位加密
//            return buf.toString();
//            // 16位的加密
//            // return buf.toString().substring(8, 24);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//}
