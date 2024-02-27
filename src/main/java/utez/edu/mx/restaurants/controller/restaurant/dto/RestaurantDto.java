package utez.edu.mx.restaurants.controller.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.restaurants.model.restaurant.Restaurants;

@NoArgsConstructor
@Setter
@Getter
public class RestaurantDto {
    private Long id;
    private String title;
    private String description;
    private int rating;
    private String image;

    public Restaurants toEntity() {
        return new Restaurants(id,title,description,rating,image);
    }
}
