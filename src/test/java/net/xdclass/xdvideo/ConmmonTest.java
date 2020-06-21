package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.Test;

public class ConmmonTest {

    @Test
    public void testGeneJwt(){
        User user = new User();
        user.setId(666);
        user.setName("YYJ");
        user.setHeadImg("http://b8.photo.store.qq.com/psu?/3753c83d-6b89-449c-aed9-36fa1e8cebc2/qMXTANEXTJ2PH7A3Xn2QI*kupx9rP7E*gDJvP8fKgDE!/b/Yd*bOQQIjwAAYtBtzwQfYwAA&a=7&b=8&bo=iwBoAAAAAAABAMQ!&rf=viewer_4");

        String token = JwtUtils.geneJsonWebToken(user);
        System.out.print(token);
    }

    @Test
    public void testCheck(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjY2NiwibmFtZSI6IllZSiIsImltZyI6Imh0dHA6Ly9iOC5waG90by5zdG9yZS5xcS5jb20vcHN1Py8zNzUzYzgzZC02Yjg5LTQ0OWMtYWVkOS0zNmZhMWU4Y2ViYzIvcU1YVEFORVhUSjJQSDdBM1huMlFJKmt1cHg5clA3RSpnREp2UDhmS2dERSEvYi9ZZCpiT1FRSWp3QUFZdEJ0endRZll3QUEmYT03JmI9OCZibz1pd0JvQUFBQUFBQUJBTVEhJnJmPXZpZXdlcl80IiwiaWF0IjoxNTkxMzI4MjMwLCJleHAiOjE1OTE5MzMwMzB9.TqnSVd8zhgm6D9bCsndB8VD452Uo2XrlC3mR-p_6Wsc";
        Claims claims = JwtUtils.checkJwt(token);

        if(claims != null){
            String name = (String) claims.get("name");
            String img = (String) claims.get("img");
            int id = (Integer) claims.get("id");
            System.out.println("用户名称:"+name);
            System.out.println("用户头像:"+img);
            System.out.println("用户编号:"+id);

        }else {

            System.out.print("非法token");
        }

    }
}
