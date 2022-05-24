package uz.lab.eduapplication.service;

import uz.lab.eduapplication.DTO.QuestionDTO;

import java.util.List;
import java.util.UUID;

public interface QuestionService {
    public List<QuestionDTO> getAllQuestions();

    public QuestionDTO getOneQuestion(UUID id);

    public QuestionDTO saveQuestion(QuestionDTO question);

    public QuestionDTO editQuestion(QuestionDTO question);

    public String deleteQuestion(UUID id);

}
