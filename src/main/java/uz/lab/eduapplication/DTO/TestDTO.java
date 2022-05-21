package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private String id;
    private Integer ord;
    private Integer score;
    private SectionDTO section;
}
