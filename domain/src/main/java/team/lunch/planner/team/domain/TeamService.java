package team.lunch.planner.team.domain;

import java.util.List;

public interface TeamService {
    
    Team saveTeam(Team team);

    Team determineTeam(Long teamId);

    List<Team> determineTeams(Long userId);

    void selectNextUser(Long teamId);

    List<Team> determineAllTeams();

    void setRestaurant(Long teamId, String restaurant);

    void toggleParticipation(Long teamId, Long participantId);
}
