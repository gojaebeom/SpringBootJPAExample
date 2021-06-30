package me.studybook.service;

import me.studybook.domain.user.User;
import me.studybook.domain.user.UserDetail;
import me.studybook.domain.user.UserImage;
import me.studybook.dto.JoinUserForm;
import me.studybook.dto.UserFindAll;
import me.studybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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


//        List<UserImage> userImages = new ArrayList<>();
//
//        UserImage userImage1 = UserImage.builder().originPath("hello1.png").build();
//        UserImage userImage2 = UserImage.builder().originPath("hello2.png").build();
//
//        userImages.add(userImage1);
//        userImages.add(userImage2);
//
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
