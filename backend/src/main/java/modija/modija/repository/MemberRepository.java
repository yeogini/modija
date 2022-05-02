package modija.modija.repository;

import modija.modija.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

    List<Member> findByAccount(String account);

    Page<Member> findAll(Pageable pageable);

}
