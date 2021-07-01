package kr.co.hohocompany.uahage.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@ToString
public class UserUpdateForm {

    private Long id;
    private String imgInit;
    private String nickname;
    private short ageGroupType;
    private char babyGender;
    private String babyBirthday;
    private MultipartFile[] images;

    @Builder
    public UserUpdateForm(Long id, String imgInit, String nickname, short ageGroupType, char babyGender, String babyBirthday, MultipartFile[] images) {
        this.id = id;
        this.imgInit = imgInit;
        this.nickname = nickname;
        this.ageGroupType = ageGroupType;
        this.babyGender = babyGender;
        this.babyBirthday = babyBirthday;
        this.images = images;
    }
}
