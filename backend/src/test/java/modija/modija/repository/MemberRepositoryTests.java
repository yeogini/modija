package modija.modija.repository;

import modija.modija.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testFindByAccount() {
        Member member = new Member("test", "1234");

        Member member1 = entityManager.persist(member);

        List<Member> findByAccount = memberRepository.findByAccount(member.getAccount());

        assertThat(findByAccount).extracting(Member::getAccount).containsOnly(member.getAccount());

        Member result = memberRepository.findById(member1.getId()).get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void testFindById() {
        Member member = new Member("test", "1234");

        Member member1 = entityManager.persist(member);

        Member result = memberRepository.findById(member1.getId()).get();

        assertThat(member1).isEqualTo(result);
    }


}
