package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.Service.UserService;
import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/v1/wechat")
public class WeChatController {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private UserService userService;

    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true) String accessPage) throws UnsupportedEncodingException {

        String redirectUrl = weChatConfig.getOpenRedirectUrl();//获取微信开放平台重定向地址

        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");//进行编码

        String qrcodeUrl = String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppid(),callbackUrl,accessPage);

        return JsonData.buildSuccess(qrcodeUrl);
    }

    @GetMapping("/user/callback")
    public void wechatUserCallback(@RequestParam(value = "code",required = true) String code,
                                   String state, HttpServletResponse response){

        userService.saveWechatUser(code);

    }

}
