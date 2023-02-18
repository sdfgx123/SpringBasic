package springStudy.hello.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springStudy.hello.domain.Member;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD 테스트 주도 개발
 * 어떠한 기능 또는 메서드에 대해서 틀을 먼저 만들어 놓고 개발하는 방식
 */
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertEquals(member, result);
    }

    @Test
    public void findByName() {
        // member 객체 선언
        Member member1 = new Member();
        // member1 객체에 spring1 name set
        member1.setName("spring1");
        repository.save(member1);
        System.out.println(member1.getName());

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

        /**
         * 이해 안되는 부분
         * 처음에 에러 났을 때 member1.setname(spring2) 해줘서 에러 났었음
         * 그러면 이때 breakpoint에서 다른 에러 메세지를 띄웠어야 하는데, nullpointerexception 에러가 났음
         * 왜 nullpointerexception이 났는지 이해 불가
         */
    }
    
    @Test
    public void findAll() {
        // member 객체 선언
        Member member1 = new Member();
        // member1 객체에 spring1 name set
        member1.setName("spring1");
        repository.save(member1);
        System.out.println(member1.getName());

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }


}
