package modija.modija.service;

import modija.modija.domain.study.Study;
import modija.modija.model.StudyVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyService {

    Study save(StudyVo studyVo);

    void delete(Long id);

    Page<Study> findAll(Pageable pageable);

    Study findOne(Long id);
}
