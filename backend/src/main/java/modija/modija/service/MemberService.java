package modija.modija.service;

import modija.modija.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    Page<Member> findAll(Pageable pageable);

    Member save(Member member);

    void delete(Long id);

    Member findOne(Long id);
}
