package team.lunch.planner.restaurant.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainRestaurantConfiguration {

    @Bean
    public RestaurantService restaurantService() {
        return new DefaultRestaurantService();
    }
}
