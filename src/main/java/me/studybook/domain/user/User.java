package me.studybook.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "is_login", columnDefinition = "smallint default 0")
    private short isLogin;

    @Column(name = "last_logged_at", columnDefinition = "timestamp")
    private LocalDateTime lastLoggedAt;

    @Column(name = "last_out_at", columnDefinition = "timestamp")
    private LocalDateTime lastOutAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "user")
    private List<UserImage> userImages;

    @OneToMany(mappedBy = "follower")
    private List<UserFollow> followers;

    @OneToMany(mappedBy = "following")
    private List<UserFollow> followings;
}
