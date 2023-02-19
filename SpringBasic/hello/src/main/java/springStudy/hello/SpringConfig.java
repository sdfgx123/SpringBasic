package springStudy.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springStudy.hello.repository.MemberRepository;
import springStudy.hello.repository.MemoryMemberRepository;
import springStudy.hello.service.MemberService;

/**
 * Spring Bean을 수동으로 등록하는 방법 > 자바 코드로 직접 스프링 빈 등록
 * 본 강의에서는 리포지토리 구현체 등을 다른 것으로 변경할 예정이므로 컴포넌트 스캔 방식 대신 자바 코드로
 * 스프링 빈을 설정함.
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
