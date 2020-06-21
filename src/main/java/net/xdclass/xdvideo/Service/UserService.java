package net.xdclass.xdvideo.Service;

        import net.xdclass.xdvideo.domain.User;

/**
 * 用户业务接口类
 */
public interface UserService {

    User saveWechatUser(String code);

}
