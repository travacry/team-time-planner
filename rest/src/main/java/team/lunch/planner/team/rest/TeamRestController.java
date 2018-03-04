package team.lunch.planner.team.rest;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.AbstractController;

@RestController
@ExposesResourceFor(TeamDTO.class)
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamRestController extends AbstractController {

}
