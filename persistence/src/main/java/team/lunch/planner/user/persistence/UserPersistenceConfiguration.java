package team.lunch.planner.user.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.UserRepository;

@Configuration
@RequiredArgsConstructor
public class UserPersistenceConfiguration {
    
    private final UserEntityRepository userEntityRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository(userEntityRepository));
    }
    
    @Bean
    public UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserRepository userRepository(UserEntityRepository userEntityRepository) {
        return new DefaultUserRepository(userEntityMapper(), userEntityRepository, passwordEncoder());
    }
    
    
}
