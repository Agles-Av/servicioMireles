package utez.edu.mx.restaurants.controller.restaurant;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.restaurants.config.ApiResponse;
import utez.edu.mx.restaurants.controller.restaurant.dto.RestaurantDto;
import utez.edu.mx.restaurants.service.restaurant.RestaurantService;

@Controller
@RequestMapping("/api/restaurant")
@CrossOrigin(origins = {"*"})
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
       return restaurantService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RestaurantDto restaurantDto){
        return restaurantService.save(restaurantDto.toEntity());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        return restaurantService.delete(id);
    }

}
