package team.lunch.planner.team.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.AbstractController;
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
    
    @GetMapping(path="/{teamId}", produces="application/json")
    public ResponseEntity<Resource<TeamDTO>> getTeam(@PathVariable Long teamId) {
        User currentUser = userService.determineCurrentUser();
        
        return teamService.determineTeam(currentUser.getId(), teamId)
                .map(teamDTOMapper::map)
                .map(team -> ResponseEntity.ok(createResource(team, teamResourceProcessor)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
    
    @PostMapping(produces="application/json")
    public ResponseEntity<Resource<TeamDTO>> createTeam(@RequestBody TeamDTO teamDTO) {
        User currentUser = userService.determineCurrentUser();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createResource(teamDTOMapper.map(teamService.createTeam(currentUser.getId(), teamDTO.getName())), teamResourceProcessor));
    }

}
