package modija.modija.controller;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.Member;
import modija.modija.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public @ResponseBody String member() {
        return "member test";
    }

    @PostMapping("/list")
    public Page<Member> list() {
        int page = 0;
        int size = 5;
        Pageable pageable = PageRequest.of(page, size);
        return memberService.findAll(pageable);
    }

}
