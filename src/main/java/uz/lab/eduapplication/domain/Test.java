package uz.lab.eduapplication.domain;

import lombok.*;
import org.hibernate.Hibernate;
import uz.lab.eduapplication.domain.template.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Test extends AbstractDomain {
    @Column
    private Integer ord;
    @Column
    private Integer score;
    @ManyToOne
    private Section section;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Test test = (Test) o;
        return getId() != null && Objects.equals(getId(), test.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
