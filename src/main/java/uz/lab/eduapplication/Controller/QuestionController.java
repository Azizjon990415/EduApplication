package uz.lab.eduapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.service.QuestionService;
import uz.lab.eduapplication.service.impl.QuestionDTO;
import uz.lab.eduapplication.service.impl.QuestionService;

import java.util.List;
import java.util.UUID;

    @RestController
    public class QuestionController {
        @Autowired
        QuestionService questionService;
        @GetMapping("api/question")
        public List<QuestionDTO> getAllQuestions(){
            return questionService.getAllQuestions();
        }

        @GetMapping("api/question/{id}")
        public QuestionDTO getQuestion(@PathVariable UUID id){
            return questionService.getOneQuestion(id);
        }

        @PostMapping("api/question")
        public QuestionDTO saveNewQuestion(@RequestBody QuestionDTO questionDTO){
            return questionService.saveQuestion(questionDTO);
        }

        @PutMapping("api/question/{id}")
        public QuestionDTO editQuestion(@PathVariable Long id,@RequestBody QuestionDTO questionDTO){
            return questionService.editQuestion(questionDTO);
        }

        @DeleteMapping("api/question/{id}")
        public String deleteQuestion(@PathVariable UUID id){
            return questionService.deleteQuestion(id);
        }
}
