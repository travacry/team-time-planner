package team.lunch.planner.team.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Lunch;
import team.lunch.planner.team.domain.Member;

@RequiredArgsConstructor
@Component
class LunchDTOMapper {
    
    private final MemberDTOMapper memberDTOMapper;

    Lunch map(LunchDTO lunch) {
        List<Member> participants = lunch.getParticipants().stream()
                .map(memberDTOMapper::map)
                .collect(Collectors.toList());
        
        return new Lunch(lunch.getDatabaseId(), participants, lunch.getRestaurant());
    }
    
    LunchDTO map(Lunch lunch) {
        List<MemberDTO> participants = lunch.getParticipants().stream()
                .map(memberDTOMapper::map)
                .collect(Collectors.toList());
        
        return new LunchDTO(lunch.getId(), participants, lunch.getRestaurant());
    }
}
