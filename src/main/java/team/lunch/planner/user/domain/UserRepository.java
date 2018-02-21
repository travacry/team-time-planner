package team.lunch.planner.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> determineUser(String email);

    User createUser(User user);

    User determineCurrentUser();

    User determineUser(Long userId);

    void saveUser(User user);
}
