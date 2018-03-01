package team.lunch.planner.user.rest;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@ExposesResourceFor(UserDTO.class)
@CrossOrigin
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

}
