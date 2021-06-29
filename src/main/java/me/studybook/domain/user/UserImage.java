package me.studybook.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_images")
@Getter
@Setter
@ToString
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "origin_path", length = 100, nullable = false)
    private String originPath;

    @Column(name = "preview_path", length = 100)
    private String previewPath;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
