package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.lab.eduapplication.domain.Test;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private String id;
    private Integer ord;
    private Integer score;
    private SectionDTO section;

    public TestDTO(String id, String ord, Object score, Test mapQuestionDTOToQuestionDomain) {

    }
}
