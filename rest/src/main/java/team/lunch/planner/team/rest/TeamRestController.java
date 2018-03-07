package team.lunch.planner.team.rest;

import java.util.List;
import java.util.stream.Collectors;

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
import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamService;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserService;

@RestController
@ExposesResourceFor(TeamDTO.class)
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamRestController extends AbstractController {
    
    private final UserService userService;
    private final TeamService teamService;
    private final TeamDTOMapper teamDTOMapper;
    private final TeamResourceProcessor teamResourceProcessor;
    
    @GetMapping(produces="application/json")
    public ResponseEntity<List<Resource<TeamDTO>>> getTeams() {
        User currentUser = userService.determineCurrentUser();
        
        return ResponseEntity.ok(teamService.determineTeams(currentUser.getId()).stream()
                .map(teamDTOMapper::map)
                .map(team -> createResource(team, teamResourceProcessor))
                .collect(Collectors.toList()));
    }
    
    @PostMapping(produces="application/json")
    public ResponseEntity<Resource<TeamDTO>> createTeam(@RequestBody TeamDTO teamDTO) {
        User currentUser = userService.determineCurrentUser();
        
        Team team = teamDTOMapper.map(teamDTO);
        return ResponseEntity.ok(createResource(teamDTOMapper.map(teamService.saveTeam(team)), teamResourceProcessor));
    }

}
