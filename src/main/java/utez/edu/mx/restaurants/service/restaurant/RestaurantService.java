package utez.edu.mx.restaurants.service.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.restaurants.config.ApiResponse;
import utez.edu.mx.restaurants.model.restaurant.Restaurants;
import utez.edu.mx.restaurants.model.restaurant.RestaurantsRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantsRepository restaurantsRepository;

    public RestaurantService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return new ResponseEntity<>(
                new ApiResponse(restaurantsRepository.findAll(), HttpStatus.OK),
                HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Restaurants restaurants) {
        restaurants = restaurantsRepository.saveAndFlush(restaurants);
        return new ResponseEntity<>(new ApiResponse(restaurants, HttpStatus.OK), HttpStatus.OK);
    }

  /*  @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(Restaurants restaurants) {
        Optional<Restaurants> getId = restaurantsRepository.findById(restaurants.getId());
        restaurants = restaurantsRepository.saveAndFlush(restaurants);
        return new ResponseEntity<>(new ApiResponse(restaurants, HttpStatus.OK), HttpStatus.OK);
    }*/

    @Transactional(rollbackFor = {SQLException.class})
    public  ResponseEntity<ApiResponse> delete (Long id){
        Optional<Restaurants> getID = restaurantsRepository.findById(id);
        if (getID.isPresent()){
            restaurantsRepository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, false, "Restaurante Borrado"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, true, "Restaurante no encontrado"), HttpStatus.NOT_FOUND);
        }
    }
}
