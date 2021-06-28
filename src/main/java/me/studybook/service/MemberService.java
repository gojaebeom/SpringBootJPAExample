package me.studybook.service;

import lombok.ToString;
import me.studybook.domain.Member;
import me.studybook.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@ToString
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void localJoin(Member member) throws Exception {
        memberRepository.save(member);
    }

    public List<Member> getMembersInfo() throws Exception {
        return memberRepository.findAll();
    }

    public void updateMemberInfo(Member member) throws Exception{
        memberRepository.edit(member);
    }

    public void deleteMember(Long memberId) throws Exception{
        memberRepository.destroy(memberId);
    }
}
