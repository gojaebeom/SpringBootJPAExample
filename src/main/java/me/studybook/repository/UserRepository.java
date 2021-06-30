package me.studybook.repository;

import me.studybook.domain.user.User;
import me.studybook.dto.UserFindAll;

import java.util.List;

public interface UserRepository {
    List<UserFindAll> findAll() throws Exception;
    User findOne(Long userId) throws Exception;
    void create(User user) throws Exception;
    User update(User user) throws Exception;
    void delete(Long userId) throws Exception;
}
