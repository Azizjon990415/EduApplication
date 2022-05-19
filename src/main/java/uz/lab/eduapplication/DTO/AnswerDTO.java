package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class AnswerDTO {
        private String id;
        private String isCorrect;
        private String text;
        private TestDTO testDTO;

    }
