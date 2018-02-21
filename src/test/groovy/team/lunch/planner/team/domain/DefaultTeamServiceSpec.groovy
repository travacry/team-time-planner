package team.lunch.planner.team.domain

import spock.lang.Specification
import team.lunch.planner.user.domain.User

class DefaultTeamServiceSpec extends Specification {

    def 'selectNextUser selects the next user and clears all other information'() {
        given: 'a team'
        Member member1 = new Member(1, 4711, user1Turn, true)
        Member member2 = new Member(2, 4712, user2Turn, false)
        Member member3 = new Member(3, 4713, user3Turn, true)
        Lunch lunch = new Lunch(19, 'TAV')
        Team team = new Team(17, 'Crazy Crabs', [member1, member2, member3], lunch)

        and: 'a mocked TeamRepository'
        TeamRepository teamRepository = Mock(TeamRepository) {
            determineTeam(17) >> team
        }

        and: 'a TeamService'
        TeamService teamService = new DefaultTeamService(teamRepository);

        when: 'the next user is selected'
        teamService.selectNextUser(17)

        then:
        member1.isTurn() == expectedUser1Turn
        member2.isPresent() == false
        member2.isTurn() == expectedUser2Turn
        member2.isPresent() == false
        member3.isTurn() == expectedUser3Turn
        member3.isPresent() == false
        lunch.getRestaurant() == ''

        where:
        user1Turn | user2Turn | user3Turn || expectedUser1Turn | expectedUser2Turn | expectedUser3Turn
        true      | false     | false     || false             | true              | false
        false     | false     | true      || true              | false             | false
    }

    def 'user toggles participation for lunch'() {
        given: 'a team'
        Member member1 = new Member(1, 4711, true, true)
        Member member2 = new Member(2, 4712, false, false)
        Member member3 = new Member(3, 4713, false, true)
        Lunch lunch = new Lunch(19, 'TAV')
        Team team = new Team(17, 'Crazy Crabs', [member1, member2, member3], lunch)

        and: 'a mocked TeamRepository'
        TeamRepository teamRepository = Mock(TeamRepository) {
            determineTeam(17) >> team
        }

        and: 'a TeamService'
        TeamService teamService = new DefaultTeamService(teamRepository);

        when: 'the next user is selected'
        teamService.toggleParticipation(17, userId)

        then:
        member1.isPresent() == expectedParticipationUser1
        member1.isTurn() == true
        member2.isPresent() == expectedParticipationUser2
        member2.isTurn() == false
        member3.isPresent() == expectedParticipationUser3
        member3.isTurn() == false

        where:
        userId || expectedParticipationUser1 | expectedParticipationUser2 | expectedParticipationUser3
        2      || true                       | true                       | true
        3      || true                       | false                      | false
    }

    def 'restaurant is changed'() {
        given: 'a team'
        Lunch lunch = new Lunch(19, 'TAV')
        Team team = new Team(17, 'Crazy Crabs', [], lunch)

        and: 'a mocked TeamRepository'
        TeamRepository teamRepository = Mock(TeamRepository) {
            determineTeam(17) >> team
        }

        and: 'a TeamService'
        TeamService teamService = new DefaultTeamService(teamRepository);

        when: 'the restaurant is changed'
        teamService.setRestaurant(17, 'New restaurant')

        then:
        lunch.getRestaurant() == 'New restaurant'
    }
}
