package team.lunch.planner.team.persistence;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamRepository;

@Component
@RequiredArgsConstructor
class DefaultTeamRepository implements TeamRepository {

    private final TeamEntityRepository teamEntityRepository;
    private final TeamEntityMapper teamEntityMapper;

    @Override
    public Team determineTeam(Long id) {
        return teamEntityRepository.findById(id)
                .map(teamEntityMapper::map)
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public List<Team> determineTeams(Long userId) {
        return teamEntityRepository.findAll().stream()
                .filter(team -> isUserAMember(team, userId))
                .map(teamEntityMapper::map)
                .collect(Collectors.toList());
    }
    
    private boolean isUserAMember(TeamEntity team, Long userId) {
        return team.getMembers().stream()
                .anyMatch(member -> Objects.equals(userId, member.getUserId()));
    }

    @Override
    public Team save(Team team) {
        return teamEntityMapper.map(teamEntityRepository.save(teamEntityMapper.map(team)));
    }

    @Override
    public List<Team> determineAllTeams() {
        return teamEntityRepository.findAll().stream()
                .map(teamEntityMapper::map)
                .collect(Collectors.toList());
    }
}
