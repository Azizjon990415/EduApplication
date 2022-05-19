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
public class Question extends AbstractDomain {
    @Column
    private String ord;
    @Column
    private String text;
    @ManyToOne
    private Test test;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}