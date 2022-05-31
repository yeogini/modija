package modija.modija.model;

import lombok.Getter;
import lombok.Setter;
import modija.modija.domain.study.StudyGroup;

@Getter
@Setter
public class StudyGroupVo {

    private Long member;

    private StudyGroup.GroupRole role;
}
