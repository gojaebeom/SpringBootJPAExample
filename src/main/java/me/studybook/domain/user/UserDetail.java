package me.studybook.domain.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_details")
@Getter
@ToString
@NoArgsConstructor
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
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

    @Builder
    public UserDetail(Long id, User user, short ageGroupType, char babyGender, String babyBirthday) {
        this.id = id;
        this.user = user;
        this.ageGroupType = ageGroupType;
        this.babyGender = babyGender;
        this.babyBirthday = babyBirthday;
    }
}
