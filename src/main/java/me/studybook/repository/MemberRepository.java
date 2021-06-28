package me.studybook.repository;

import me.studybook.domain.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member) throws Exception;

    List<Member> findAll() throws Exception;

    void edit(Member member) throws Exception;

    void destroy(Long memberId) throws Exception;
}
