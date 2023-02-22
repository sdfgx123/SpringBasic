package springStudy.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springStudy.hello.repository.JdbcTemplateMemberRepository;
import springStudy.hello.repository.JpaMemberRepository;
import springStudy.hello.repository.MemberRepository;
import springStudy.hello.repository.MemoryMemberRepository;
import springStudy.hello.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Spring Bean을 수동으로 등록하는 방법 > 자바 코드로 직접 스프링 빈 등록
 * 본 강의에서는 리포지토리 구현체 등을 다른 것으로 변경할 예정이므로 컴포넌트 스캔 방식 대신 자바 코드로
 * 스프링 빈을 설정함.
 */
@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    //private final EntityManager em;

    // spring data jpa 사용을 위한 선언
    /**
     * spring data jpa를 쓰면, repository bean을 따로
     * 등록해줄 필요가 없다 > 알아서 등록해줌
     */
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//    }
}
