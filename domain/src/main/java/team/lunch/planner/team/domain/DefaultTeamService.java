package team.lunch.planner.team.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import com.google.common.eventbus.EventBus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DefaultTeamService implements TeamService {

    private final TeamRepository teamRepository;
    private final EventBus eventBus;
    
    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> determineTeam(Long userId, Long teamId) {
        return Optional
                .of(teamRepository.determineTeam(teamId))
                .filter(team -> membersContainCurrentUser(team.getMembers(), userId));
    }
    
    private boolean membersContainCurrentUser(List<Member> members, Long userId) {
        return members.stream()
                .filter(member -> Objects.equals(userId, member.getUserId()))
                .findAny()
                .isPresent();
    }

    @Override
    public List<Team> determineTeams(Long userId) {
        return teamRepository.determineTeams(userId);
    }

    @Override
    public void selectNextUser(Long teamId) {
        Team team = determineTeam(teamId);
        List<Member> members = team.getMembers();
        int currentIndex = IntStream.range(0, members.size())
                .filter(i -> members.get(i).isTurn())
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        int nextIndex = determineNextIndex(currentIndex, members.size());

        members.get(currentIndex).setTurn(false);
        members.get(nextIndex).setTurn(true);

        members.forEach(user -> user.setPresent(false));

        Lunch lunch = team.getLunch();
        lunch.setRestaurant("");

        teamRepository.save(team);
    }
    
    private Team determineTeam(Long teamId) {
        // TODO: to be deleted
        return teamRepository.determineTeam(teamId);
    }

    @Override
    public List<Team> determineAllTeams() {
        return teamRepository.determineAllTeams();
    }

    @Override
    public void setRestaurant(Long teamId, String restaurant) {
        Team team = determineTeam(teamId);
        team.getLunch().setRestaurant(restaurant);
        teamRepository.save(team);
    }

    @Override
    public void toggleParticipation(Long teamId, Long participantId) {
        Team team = determineTeam(teamId);
        team.getMembers().stream()
                .filter(member -> Objects.equals(member.getId(), participantId))
                .findFirst()
                .ifPresent(user -> user.setPresent(!user.isPresent()));
        teamRepository.save(team);
    }

    private int determineNextIndex(int currentIndex, int size) {
        return currentIndex == (size - 1) ? 0 : currentIndex + 1;
    }
}
