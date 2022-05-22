package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.QuestionRepository;
import uz.lab.eduapplication.DTO.QuestionDTO;

import java.util.Optional;
import java.util.UUID;

    @Component
    public class QuestionMapper {

        @Autowired
        QuestionRepository questionRepository;
        @Autowired
        QuestionMapper questionMapper;
        public Test mapQuestionDTOToQuestionDomain(QuestionDTO questionDTO){
            Optional<Question> questionOptional = questionRepository.findById(UUID.fromString(QuestionDTO.getQuestion().getId()));
            if (questionOptional.isPresent()){
                return new Question(questionDTO.getOrd(),questionDTO.getScore(), questionOptional.get());
            }else {
                return new Test(questionDTO.getOrd(),questionDTO.getScore(), questionMapper.mapQuestionDTOToQuestionDomain(),(questionDTO.getQuestionDTO()));
            }
        }

        public QuestionDTO mapQuestionDomainToQuestionDTO(Question question){
            return new TestDTO(question.getId().toString(), question.getOrd(), question.getScore(), questionMapper.mapQuestionDTOToQuestionDomain(question.getQuestion()));
        }

    }
