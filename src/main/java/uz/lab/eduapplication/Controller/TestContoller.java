package uz.lab.eduapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.service.TestService;

import java.util.List;
import java.util.UUID;


@RestController
public class TestContoller {
    @Autowired
    TestService testService;

    @GetMapping("api/test")
    public List<TestDTO> getAllTest() {
        return testService.getAllTests();
    }

    @GetMapping("api/test/{id}")
    public TestDTO getTest(@PathVariable UUID id) {
        return testService.getOneTest(id);
    }

    @PostMapping("api/test")
    public TestDTO saveNewTest(@RequestBody TestDTO testDTO) {
        return testService.saveTest(testDTO);
    }

    @PutMapping("api/test/{id}")
    public TestDTO editTest(@PathVariable UUID id, @RequestBody TestDTO testDTO) {
        return testService.editTest(testDTO);
    }

    @DeleteMapping("api/test/{id}")
    public String deleteTest(@PathVariable UUID id) {
        return testService.deleteTest(id);
    }
}
