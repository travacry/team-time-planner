package team.lunch.planner.team.persistence

import spock.lang.Specification
import team.lunch.planner.team.domain.Lunch

class LunchEntityMapperSpec extends Specification {

    def 'map LunchEntity to Lunch'() {
        given: 'a LunchEntity'
        LunchEntity lunchEntity = new LunchEntity(id, restaurant)

        and: 'a LunchEntityMapper'
        LunchEntityMapper lunchEntityMapper = new LunchEntityMapper();

        when: 'a LunchEntity is mapped'
        Lunch lunch = lunchEntityMapper.map(lunchEntity)

        then:
        lunch.getId() == lunchEntity.getId()
        lunch.getRestaurant() == lunchEntity.getRestaurant()

        where:
        id | restaurant
        17 | 'TAV'
    }

    def 'map Lunch to LunchEntity'() {
        given: 'a Lunch'
        Lunch lunchEntity = new Lunch(id, restaurant)

        and: 'a LunchEntityMapper'
        LunchEntityMapper lunchEntityMapper = new LunchEntityMapper();

        when: 'a Lunch is mapped'
        LunchEntity lunch = lunchEntityMapper.map(lunchEntity)

        then:
        lunch.getId() == lunchEntity.getId()
        lunch.getRestaurant() == lunchEntity.getRestaurant()

        where:
        id | restaurant
        17 | 'TAV'
    }
}
