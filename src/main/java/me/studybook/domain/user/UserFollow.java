package me.studybook.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_follows")
@Getter
@ToString
@NoArgsConstructor
public class UserFollow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id")
    private User follower;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "following_id")
    private User following;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public UserFollow(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }
}
