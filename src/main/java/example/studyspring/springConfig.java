package example.studyspring;

import example.studyspring.repository.MemberRepository;
import example.studyspring.repository.MemoryMemberRepository;
import example.studyspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {

    @Bean //스프링 빈을 등록할거야
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
