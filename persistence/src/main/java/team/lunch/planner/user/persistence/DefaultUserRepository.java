package team.lunch.planner.user.persistence;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;
import team.lunch.planner.user.domain.UserRepository;

@Component
@RequiredArgsConstructor
class DefaultUserRepository implements UserRepository {

    private final UserEntityMapper userEntityMapper;
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> determineUser(String email) {
        return userEntityRepository.findByEmail(email)
                .map(userEntityMapper::map);
    }

    @Override
    public User createUser(String email, String password, String firstname, String lastname) {
        String encryptedPassword = passwordEncoder.encode(password);
        return userEntityMapper.map(userEntityRepository.save(new UserEntity(null, email, encryptedPassword, firstname, lastname)));
    }

    @Override
    public User determineCurrentUser() {
        return determineUser(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(IllegalStateException::new);
    }

    @Override
    public User determineUser(Long userId) {
        return userEntityRepository.findById(userId)
                .map(userEntityMapper::map)
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public void saveUser(User user) {
        userEntityRepository.save(userEntityMapper.map(user));
    }
}
