package team.lunch.planner.user.persistence;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserEntityMapper {

    public User map(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getFirstname(), userEntity.getLastname());
    }

    public UserEntity map(User user) {
        return new UserEntity(user.getId(), user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname());
    }
}
