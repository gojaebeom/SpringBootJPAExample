package kr.co.hohocompany.uahage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinUserForm {
    private String email;
    private String password;
    private String nickname;
}
