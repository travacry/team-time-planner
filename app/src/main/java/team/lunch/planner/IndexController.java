package team.lunch.planner;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final TeamService teamService;

    @GetMapping("/")
    public String index(Model model) {
        List<Team> teams = teamService.determineAllTeams();

        model.addAttribute("teams", teams);

        return "index";
    }


}
