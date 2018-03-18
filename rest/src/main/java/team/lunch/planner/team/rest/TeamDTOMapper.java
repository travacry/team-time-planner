package team.lunch.planner.team.rest;

import java.util.Collections;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Team;

@Component
@RequiredArgsConstructor
class TeamDTOMapper {
    
    private final MemberDTOMapper memberDTOMapper;

    Team map(TeamDTO team) {
        return new Team(team.getDatabaseId(), team.getName(), Collections.emptyList(), null);
    }
    
    TeamDTO map(Team team) {
        return new TeamDTO(team.getId(), team.getName(), Collections.emptyList());
    }
}
