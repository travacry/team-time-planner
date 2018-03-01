package team.lunch.planner.team.domain;

import java.util.List;

public interface TeamService {

    Team determineTeam(Long teamId);

    void selectNextUser(Long teamId);

    List<Team> determineAllTeams();

    void setRestaurant(Long teamId, String restaurant);

    void toggleParticipation(Long teamId, Long participantId);
}
