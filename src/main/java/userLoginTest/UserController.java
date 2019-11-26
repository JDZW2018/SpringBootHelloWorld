package userLoginTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam("name") String name , @RequestParam("pwd") String pwd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = service.login(name, pwd);
        if(null != user){
            String username = user.getUsername();
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            return "success";
        }else {
            return "login Info error";
        }
    }
    @RequestMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        return "ok! welcome: "+username;
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

}
