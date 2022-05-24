package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionAndAnswerDTO {
    private String id;
    private Integer ord;
    private Integer score;
    private List<QuestionWithoutTestDTO> questionDTO;
    private List<AnswerWithoutTestDTO> answerDTO;

}
