package team.lunch.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.eventbus.EventBus;

import team.lunch.planner.team.domain.DefaultTeamService;
import team.lunch.planner.team.domain.TeamRepository;
import team.lunch.planner.team.domain.TeamService;
import team.lunch.planner.user.domain.DefaultUserService;
import team.lunch.planner.user.domain.UserRepository;
import team.lunch.planner.user.domain.UserService;

@SpringBootApplication
@EnableEntityLinks
public class LunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchApplication.class, args);
    }
    
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public TeamService teamService(TeamRepository teamRepository) {
        return new DefaultTeamService(teamRepository, eventBus());
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new DefaultUserService(userRepository, eventBus());
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
