package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.AnswerWithoutTestDTO;
import uz.lab.eduapplication.DTO.QuestionWithoutTestDTO;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.DTO.TestQuestionAndAnswerDTO;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.mapper.AnswerMapper;
import uz.lab.eduapplication.mapper.QuestionMapper;
import uz.lab.eduapplication.mapper.TestMapper;
import uz.lab.eduapplication.repository.AnswerRepository;
import uz.lab.eduapplication.repository.QuestionRepository;
import uz.lab.eduapplication.repository.TestRepository;
import uz.lab.eduapplication.service.TestService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;
    private TestMapper testMapper;
    private AnswerMapper answerMapper;
    private QuestionMapper questionMapper;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Override
    public List<TestDTO> getAllTests() {
        return testRepository.findAll().stream()
                .map(testMapper::mapTestDomainToTestDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestDTO getOneTest(UUID id) {
        return testRepository.findById(id)
                .map(testMapper::mapTestDomainToTestDTO)
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public TestDTO saveTest(TestDTO testDTO) {
        return testMapper.mapTestDomainToTestDTO(
                testRepository.save(
                        testMapper.mapTestDTOToTestDomain(testDTO)
                )
        );
    }

    @Override
    public TestDTO editTest(TestDTO testDTO) {
        boolean exists = testRepository.existsById(UUID.fromString(testDTO.getId()));
        if (exists) {
            Test test = testMapper.mapTestDTOToTestDomain(testDTO);
            test.setId(UUID.fromString(testDTO.getId()));
            return testMapper.mapTestDomainToTestDTO(
                    testRepository.save(test)
            );
        } else {
            throw new NullPointerException("I can not find the Section with  id" + testDTO.getId());
        }
    }

    @Override
    public String deleteTest(UUID id) {
        boolean exists = testRepository.existsById(id);
        if (exists) {
            testRepository.deleteById(id);
            return "Data deleted";
        } else {
            throw new NullPointerException("I can not find the Section with  id" + id);
        }
    }

    @Override
    public TestQuestionAndAnswerDTO getAllQuestionAndAnswerWhichConnectedToTest(UUID testId) {
      return testRepository.findById(testId).map(test -> {
            List<Answer> answersByTestId = answerRepository.findAnswersByTestId(testId);
            List<Question> questionsByTestId = questionRepository.findWuestionsByTestId(testId);
            List<AnswerWithoutTestDTO> answerWithoutTestDTOS = answersByTestId.stream().map(answerMapper::mapAnswerDomainToAnswerWithoutTestDTO).collect(Collectors.toList());
            List<QuestionWithoutTestDTO> questionWithoutTestDTOS = questionsByTestId.stream().map(questionMapper::mapQuestionDomainToQuestionWithoutTestDTO).collect(Collectors.toList());
            return testMapper.mapTestQuestionAndAnswerDTO(test,questionWithoutTestDTOS,answerWithoutTestDTOS);
        }).orElseThrow(NullPointerException::new);

    }
}
