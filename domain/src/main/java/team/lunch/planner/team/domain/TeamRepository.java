package team.lunch.planner.team.domain;

import java.util.List;

public interface TeamRepository {

    Team determineTeam(Long id);
    
    List<Team> determineTeams(Long userId);

    Team save(Team team);

    List<Team> determineAllTeams();
}
