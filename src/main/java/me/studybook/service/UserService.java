package me.studybook.service;

import me.studybook.domain.user.User;
import me.studybook.dto.JoinUserForm;
import me.studybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() throws Exception {
        return userRepository.findAll();
    }

    public User getUser(Long id) throws Exception {
        return userRepository.findOne(id);
    }

    public void join(JoinUserForm joinUserForm) throws Exception {
        User user = new User();
        user.setEmail(joinUserForm.getEmail());
        user.setNickname(joinUserForm.getNickname());
        user.setPassword(joinUserForm.getPassword());
        userRepository.create(user);
    }

    public void updateUser() throws Exception {

    }
}
