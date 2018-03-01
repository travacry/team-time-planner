package team.lunch.planner.team.domain;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Team {

    private final Long id;
    private final String name;
    private final List<Member> members;
    private final Lunch lunch;
}
