package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.SectionDTO;
import uz.lab.eduapplication.DTO.SectionWithTestDTO;
import uz.lab.eduapplication.DTO.TestWithoutSectionDTO;
import uz.lab.eduapplication.DTO.SectionWithoutBookDTO;
import uz.lab.eduapplication.domain.Book;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SectionMapper {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public Section mapSectionDTOToSectionDomain(SectionDTO sectionDTO) {
        Optional<Book> bookOptional;
        if (sectionDTO.getBookDTO().getId() != null) {
            bookOptional = bookRepository.findById(UUID.fromString(sectionDTO.getBookDTO().getId()));
        } else {
            bookOptional = Optional.empty();
        }
        if (bookOptional.isPresent()) {
            return new Section(sectionDTO.getNameUz(), sectionDTO.getNameRu(), sectionDTO.getNameEn(), sectionDTO.getActive(), bookOptional.get());
        } else {
            return new Section(sectionDTO.getNameUz(), sectionDTO.getNameRu(), sectionDTO.getNameEn(), sectionDTO.getActive(), bookMapper.mapBookDTOToBookDomain(sectionDTO.getBookDTO()));
        }
    }

    public SectionDTO mapSectionDomainToSectionDTO(Section section) {
        return new SectionDTO(section.getId().toString(), section.getNameUz(), section.getNameRu(), section.getNameEn(), section.getActive(), bookMapper.mapBookDomainToBookDTO(section.getBook()));
    }
    public SectionWithTestDTO mapSectionWithTestDTO(Section section, List<TestWithoutSectionDTO> bob) {
        return new SectionWithTestDTO(section.getId().toString(),section.getNameUz(), section.getNameRu(), section.getNameEn(), section.getActive(), bookMapper.mapBookDomainToBookDTO(section.getBook()),bob);
    }
    public SectionWithoutBookDTO mapSectionWithoutBookDTO(Section section){
        return new SectionWithoutBookDTO(section.getId().toString(), section.getNameUz(), section.getNameRu(), section.getNameEn(),section.getActive());
    }
}
