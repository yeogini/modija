package modija.modija.domain.study;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import modija.modija.domain.Member;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class StudyGroup {

    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Study study;

    @Column(nullable = false)
    private GroupRole groupRole;

    public enum GroupRole {
        captain,
        sailor
    }
}
