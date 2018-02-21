package team.lunch.planner.team.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Member;
import team.lunch.planner.team.domain.Team;

@Component
@RequiredArgsConstructor
class TeamEntityMapper {

    private final MemberEntityMapper memberEntityMapper;
    private final LunchEntityMapper lunchEntityMapper;

    public Team map(TeamEntity teamEntity) {
        List<Member> members = teamEntity.getMembers().stream()
                .map(memberEntityMapper::map)
//                .sorted(Comparator.comparing(User::getFirstname))
                .collect(Collectors.toList());

        Lunch lunch = lunchEntityMapper.map(teamEntity.getLunch());

        return new Team(teamEntity.getId(), teamEntity.getName(), members, lunch);
    }

    public TeamEntity map(Team team) {
        List<MemberEntity> members = team.getMembers().stream()
                .map(memberEntityMapper::map)
                .collect(Collectors.toList());

        LunchEntity lunch = lunchEntityMapper.map(team.getLunch());

        return new TeamEntity(team.getId(), team.getName(), members, lunch);
    }
}
