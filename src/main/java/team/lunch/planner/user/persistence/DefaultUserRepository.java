package team.lunch.planner.user.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserRepository;

@Component
@RequiredArgsConstructor
class DefaultUserRepository implements UserRepository {

    @Override
    public Optional<User> determineUser(String email) {
        return Optional.empty();
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User determineCurrentUser() {
        return null;
    }

    @Override
    public User determineUser(Long userId) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
