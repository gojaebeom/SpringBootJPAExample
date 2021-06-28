package me.studybook.controller;

import me.studybook.domain.Member;
import me.studybook.domain.MemberImage;
import me.studybook.dto.JoinForm;
import me.studybook.dto.UpdateMemberForm;
import me.studybook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/members")
    public void localJoin(@RequestBody JoinForm joinForm) throws Exception {
        System.out.println(joinForm.toString());
        MemberImage memberImage = new MemberImage();
        memberImage.setOriginPath("imagePath01");

        List<MemberImage> memberImages = new ArrayList<>();
        memberImages.add(memberImage);

        Member member = new Member();
        member.setEmail(joinForm.getEmail());
        member.setNickname(joinForm.getNickname());
        member.setPassword(joinForm.getPassword());
        member.setMemberImages(memberImages);

        memberService.localJoin(member);
    }

    @GetMapping("/api/members")
    public ResponseEntity<List<Member>> index() throws Exception {
        List<Member> members = memberService.getMembersInfo();
        System.out.println(members);

        return ResponseEntity.ok(members);
    }

    @PutMapping("/api/members/{id}")
    public void edit(@RequestParam(value="id", required = false) Long id, @RequestBody UpdateMemberForm updateMemberForm) throws Exception {
        System.out.println(id);
        System.out.println(updateMemberForm.getNickname());
        Member member = new Member();
        member.setId(1L);
        member.setNickname(updateMemberForm.getNickname());
        memberService.updateMemberInfo(member);
    }

    @DeleteMapping("/api/members/{id}")
    public void delete(@RequestParam(value="id", required = false) Long id) throws Exception {
        memberService.deleteMember(1L);
    }
}
