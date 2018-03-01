package team.lunch.planner.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserService;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping
    public String register() {
        return "register";
    }
    
    @PostMapping
    public String createUser(@RequestParam String email,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String password,
            @RequestParam String passwordRepeat,
            Model model) {
        User user = userService.createUser(email, password, passwordRepeat, firstname, lastname);
        return user(user.getId(), model);
    }
    
    @GetMapping(path = "/{userId}")
    public String user(@PathVariable Long userId, Model model) {
        User user = userService.determineUser(userId);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping(path="/login")
    public String loginPage() {
        return "login";
    }
    
    @PostMapping(path="/login")
    public String login(Model model) {
        return user(userService.determineCurrentUser().getId(), model);
    }
}
