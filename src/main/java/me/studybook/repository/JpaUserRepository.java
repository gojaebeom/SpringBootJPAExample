package me.studybook.repository;

import me.studybook.domain.user.User;
import me.studybook.domain.user.UserImage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository{

    private final EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() throws Exception {
        return entityManager.createQuery(
                "select u.email, u.nickname " +
                        "from User as u"
        ).getResultList();
    }

    @Override
    public User findOne(Long userId) throws Exception {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void create(User user) throws Exception {
        entityManager.persist(user);
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
