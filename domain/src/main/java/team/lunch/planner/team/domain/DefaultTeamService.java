package team.lunch.planner.team.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;

@RequiredArgsConstructor
public class DefaultTeamService implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Team determineTeam(Long teamId) {
        return teamRepository.determineTeam(teamId);
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
