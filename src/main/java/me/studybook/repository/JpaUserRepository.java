package me.studybook.repository;

import me.studybook.domain.user.User;
import me.studybook.domain.user.UserDetail;
import me.studybook.domain.user.UserImage;
import me.studybook.dto.UserFindAll;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository{

    private final EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserFindAll> findAll() throws Exception {
        return entityManager.createQuery(
                "select new me.studybook.dto.UserFindAll(u.nickname, u.updatedAt, ud.babyBirthday, ud.babyGender, ud.ageGroupType) from User as u " +
                        "left join UserDetail as ud on u.id = ud.user.id"
        ).getResultList();
    }

    @Override
    public User findOne(Long userId) throws Exception {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void create(User user) throws Exception {
        System.out.println(user);
        entityManager.persist(user);

        UserDetail userDetail = UserDetail.builder()
                .babyGender('A').babyBirthday("2020/01/01").ageGroupType((short) 2).user(user).build();
        entityManager.persist(userDetail);

        UserImage userImage1 = UserImage.builder()
                .originPath("origin1.png")
                .user(user)
                .build();

        UserImage userImage2 = UserImage.builder()
                .originPath("origin2.png")
                .user(user)
                .build();

        List<UserImage> userImages = new ArrayList<>();
        userImages.add(userImage1);
        userImages.add(userImage2);

        for( UserImage userImage : userImages) {
            entityManager.persist(userImage);
        }
    }

    @Override
    public User update(User user) throws Exception {
        return entityManager.find(User.class, user.getId());
    }

    @Override
    public void delete(Long userId) throws Exception {
        User findUser = entityManager.find(User.class, userId);
        entityManager.remove(findUser);
    }
}
