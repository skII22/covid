package Covid.Controller;

import Covid.model.User;
import Covid.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userlogin")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String login(@RequestBody User loginform){
        String message = userService.login(loginform);
        return message;
    }
    @PostMapping("/register")
    public String register(@RequestBody User Reuser){
        return userService.register(Reuser);
    }
}
