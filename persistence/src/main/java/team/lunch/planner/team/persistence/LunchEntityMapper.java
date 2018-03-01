package team.lunch.planner.team.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Member;

@Component
@RequiredArgsConstructor
class LunchEntityMapper {
    
    private final MemberEntityMapper memberEntityMapper;

    public Lunch map(LunchEntity lunch) {
        List<Member> participants = lunch.getParticipants().stream()
                .map(memberEntityMapper::map)
                .collect(Collectors.toList());
        return new Lunch(lunch.getId(), participants, lunch.getRestaurant());
    }

    public LunchEntity map(Lunch lunch) {
        List<MemberEntity> participants = lunch.getParticipants().stream()
                .map(memberEntityMapper::map)
                .collect(Collectors.toList());
        return new LunchEntity(lunch.getId(), participants, lunch.getRestaurant());
    }
}
