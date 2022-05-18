package uz.lab.eduapplication.domain;

import lombok.*;
import org.hibernate.Hibernate;
import uz.lab.eduapplication.domain.template.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Book extends AbstractDomain {
    @Column
    private String nameUz;
    @Column
    private String nameRu;
    @Column
    private String nameEn;
    @Column
    private Boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return getId() != null && Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
