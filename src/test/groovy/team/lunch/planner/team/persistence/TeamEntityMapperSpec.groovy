package team.lunch.planner.team.persistence

import spock.lang.Specification
import team.lunch.planner.team.domain.Team
import team.lunch.planner.user.persistence.UserEntity

class TeamEntityMapperSpec extends Specification {

    def 'TeamEntity is mapped to Team'() {
        given: 'a TeamEntity'
        MemberEntity user1 = new MemberEntity(1, 4711, true, true)
        MemberEntity user2 = new MemberEntity(2, 4712, false, false)
        LunchEntity lunch = new LunchEntity(19, 'TAV')
        TeamEntity teamEntity = new TeamEntity(17, 'Crazy Crabs', [user1, user2], lunch)

        and: 'a UserEntityMapper'
        MemberEntityMapper userEntityMapper = new MemberEntityMapper()

        and: 'a LunchEntityMapper'
        LunchEntityMapper lunchEntityMapper = new LunchEntityMapper()

        and: 'a TeamEntityMapper'
        TeamEntityMapper teamEntityMapper = new TeamEntityMapper(userEntityMapper, lunchEntityMapper)

        when:
        Team team = teamEntityMapper.map(teamEntity)

        then:
        team.getId() == teamEntity.getId()
    }
}
