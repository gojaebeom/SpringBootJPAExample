package me.studybook.controller.user;

import me.studybook.domain.user.User;
import me.studybook.dto.JoinUserForm;
import me.studybook.dto.ResponseData;
import me.studybook.dto.UserFindAll;
import me.studybook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO: 전체,필터에 따른 조회
    @GetMapping("/users")
    public ResponseEntity index() throws Exception {
        List<UserFindAll> users = userService.getUsers();

        ResponseData responseData = ResponseData.builder()
                .message("select user list")
                .data(users)
                .build();

        return ResponseEntity.ok().body(responseData);
    }

    // TODO: 상세 조회
    @GetMapping("/users/{id}")
    public ResponseEntity show(@PathVariable Long id) throws Exception {
        User user = userService.getUser(id);

        ResponseData responseData = ResponseData.builder()
                .message("select user detail")
                .data(user)
                .build();

        return ResponseEntity.ok().body(responseData);
    }

    // TODO: 생성
    @PostMapping("/users")
    public ResponseEntity create(@RequestBody JoinUserForm joinUserForm) throws Exception {
        try {
            userService.join(joinUserForm);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("ok");
    }

    // TODO: 수정
    @PutMapping("/users/{id}")
    public ResponseEntity update(@PathVariable Long id) {
        try{
            return ResponseEntity.ok("ok");
        }catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    // TODO: 삭제
    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("ok");
    }
}
