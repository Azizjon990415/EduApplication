package uz.lab.eduapplication.service;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.DTO.TestDTO;

import java.util.List;
import java.util.UUID;

@Service
public interface TestService {
    public List<TestDTO> getAllTests();
    public TestDTO getOneTest(UUID id);
    public TestDTO saveTest(TestDTO testDTO);
    public TestDTO editTest(TestDTO testDTO);
    public String deleteTest(UUID id);
}
