package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private String id;
    private String computer;
    private String Math;
    private String aboutYou;
    private Boolean words;
    private QuestionDTO questionDTO;
}
