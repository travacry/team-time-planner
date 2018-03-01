package team.lunch.planner.user.domain;

public interface UserService {

    User determineCurrentUser();

    User determineUser(Long userId);

    void updateUser(User user);

    User createUser(String email, String password, String passwordRepeat, String firstname, String lastname);

}
