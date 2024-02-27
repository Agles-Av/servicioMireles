package utez.edu.mx.restaurants.model.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantsRepository extends JpaRepository<Restaurants,Long> {
    List<Restaurants> findAll();
}
