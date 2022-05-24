package uz.lab.eduapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithSectionDTO {
    private String id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private Boolean active;
    private List <SectionWithoutBookDTO>;
}
