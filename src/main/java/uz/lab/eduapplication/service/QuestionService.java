package uz.lab.eduapplication.service;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.service.impl.QuestionDTO;

import java.util.List;
import java.util.UUID;

    @Service
    public interface QuestionService {
        public List<QuestionDTO> getAllQuestions();
        public QuestionDTO getOneQuestion(UUID id);
        public QuestionDTO saveQuestion(QuestionDTO question);
        public QuestionDTO editQuestion(QuestionDTO question);
        public String deleteQuestion(UUID id);

}
