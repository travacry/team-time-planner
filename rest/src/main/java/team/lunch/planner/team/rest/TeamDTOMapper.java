package team.lunch.planner.team.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Team;

@Component
@RequiredArgsConstructor
class TeamDTOMapper {
    
    private final MemberDTOMapper memberDTOMapper;

    Team map(TeamDTO team) {
//        team.getMembers().stream().map(memberDTOMapper::map).collect(Collectors.toList());
        return new Team(team.getDatabaseId(), team.getName(), new ArrayList<>(), new Lunch(null, Collections.emptyList()));
    }
    
    TeamDTO map(Team team) {
        List<MemberDTO> members = team.getMembers().stream()
                .map(memberDTOMapper::map)
                .collect(Collectors.toList());
        return new TeamDTO(team.getId(), team.getName(), members);
    }
}
