package team.lunch.planner.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;

@Configuration
public class DomainUserConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, EventBus eventBus) {
        return new DefaultUserService(userRepository, eventBus);
    }
}
