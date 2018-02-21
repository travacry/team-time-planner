package team.lunch.planner.team;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team.lunch.planner.team.domain.TeamService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{teamId}")
    public String index(@PathVariable Long teamId, Model model) {
        Preconditions.checkArgument(teamId != null);

        model.addAttribute("team", teamService.determineTeam(teamId));
        return "team";
    }

    @PostMapping("/{teamId}")
    public String next(@PathVariable Long teamId, Model model) {
        Preconditions.checkArgument(teamId != null);

        teamService.selectNextUser(teamId);
        return index(teamId, model);
    }

    @PostMapping("/{teamId}/participants/{participantId}")
    public String takePart(@PathVariable Long teamId, @PathVariable Long participantId, Model model) {
        Preconditions.checkArgument(teamId != null);
        Preconditions.checkArgument(participantId != null);

        teamService.toggleParticipation(teamId, participantId);
        return index(teamId, model);
    }

    @PostMapping("/{teamId}/lunch")
    public String saveRestaurant(@PathVariable Long teamId, @RequestParam(value="restaurant") String restaurant, Model model) {
        Preconditions.checkArgument(teamId != null);

        teamService.setRestaurant(teamId, restaurant);
        return index(teamId, model);
    }
}
