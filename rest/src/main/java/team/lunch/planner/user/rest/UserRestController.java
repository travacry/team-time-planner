package team.lunch.planner.user.rest;

import java.util.Map;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.AbstractController;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserService;

@RestController
@ExposesResourceFor(UserDTO.class)
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController extends AbstractController {
    
    private final UserService userService;
    private final UserDTOMapper userDTOMapper;
    private final UserResourceProcessor userResourceProcessor;
    
    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Resource<UserDTO>> createUser(@RequestBody Map<String, String> properties) {
        String email = properties.get("email");
        String password = properties.get("password");
        String passwordRepeat = properties.get("passwordRepeat");
        String firstname = properties.get("firstname");
        String lastname = properties.get("lastname");
        User user = userService.createUser(email, password, passwordRepeat, firstname, lastname);
        return ResponseEntity.ok(createResource(userDTOMapper.map(user), userResourceProcessor));
    }
    
    @GetMapping(path="/login", consumes="application/json", produces="application/json")
    public ResponseEntity<Resource<UserDTO>> login() {
        User user = userService.determineCurrentUser();
        return ResponseEntity.ok(createResource(userDTOMapper.map(user), userResourceProcessor));
    }
}
