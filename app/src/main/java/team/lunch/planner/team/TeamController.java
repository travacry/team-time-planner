package team.lunch.planner.team;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Member;
import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamService;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserService;

@Controller
@RequestMapping(path = "/teams")
@RequiredArgsConstructor
public class TeamController {
    
    private final TeamService teamService;
    private final UserService userService;

    @PostMapping
    public String createTeam(@RequestParam String name, Model model) {
        User user = userService.determineCurrentUser();
        List<Member> members = Collections.singletonList(new Member(null, user.getId()));
        Team team = teamService.saveTeam(new Team(null, name, members, new Lunch(null, Collections.emptyList())));
        model.addAttribute("team", team);
        return "team";
    }
}
