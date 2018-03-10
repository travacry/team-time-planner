package team.lunch.planner.team.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;

@Configuration
public class DomainTeamConfiguration {

    @Bean
    public TeamService teamService(TeamRepository teamRepository, EventBus eventBus) {
        return new DefaultTeamService(teamRepository, eventBus);
    }

}
