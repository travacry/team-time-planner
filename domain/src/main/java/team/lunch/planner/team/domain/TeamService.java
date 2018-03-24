package team.lunch.planner.team.domain;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    
    Team createTeam(Long userId, String teamName);

    Optional<Team> determineTeam(Long userId, Long teamId);

    List<Team> determineTeams(Long userId);

    void selectNextUser(Long teamId);

    List<Team> determineAllTeams();

    void setRestaurant(Long teamId, String restaurant);

    void toggleParticipation(Long teamId, Long participantId);
}
