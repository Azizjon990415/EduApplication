package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.*;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.SectionRepository;
import uz.lab.eduapplication.repository.TestRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TestMapper {
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    SectionMapper sectionMapper;
    public Test mapTestDTOToTestDomain(TestDTO testDTO){
        return testDTO.getSectionDTO().getId()==null ? new Test(testDTO.getOrd(),testDTO.getScore(), sectionMapper.mapSectionDTOToSectionDomain(testDTO.getSectionDTO())) :
                sectionRepository.findById(UUID.fromString(String.valueOf(testDTO.getSectionDTO().getId())))
                        .map(section -> new Test(testDTO.getOrd(),testDTO.getScore(), section))
                        .orElseGet(()->new Test(testDTO.getOrd(),testDTO.getScore(), sectionMapper.mapSectionDTOToSectionDomain(testDTO.getSectionDTO())));

    }

    public TestDTO mapTestDomainToTestDTO(Test test){
        return new TestDTO(test.getId().toString(), test.getOrd(), test.getScore(), sectionMapper.mapSectionDomainToSectionDTO(test.getSection()));
    }

    public TestQuestionAndAnswerDTO mapTestQuestionAndAnswerDTO(Test test, List<QuestionWithoutTestDTO> questionWithoutTestDTOS, List<AnswerWithoutTestDTO> answerWithoutTestDTOS){
        return  new TestQuestionAndAnswerDTO(test.getId().toString(), test.getOrd(), test.getScore(), questionWithoutTestDTOS, answerWithoutTestDTOS);
    }

    public TestWithoutSectionDTO mapTestWithoutSectionDTO(Test test) {
        return new TestWithoutSectionDTO(test.getId().toString(), test.getOrd(), test.getScore());
    }
}
