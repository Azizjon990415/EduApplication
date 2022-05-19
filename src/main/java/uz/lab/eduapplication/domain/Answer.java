package uz.lab.eduapplication.domain;

import lombok.*;
import org.hibernate.Hibernate;
import uz.lab.eduapplication.domain.template.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Objects;

    @Entity
    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    @AllArgsConstructor
    public class Answer extends AbstractDomain {
        @Column
        private String isCorrect;
        @Column
        private String text;
        @ManyToOne
        private Test test;

        public Answer(String isCorrect, String text, Test test) {
            this.isCorrect = isCorrect;
            this.text = text;
            this.test = test;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
            uz.lab.eduapplication.domain.Answer answer = (uz.lab.eduapplication.domain.Answer) o;
            return getId() != null && Objects.equals(getId(), answer.getId());
        }

        @Override
        public int hashCode() {
            return getClass().hashCode();
        }

    }
