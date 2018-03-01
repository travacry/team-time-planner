package team.lunch.planner.user.persistence

import spock.lang.Specification
import team.lunch.planner.team.persistence.MemberEntityMapper
import team.lunch.planner.user.domain.User
import team.lunch.planner.user.persistence.UserEntity

class UserEntityMapperSpec extends Specification {

    def 'map UserEntity to User'() {
        given: 'a UserEntity'
        UserEntity userEntity = new UserEntity(id, email, password, firstname, lastname)

        and: 'a UserEntityMapper'
        UserEntityMapper userEntityMapper = new UserEntityMapper()

        when: 'the UserEntity is mapped'
        User user = userEntityMapper.map(userEntity)

        then: 'the User has the correct values'
        user.getId() == userEntity.getId()
        user.getLastname() == userEntity.getLastname()
        user.getFirstname() == userEntity.getFirstname()
        user.getEmail() == userEntity.getEmail()
        user.getPassword() == userEntity.getPassword()

        where:
        id | lastname    | firstname  | email  | password
        17 | 'Nachname1' | 'Vorname1' | 'user@email.de'  | '12345678'
    }

    def 'map User to UserEntity'() {
        given: 'a User'
        User user = new User(id, email, password, firstname, lastname)

        and: 'a UserEntityMapper'
        UserEntityMapper userEntityMapper = new UserEntityMapper()

        when: 'the User is mapped'
        UserEntity userEntity = userEntityMapper.map(user)

        then: 'the User has the correct values'
        userEntity.getId() == user.getId()
        userEntity.getLastname() == user.getLastname()
        userEntity.getFirstname() == user.getFirstname()
        userEntity.getEmail() == user.getEmail()
        userEntity.getPassword() == user.getPassword()

        where:
        id | lastname    | firstname  | email  | password
        17 | 'Nachname1' | 'Vorname1' | 'user@email.de'  | '12345678'
    }
}
