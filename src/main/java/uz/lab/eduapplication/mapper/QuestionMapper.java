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
        TestMapper testMapper;


        public Question mapQuestionDTOToQuestionDomain(QuestionDTO questionDTO){
           return questionDTO.getId()==null ? new Question(questionDTO.getOrd(),questionDTO.getText(), testMapper.mapTestDTOToTestDomain(questionDTO.getTest())) :
                   questionRepository.findById(UUID.fromString(String.valueOf(questionDTO.getId())))
                    .map(question -> new Question(question.getOrd(),question.getText(), question.getTest()))
                           .orElseGet(()->new Question(questionDTO.getOrd(),questionDTO.getText(), testMapper.mapTestDTOToTestDomain(questionDTO.getTest())));

        }

        public QuestionDTO mapQuestionDomainToQuestionDTO(Question question){
            return new QuestionDTO(question.getId().toString(), question.getOrd(), question.getText(), testMapper.mapTestDomainToTestDTO(question.getTest()));
        }

    }
