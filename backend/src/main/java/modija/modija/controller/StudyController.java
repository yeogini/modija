package modija.modija.controller;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.study.Study;
import modija.modija.model.Paging;
import modija.modija.model.Result;
import modija.modija.model.StudyVo;
import modija.modija.service.StudyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final StudyService studyService;

    @GetMapping("/")
    public ResponseEntity<Result> list(@RequestBody Paging paging) {
        Pageable pageable = PageRequest.of(paging.getPage(), paging.getSize());
        Page<Study> studys = studyService.findAll(pageable);
        return new ResponseEntity<>(Result.builder().contents(studys).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Study> getOne(@PathVariable Long id) {
        Study study = studyService.findOne(id);
        return new ResponseEntity<>(study, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Study> save(@RequestBody StudyVo studyVo) {
        Study study = studyService.save(studyVo);
        return new ResponseEntity<>(study, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studyService.delete(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
