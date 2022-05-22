package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.lab.eduapplication.domain.Test;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private String id;
    private String ord;
    private String text;
    private TestDTO test;
}
