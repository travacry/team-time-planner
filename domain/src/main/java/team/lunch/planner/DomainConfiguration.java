package team.lunch.planner;

import org.springframework.context.annotation.Bean;

import com.google.common.eventbus.EventBus;

public class DomainConfiguration {
    
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
