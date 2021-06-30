package kr.co.hohocompany.uahage.service;

import kr.co.hohocompany.uahage.domain.user.User;
import kr.co.hohocompany.uahage.domain.user.UserDetail;
import kr.co.hohocompany.uahage.dto.JoinUserForm;
import kr.co.hohocompany.uahage.dto.UserFindAll;
import kr.co.hohocompany.uahage.repository.UserRepository;
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

    public List<UserFindAll> getUsers() throws Exception {
        return userRepository.findAll();
    }

    public User getUser(Long id) throws Exception {
        return userRepository.findOne(id);
    }

    public void join(JoinUserForm joinUserForm) throws Exception {

        UserDetail userDetail = UserDetail.builder()
                .babyBirthday("2020/01/01")
                .ageGroupType((short) 2)
                .babyGender('F').build();

        User user = User.builder()
                .nickname(joinUserForm.getNickname())
                .email(joinUserForm.getEmail())
                .password(joinUserForm.getPassword())
//                .userImages(userImages)
//                .userDetail(userDetail)
                .build();

        userRepository.create(user);
    }

    public void updateUser() throws Exception {

    }
}
