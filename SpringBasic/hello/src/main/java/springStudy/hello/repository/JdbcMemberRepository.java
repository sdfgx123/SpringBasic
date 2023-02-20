package springStudy.hello.repository;

import springStudy.hello.domain.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * jdbc api로 직접 코딩하는 방법
 * 참고만 하는 정도로 넘어가면 됨
 * 이 부분은 오버라이딩 돼 있는 메서드 작성 안하고 그냥 넘어감
 * 인터페이스로 repository 구현 클래스 변경해서 db connection 되는지 정도까지만 확인하는 것 같음
 */
public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
