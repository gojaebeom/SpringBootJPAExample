package me.studybook.domain.place;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.studybook.domain.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "p_restaurant_reviews")
@Getter
@Setter
@ToString
public class PlaceRestaurantReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = PlaceRestaurant.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurant_id")
    private PlaceRestaurant restaurant;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "total_rating")
    private Float totalRating;

    @Column(name = "taste_rating")
    private Float tasteRating;

    @Column(name = "cost_rating")
    private Float costRating;

    @Column(name = "service_rating")
    private Float serviceRating;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
