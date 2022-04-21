package modija.modija.domain.study;

import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Study {

    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    @CreationTimestamp
    private Date regDt;             // 등록일자

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    private Set<StudyGroup> members;

    protected Study() {
        members = new HashSet<>();
    }
    public Study(String title) {
        this.title = title;
    }
    public void changeTitle(String title) {
        this.title = title;
    }

    public void addMember(StudyGroup studyGroup) {
        studyGroup.setStudy(this);
        members.add(studyGroup);
    }

    public void removeMember(StudyGroup studyGroup) {
        members.remove(studyGroup);
    }
}
