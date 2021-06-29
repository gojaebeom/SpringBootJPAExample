package me.studybook.repository;

import me.studybook.domain.user.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll() throws Exception;
    User findOne(Long userId) throws Exception;
    void create(User user) throws Exception;
    User update(User user) throws Exception;
    void delete(Long userId) throws Exception;
}
