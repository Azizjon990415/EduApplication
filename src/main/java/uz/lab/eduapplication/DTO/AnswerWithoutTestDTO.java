package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class AnswerWithoutTestDTO {
        private String id;
        private boolean correct;
        private String text;
    }
