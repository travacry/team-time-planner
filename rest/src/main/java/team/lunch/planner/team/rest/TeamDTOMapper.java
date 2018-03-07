package team.lunch.planner.team.rest;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Team;

@Component
@RequiredArgsConstructor
class TeamDTOMapper {
    
    private final MemberDTOMapper memberDTOMapper;

    Team map(TeamDTO team) {
        return null;
    }
    
    TeamDTO map(Team team) {
        return new TeamDTO(team.getId(), team.getName());
    }
}
