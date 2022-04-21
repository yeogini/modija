package modija.modija.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Member {

    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String account;

    @Column(length = 20)
    @Setter
    private String name;

    @Column(length = 11)
    @Setter
    private String contact;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    @CreationTimestamp
    private Date regDt;             // 등록일자

    protected Member() {

    }

    public Member(String account,String password) {
        this.account = account;
        this.password = password;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
