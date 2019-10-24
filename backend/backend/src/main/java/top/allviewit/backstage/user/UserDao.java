package top.allviewit.backstage.user;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao extends BaseMapper<UserModel> {


    UserModel selectuserinfo( @Param("id")Integer id);

    UserModel getAppOpenIdUser(@Param("openid")String openid);

    UserModel getUserByuserId(@Param("userid")Integer userid);

    void updateAppUserOpenId(@Param("phone")String phone, @Param("openid")String openid);

    UserModel selectUserByPhone(@Param("phone")String phone);
}

