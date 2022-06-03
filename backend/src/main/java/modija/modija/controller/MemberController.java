package modija.modija.controller;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.Member;
import modija.modija.model.Paging;
import modija.modija.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<Page<Member>> list(@RequestBody Paging paging) {
        Pageable pageable = PageRequest.of(paging.getPage(), paging.getSize());
        return new ResponseEntity<>(memberService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.findOne(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Member> save(Member member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        memberService.delete(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
