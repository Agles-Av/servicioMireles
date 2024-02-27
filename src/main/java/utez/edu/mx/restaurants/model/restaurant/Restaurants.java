package utez.edu.mx.restaurants.model.restaurant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Setter
@Getter
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 50, nullable = false)
    private String description;
    @Column(length = 5, nullable = false)
    private int rating;
    @Column(length = 512, nullable = false)
    private String image;

    public Restaurants(Long id, String title, String description, int rating, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }

    public Restaurants() {
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", image='" + image + '\'' +
                '}';
    }
}
