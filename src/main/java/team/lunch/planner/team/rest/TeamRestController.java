package team.lunch.planner.team.rest;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@ExposesResourceFor(TeamDTO.class)
@CrossOrigin
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamRestController {

}
