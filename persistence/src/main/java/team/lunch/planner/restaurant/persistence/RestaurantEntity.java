package team.lunch.planner.restaurant.persistence;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
class RestaurantEntity {

    @Id
    @GeneratedValue
    private final Long id;
    private final String name;
    
    RestaurantEntity() {
        this(null, "");
    }
}
