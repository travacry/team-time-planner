package team.lunch.planner.team.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Lunch implements TeamEvent {

    private static final String LUNCH_NAME = "Team lunch";
    
    private final Long id;
    private final List<Member> participants;
    private String restaurant;
    
    @Override
    public String getName() {
        return LUNCH_NAME;
    }
}
