package uz.lab.eduapplication.service;

import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.DTO.TestQuestionAndAnswerDTO;
import uz.lab.eduapplication.DTO.TestWithoutSectionDTO;

import java.util.List;
import java.util.UUID;


public interface TestService {
    public List<TestDTO> getAllTests();

    public TestDTO getOneTest(UUID id);

    public TestDTO saveTest(TestDTO testDTO);

    public TestDTO editTest(TestDTO testDTO);

    public String deleteTest(UUID id);

    TestQuestionAndAnswerDTO getAllQuestionAndAnswerWhichConnectedToTest(UUID testId);
     List<TestWithoutSectionDTO> getTestWithSectionId(UUID sectionId);
}
