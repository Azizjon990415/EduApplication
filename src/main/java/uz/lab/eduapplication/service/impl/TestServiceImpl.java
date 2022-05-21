package uz.lab.eduapplication.service.impl;

import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.mapper.TestMapper;
import uz.lab.eduapplication.mapper.TestMapper;
import uz.lab.eduapplication.repository.TestRepository;
import uz.lab.eduapplication.repository.TestRepository;
import uz.lab.eduapplication.service.TestService;

import java.util.List;
import java.util.UUID;

public class TestServiceImpl implements TestService {
    private TestRepository testRepository;
    private TestMapper testMapper;

    @Override
    public List<TestDTO> getAllTests() {
        return null;
    }

    @Override
    public TestDTO getOneTest(UUID id) {
        return null;
    }

    @Override
    public TestDTO saveTest(TestDTO testDTO) {
        return null;
    }

    @Override
    public TestDTO editTest(TestDTO testDTO) {
        return null;
    }

    @Override
    public String deleteTest(UUID id) {
        return null;
    }
}
