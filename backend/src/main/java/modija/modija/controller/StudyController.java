package modija.modija.controller;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.study.Study;
import modija.modija.service.StudyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final StudyService studyService;


    @GetMapping("/")
    public ResponseEntity list() {

        int page = 0;
        int size = 5;
        Pageable pageable = PageRequest.of(page, size);
        Page<Study> studys = studyService.findAll(pageable);

        return ResponseEntity.ok(studys);
    }


}
