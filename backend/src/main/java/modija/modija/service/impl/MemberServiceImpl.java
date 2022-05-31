package modija.modija.service.impl;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.Member;
import modija.modija.repository.MemberRepository;
import modija.modija.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member findOne(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
