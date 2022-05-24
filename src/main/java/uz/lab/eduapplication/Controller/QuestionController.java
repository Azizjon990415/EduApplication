package uz.lab.eduapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.service.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping()
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDTO getQuestion(@PathVariable UUID id) {
        return questionService.getOneQuestion(id);
    }

    @PostMapping()
    public QuestionDTO saveNewQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionService.saveQuestion(questionDTO);
    }

    @PutMapping()
    public QuestionDTO editQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionService.editQuestion(questionDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable UUID id) {
        return questionService.deleteQuestion(id);
    }
}
