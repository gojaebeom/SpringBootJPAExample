package me.studybook.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@ToString
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "age_group_type")
    private short ageGroupType;

    @Column(name = "baby_gender")
    private char babyGender;

    @Column(name = "baby_birthday")
    private String babyBirthday;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
