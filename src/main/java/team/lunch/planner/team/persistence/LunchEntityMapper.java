package team.lunch.planner.team.persistence;

import org.springframework.stereotype.Component;

import team.lunch.planner.team.domain.Lunch;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class LunchEntityMapper {

    public Lunch map(LunchEntity lunch) {
        return new Lunch(lunch.getId(), lunch.getRestaurant());
    }

    public LunchEntity map(Lunch lunch) {
        return new LunchEntity(lunch.getId(), lunch.getRestaurant());
    }
}
