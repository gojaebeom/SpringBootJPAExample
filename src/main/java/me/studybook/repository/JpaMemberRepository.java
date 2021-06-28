package me.studybook.repository;

import me.studybook.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Member member) throws Exception {
        entityManager.persist(member);
    }

    @Override
    public List<Member> findAll() throws Exception {
        return entityManager.createQuery("select m from Member m", Member.class).
                getResultList();
    }

    @Override
    public void edit(Member member) throws Exception {
        Member findMember = entityManager.find(Member.class, member.getId());
        findMember.setNickname(member.getNickname());
    }

    @Override
    public void destroy(Long memberId) throws Exception {
        Member member = entityManager.find(Member.class, memberId);
        System.out.println(member.getId());
        entityManager.remove(member);
    }
}
