package uz.lab.eduapplication.domain;

import lombok.*;
import uz.lab.eduapplication.domain.template.AbstractDomain;
import uz.lab.eduapplication.DTO.QuestionDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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

    public Object getScore() {

        public QuestionDTO getQuestion() {
        }
    }

    public QuestionDTO getQuestion() {
    }
}