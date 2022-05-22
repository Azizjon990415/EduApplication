package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.SectionRepository;
import uz.lab.eduapplication.repository.TestRepository;

import java.util.Optional;
import java.util.UUID;

@Component
public class TestMapper {
    @Autowired
    TestRepository testRepository;
    @Autowired
    SectionMapper sectionMapper;
    public Test mapTestDTOToTestDomain(TestDTO testDTO){
        return testDTO.getId()==null ? new Test(testDTO.getOrd(),testDTO.getScore(), sectionMapper.mapSectionDTOToSectionDomain(testDTO.getSection())) :
                testRepository.findById(UUID.fromString(String.valueOf(testDTO.getId())))
                        .map(question -> new Test(question.getOrd(),question.getScore(), question.getSection()))
                        .orElseGet(()->new Test(testDTO.getOrd(),testDTO.getScore(), sectionMapper.mapSectionDTOToSectionDomain(testDTO.getSection())));

    }

    public TestDTO mapTestDomainToTestDTO(Test test){
        return new TestDTO(test.getId().toString(), test.getOrd(), test.getScore(), sectionMapper.mapSectionDomainToSectionDTO(test.getSection()));
    }
}
