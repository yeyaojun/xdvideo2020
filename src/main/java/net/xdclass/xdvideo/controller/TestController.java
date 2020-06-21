package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.JsonData;
import net.xdclass.xdvideo.mapper.VidaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private VidaoMapper vidaoMapper;

    @RequestMapping("wechatConfigTest")
   public JsonData test(){

       System.out.print(weChatConfig.getAppid());

       return JsonData.buildSuccess(weChatConfig.getAppid());
   }

   @RequestMapping("test_mysql")
    public Object testMysql(){

        return vidaoMapper.findAll();
   }

}
