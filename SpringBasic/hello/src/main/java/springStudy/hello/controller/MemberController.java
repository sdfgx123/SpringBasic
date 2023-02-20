package springStudy.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springStudy.hello.domain.Member;
import springStudy.hello.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    /**
     * 이게 강의에서 한 방식
     * 전부 이해는 되는데, 내가 학교에서 했던 방식은 메서드에서 @requestParam으로 파라미터 받아와서 바로 member 객체에 set 태우는 방식으로 했음
     * 이게 더 효율적이라고 생각하는데, 메서드 하나 만들어서 테스트 해봐야겠음
     */
    @PostMapping("members/new")
    public String create(Member form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        System.out.println("ok");

        return "redirect:/";
    }

    @PostMapping("members/new/v2")
    public String createV2(@RequestParam String name) {
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
        System.out.println("version 2 ok");
        System.out.println("name : " + name);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
