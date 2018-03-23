package team.lunch.planner.team.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Member;
import team.lunch.planner.team.domain.Team;

@Component
@RequiredArgsConstructor
class TeamDTOMapper {
    
    private final MemberDTOMapper memberDTOMapper;
    private final LunchDTOMapper lunchDTOMapper;

    Team map(TeamDTO team) {
        List<Member> members = team.getMembers().stream()
                .map(memberDTOMapper::map)
                .collect(Collectors.toList());
        Lunch lunch = lunchDTOMapper.map(team.getLunch());
        return new Team(team.getDatabaseId(), team.getName(), members, lunch);
    }
    
    TeamDTO map(Team team) {
        List<MemberDTO> members = team.getMembers().stream()
                .map(memberDTOMapper::map)
                .collect(Collectors.toList());
        LunchDTO lunch = lunchDTOMapper.map(team.getLunch());
        return new TeamDTO(team.getId(), team.getName(), members, lunch);
    }
}
