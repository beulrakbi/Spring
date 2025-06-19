package example.studyspring.controller;

import example.studyspring.domain.Member;
import example.studyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

//스프링 컨테이너에서 빈이 관리된다.
@Controller
public class MemberController {

    private final MemberService memberService;

    //@Autowired 서비스를 컨트롤러에 연결해준다.
    //service, repository에 어노테이션 작성
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return"members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member= " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }
}
