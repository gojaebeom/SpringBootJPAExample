package me.studybook.controller.user;

import me.studybook.domain.user.User;
import me.studybook.dto.JoinUserForm;
import me.studybook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    // TODO: 상세 조회
    @GetMapping("/users/{id}")
    public ResponseEntity show(@PathVariable Long id) throws Exception {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    // TODO: 생성
    @PostMapping("/users")
    public ResponseEntity create(@RequestBody JoinUserForm joinUserForm) throws Exception {

        try {
            userService.join(joinUserForm);
        } catch (Exception e) {
            return ResponseEntity.ok(e);
        }
        return ResponseEntity.ok("ok");
    }

    // TODO: 수정
    @PutMapping("/users/{id}")
    public ResponseEntity update(@PathVariable Long id) {
        try{
            return ResponseEntity.ok("ok");
        }catch (Exception e) {
            return ResponseEntity.ok("server error");
        }
    }

    // TODO: 삭제
    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("ok");
    }
}
