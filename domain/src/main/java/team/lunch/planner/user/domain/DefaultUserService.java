package team.lunch.planner.user.domain;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserService implements UserService  {

    private final UserRepository userRepository;

    public User determineCurrentUser() {
        return userRepository.determineCurrentUser();
    }

    public User determineUser(Long userId) {
        return userRepository.determineUser(userId);
    }

    public void updateUser(User user) {
        userRepository.saveUser(user);
    }

    public User createUser(String email, String password, String passwordRepeat, String firstname, String lastname) {
        Preconditions.checkArgument(Objects.equal(password, passwordRepeat));
        Preconditions.checkArgument(!userRepository.determineUser(email).isPresent());

        return userRepository.createUser(email, password, firstname, lastname);
    }

//    public void invite(String email, User sender) {
//        User user = userRepository.determineUser(email).orElseThrow(() -> new IllegalStateException("no user with email [" + email + "]"));
//        user.addInvitation(new Invitation(null, sender.getHouseholdId(), sender.getEmail()));
//        userRepository.saveUser(user);
//    }
//
//    public void rejectInvitation(Long userId, Long invitationId) {
//        User user = userRepository.determineUser(userId);
//        user.rejectInvitation(invitationId);
//        userRepository.saveUser(user);
//    }
//
//    public void acceptInvitation(Long userId, Long invitationId) {
//        User user = userRepository.determineUser(userId);
//        user.acceptInvitation(invitationId);
//        userRepository.saveUser(user);
//    }
}
