package team.lunch.planner.team.domain;

import java.util.List;

public interface TeamRepository {

    Team determineTeam(Long id);

    void save(Team team);

    List<Team> determineAllTeams();
}
