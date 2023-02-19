package springStudy.hello.repository;

import org.springframework.stereotype.Repository;
import springStudy.hello.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 만약 return이 null일 경우, nullable로 감싸줌
        // 이렇게 해주면, client에서 작업 가능함
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 람다 > member에서 루프 돌아서 name 파라미터랑 걸리는 거 하나라도 있으면 해당 member 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store에 있는 member들 다 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
