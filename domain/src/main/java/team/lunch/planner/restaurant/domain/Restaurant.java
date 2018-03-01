package team.lunch.planner.restaurant.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Restaurant {

    private final Long id;
    private final String name;
}
