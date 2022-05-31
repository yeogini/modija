package modija.modija.service.impl;

import lombok.RequiredArgsConstructor;
import modija.modija.domain.study.Study;
import modija.modija.domain.study.StudyGroup;
import modija.modija.model.StudyGroupVo;
import modija.modija.model.StudyVo;
import modija.modija.repository.MemberRepository;
import modija.modija.repository.StudyRepository;
import modija.modija.service.StudyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;

    @Override
    public Study save(StudyVo studyVo) {
        Study study;
        if(studyVo.getId()==null) {
            study = new Study(studyVo.getTitle());
        } else {
            study = studyRepository.findById(studyVo.getId()).orElse(null);
            if(study==null) return null;
            study.changeTitle(studyVo.getTitle());
        }
        for(StudyGroupVo groupVo : studyVo.getMembers()) {
            StudyGroup studyGroup = new StudyGroup();
            studyGroup.setStudy(study);
            studyGroup.setMember(memberRepository.getById(groupVo.getMember()));
            study.addMember(studyGroup);
        }

        return studyRepository.save(study);
    }

    @Override
    public void delete(Long id) {
        studyRepository.deleteById(id);
    }

    @Override
    public Page<Study> findAll(Pageable pageable) {
        return studyRepository.findAll(pageable);
    }

    @Override
    public Study findOne(Long id) {
        return studyRepository.findById(id).orElse(null);
    }
}
