package team.lunch.planner.team.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import team.lunch.planner.team.domain.Team;
import team.lunch.planner.team.domain.TeamRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class DefaultTeamRepository implements TeamRepository {

    private final TeamEntityRepository teamEntityRepository;
    private final TeamEntityMapper teamEntityMapper;

    @Override
    public Team determineTeam(Long id) {
        return teamEntityMapper.map(teamEntityRepository.findOne(id));
    }

    @Override
    public void save(Team team) {
        teamEntityRepository.save(teamEntityMapper.map(team));
    }

    @Override
    public List<Team> determineAllTeams() {
        return teamEntityRepository.findAll().stream()
                .map(teamEntityMapper::map)
                .collect(Collectors.toList());
    }
}
