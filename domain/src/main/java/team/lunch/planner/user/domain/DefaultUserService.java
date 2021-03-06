package team.lunch.planner.user.domain;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.events.UserCreatedEvent;
import team.lunch.planner.user.domain.events.UserUpdatedEvent;

@RequiredArgsConstructor
class DefaultUserService implements UserService  {

    private final UserRepository userRepository;
    private final EventBus eventBus;

    @Override
    public User determineCurrentUser() {
        return userRepository.determineCurrentUser();
    }

    @Override
    public User determineUser(Long userId) {
        return userRepository.determineUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.saveUser(user);
        eventBus.post(new UserUpdatedEvent());
    }

    @Override
    public User createUser(String email, String password, String passwordRepeat, String firstname, String lastname) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(passwordRepeat));
        Preconditions.checkArgument(Objects.equal(password, passwordRepeat));
        Preconditions.checkArgument(!userRepository.determineUser(email).isPresent());

        User createdUser = userRepository.createUser(email, password, firstname, lastname);
        
        eventBus.post(new UserCreatedEvent());
        return createdUser;
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
