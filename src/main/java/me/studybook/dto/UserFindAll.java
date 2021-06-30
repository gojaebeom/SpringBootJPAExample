package me.studybook.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class UserFindAll {
    private String nickname;
    private String updatedAt;
    private String babyBirthday;
    private char babyGender;
    private short ageGroupType;
    //private List<UserImage> userImages = new ArrayList<>();


    public UserFindAll(String nickname, LocalDateTime updatedAt, String babyBirthday, char babyGender, short ageGroupType){
        this.nickname = nickname;
        this.updatedAt = updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.babyBirthday = babyBirthday;
        this.babyGender = babyGender;
        this.ageGroupType = ageGroupType;
    }
}
