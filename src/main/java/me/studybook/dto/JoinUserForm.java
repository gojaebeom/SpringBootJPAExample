package me.studybook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinUserForm {
    private String email;
    private String password;
    private String nickname;
}
