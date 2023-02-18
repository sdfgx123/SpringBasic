package springStudy.hello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springStudy.hello.domain.Member;
import springStudy.hello.repository.MemberRepository;
import springStudy.hello.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /**
     * DI 의존성 주입 과정
     * 기존에는 회원 서비스가 메모리 회원 리포지토리를 직접 생성하게 했는데,
     * @beforeEach에서 MemberService 생성자를 통해서 의존성 주입받음
     * 따라서, 테스트 클래스에서 Repository는 하나의 객체만 참조하게 됨
     */
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() throws Exception {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findMember = memberRepository.findById(savedId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void duplicated_member_exception() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // 예외가 발생해야 한다
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    /**
     * AssertThat, AssertThrows, AssertEquals 정리
     *
     * org.junit.Assert.assertThat(기준, 비교 대상)
     * 
     */
}