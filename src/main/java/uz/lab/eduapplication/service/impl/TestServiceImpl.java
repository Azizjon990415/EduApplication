package uz.lab.eduapplication.service.impl;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.mapper.TestMapper;
import uz.lab.eduapplication.repository.TestRepository;
import uz.lab.eduapplication.service.TestService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;
    private TestMapper testMapper;

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
}
