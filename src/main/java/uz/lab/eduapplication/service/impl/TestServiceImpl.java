package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.mapper.AnswerMapper;
import uz.lab.eduapplication.mapper.TestMapper;
import uz.lab.eduapplication.repository.testRepository;
import uz.lab.eduapplication.repository.TestRepository;
import uz.lab.eduapplication.service.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class TestServiceImplement implements TestService {

    private TestRepository testRepository;
    private TestMapper testMapper;

    @Override
    public List<TestDTO> getAllTests() {
        List<Test> tests = testRepository.findAll();
        List<Test> answerDTOS = new ArrayList<>();
        tests.forEach(test -> {
            TestDTO answerDTO = testMapper.mapTestDomainToTestDTO(test);
            answerDTOS.add(answerDTO);
        });
        return answerDTOS;
    }

    @Override
    public TestDTO getOneTest(UUID id) {
        Optional<Test> optionalAnswer = testRepository.findById(id);
        if (optionalAnswer.isPresent()){
            Test test = optionalAnswer.get();
            TestDTO testDTO = testMapper.mapTestDomainToTestDTO(test);
            return answerDTO;
        } else {
            throw new NullPointerException("I can not find the Test with  id" + id);
        }
    }

    @Override
    public TestDTO saveTest(TestDTO test) {
        Test test = testMapper.mapTestDomainToTestDomain(answerDTO);
        Test saved = testRepository.save(test);mapTestDomainToTestDTO
        TestDTO savedTestDTO = testMapper.(savedTest);
        return savedTestDTO;
    }

    @Override
    public TestDTO editTest(TestDTO test) {
        boolean exists = testRepository.existsById(UUID.fromString(testDTO.getID()));
        if (exists) {
            Test test = testMapper.mapTestDTOToTestDomain(testDTO);
            Test savedTest = testMapper.save(test);
            TestDTO savedTestDTO = testMapper.mapTestDomainToTestDTO(savedTest);
            return savedTestDTO;
        }else {
            throw new NullPointerException("I can't find the Test with id"+ testDTO.getId());
        }
    }

    @Override
    public String deleteTest(UUID id) {
        boolean exists = testRepository.existsById(id);
        if (exists) {
            testRepository.deleteById(id);
            return "Data deleted";
        }else {
            throw new NullPointerException("I can not find the Sectione with id" + id);
        }
    }
}
