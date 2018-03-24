package team.lunch.planner.restaurant.rest;

import java.util.List;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.restaurant.domain.RestaurantService;
import team.lunch.planner.team.rest.TeamDTO;

@RestController
@ExposesResourceFor(TeamDTO.class)
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantService restaurantService;
    
    @GetMapping(produces="application/json")
    public ResponseEntity<List<Resource<RestaurantDTO>>> getRestaurants(@RequestParam String prefix) {
        return ResponseEntity.notFound().build();
    }
}
