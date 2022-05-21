package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.mapper.QuestionMapper;
import uz.lab.eduapplication.repository.QuestionRepository;
import uz.lab.eduapplication.service.QuestionService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;
    @Override
    public List<QuestionDTO> getAllQuestions() {
        return null;
    }

    @Override
    public QuestionDTO getOneQuestion(UUID id) {
        return null;
    }

    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {
        return null;
    }

    @Override
    public QuestionDTO editQuestion(QuestionDTO questionDTO) {
        return null;
    }

    @Override
    public String deleteQuestion(UUID id) {
        return null;
    }

}
