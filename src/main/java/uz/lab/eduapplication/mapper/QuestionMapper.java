package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.QuestionWithoutTestDTO;
import uz.lab.eduapplication.DTO.TestDTO;
import uz.lab.eduapplication.domain.Question;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.QuestionRepository;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.repository.TestRepository;

import java.util.Optional;
import java.util.UUID;

    @Component
    public class QuestionMapper {

        @Autowired
        TestRepository testRepository;
        @Autowired
        TestMapper testMapper;


        public Question mapQuestionDTOToQuestionDomain(QuestionDTO questionDTO){
           return questionDTO.getTestDTO().getId()==null ? new Question(questionDTO.getOrd(),questionDTO.getText(), testMapper.mapTestDTOToTestDomain(questionDTO.getTestDTO())) :
                   testRepository.findById(UUID.fromString(String.valueOf(questionDTO.getTestDTO().getId())))
                    .map(test -> new Question(questionDTO.getOrd(),questionDTO.getText(), test))
                           .orElseGet(()->new Question(questionDTO.getOrd(),questionDTO.getText(), testMapper.mapTestDTOToTestDomain(questionDTO.getTestDTO())));

        }

        public QuestionDTO mapQuestionDomainToQuestionDTO(Question question){
            return new QuestionDTO(question.getId().toString(), question.getOrd(), question.getText(), testMapper.mapTestDomainToTestDTO(question.getTest()));
        }

        public QuestionWithoutTestDTO mapQuestionDomainToQuestionWithoutTestDTO(Question question){
            return new QuestionWithoutTestDTO(question.getId().toString(), question.getOrd(), question.getText());
        }

    }
