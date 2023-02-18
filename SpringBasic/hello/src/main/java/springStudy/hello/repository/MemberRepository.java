package springStudy.hello.repository;

import springStudy.hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    /**
     * Optional : 자바 8부터 지원하는 기능
     * 만약 반환값이 null일 경우, null을 반환하는 대신 Optional로 반환
     */

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
