package team.lunch.planner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.UserService;

@Controller
@RequiredArgsConstructor
public class AppController {
    
    private final UserService userService;

    @GetMapping(path="/")
    public String root() {
        return "index";
    }
    
    @GetMapping(path="/index")
    public String index() {
        return "index";
    }
    
    @GetMapping(path="/login")
    public String login() {
        return "login";
    }
    
    @GetMapping(path="/register")
    public String register() {
        return "register";
    }
    
    @PostMapping(path="/api/users")
    public String register(@RequestParam String email,
            @RequestParam String password,
            @RequestParam String passwordRepeat,
            @RequestParam String firstname,
            @RequestParam String lastname) {
        
        userService.createUser(email, password, passwordRepeat, firstname, lastname);
        return app();
    }
    
    @GetMapping(path="/app")
    public String app() {
        return "app";
    }

}
