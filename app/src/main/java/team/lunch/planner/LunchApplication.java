package team.lunch.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import team.lunch.planner.team.domain.DefaultTeamService;
import team.lunch.planner.team.domain.TeamRepository;
import team.lunch.planner.team.domain.TeamService;
import team.lunch.planner.user.domain.DefaultUserService;
import team.lunch.planner.user.domain.UserRepository;
import team.lunch.planner.user.domain.UserService;

@SpringBootApplication
public class LunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchApplication.class, args);
    }

    @Bean
    public TeamService teamService(TeamRepository teamRepository) {
        return new DefaultTeamService(teamRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new DefaultUserService(userRepository);
    }
}
