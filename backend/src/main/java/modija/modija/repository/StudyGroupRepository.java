package modija.modija.repository;

import modija.modija.domain.study.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup , Long> {
}
