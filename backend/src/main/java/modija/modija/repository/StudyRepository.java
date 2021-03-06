package modija.modija.repository;

import modija.modija.domain.study.Study;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {


    Page<Study> findAll(Pageable pageable);

}
