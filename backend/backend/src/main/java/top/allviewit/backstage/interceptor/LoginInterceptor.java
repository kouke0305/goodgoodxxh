package top.allviewit.backstage.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger loger= LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        // 获取微信小程序skey
        Boolean sKey= StringUtils.isEmpty(request.getHeader("sKey"));

//        Boolean session_emp = StringUtils.isEmpty(session.getAttribute("emp"));
        Boolean session_emp = false;

        // 有一个凭证
        if(!sKey || !session_emp){
            System.out.println("用户已登录");
            return true ;

        }else {
            System.out.println("被拦截了");
//            //重置response
//            response.reset();
//            //设置编码格式
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json;charset=UTF-8");

            response.sendRedirect("/login");

//            PrintWriter pw = response.getWriter();
//            pw.write("用户未登录");
//            pw.flush();
//            pw.close();
            //loger.error("用户未登录！");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
