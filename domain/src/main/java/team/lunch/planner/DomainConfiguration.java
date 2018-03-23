package team.lunch.planner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;

@Configuration
public class DomainConfiguration {
    
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
