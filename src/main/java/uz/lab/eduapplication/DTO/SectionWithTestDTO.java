package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionWithTestDTO {
    private String id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private Boolean active;
    private BookDTO bookDTO;
    private List<TestWithoutSectionDTO> testDTO;
}
