package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.mapper.QuestionMapper;
import uz.lab.eduapplication.repository.QuestionRepository;
import uz.lab.eduapplication.service.QuestionService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(questionMapper::mapQuestionDomainToQuestionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDTO getOneQuestion(UUID id) {
        return questionRepository.findById(id)
                .map(questionMapper::mapQuestionDomainToQuestionDTO)
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {
        return questionMapper.mapQuestionDomainToQuestionDTO(
                questionRepository.save(
                        questionMapper.mapQuestionDTOToQuestionDomain(questionDTO)
                )
        );
    }

    @Override
    public QuestionDTO editQuestion(QuestionDTO questionDTO) {
        boolean exists = questionRepository.existsById(UUID.fromString(questionDTO.getId()));
        if (exists) {
            Question question = questionMapper.mapQuestionDTOToQuestionDomain(questionDTO);
            question.setId(UUID.fromString(questionDTO.getId()));
            return questionMapper.mapQuestionDomainToQuestionDTO(
                    questionRepository.save(question)
            );
        } else {
            throw new NullPointerException("I can not find the Section with  id" + questionDTO.getId());
        }
    }

    @Override
    public String deleteQuestion(UUID id) {
        boolean exists = questionRepository.existsById(id);
        if (exists) {
            questionRepository.deleteById(id);
            return "Data deleted";
        } else {
            throw new NullPointerException("I can not find the Section with  id" + id);
        }
    }


}
