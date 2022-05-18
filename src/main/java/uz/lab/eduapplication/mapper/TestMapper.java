package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.SectionRepository;

import java.util.Optional;
import java.util.UUID;

@Component
public class TestMapper {
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    SectionMapper sectionMapper;
    public Test mapTestDTOToTestDomain(TestDTO testDTO){
        Optional<Section> sectionOptional = sectionRepository.findById(UUID.fromString(testDTO.getSection().getId()));
        if (sectionOptional.isPresent()){
            return new Test(testDTO.getOrd(),testDTO.getScore(), sectionOptional.get());
        }else {
            return new Test(testDTO.getOrd(),testDTO.getScore(), sectionMapper.mapSectionDTOToSectionDomain(testDTO.getSection()));
        }
    }

    public TestDTO mapTestDomainToTestDTO(Test test){
        return new TestDTO(test.getId().toString(), test.getOrd(), test.getScore(), sectionMapper.mapSectionDomainToSectionDTO(test.getSection()));
    }
}
