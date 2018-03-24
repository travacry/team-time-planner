package team.lunch.planner.restaurant.rest;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 7425673115755859832L;
    
    private String name;

}
