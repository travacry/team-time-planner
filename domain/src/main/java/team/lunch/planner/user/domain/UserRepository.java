package team.lunch.planner.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> determineUser(String email);

    User createUser(String email, String password, String firstname, String lastname);

    User determineCurrentUser();

    User determineUser(Long userId);

    void saveUser(User user);
}
