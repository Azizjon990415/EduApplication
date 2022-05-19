package uz.lab.eduapplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.AnswerDTO;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Test;
import uz.lab.eduapplication.repository.TestRepository;

import java.util.Optional;
import java.util.UUID;

@Component
public class AnswerMapper {
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestMapper testMapper;

    public AnswerDTO mapAnswerDomainToAnswerDTO(Answer answer){
        return new AnswerDTO(answer.getId().toString(), answer.getIsCorrect(), answer.getText(), testMapper.mapTestDomainToTestDTO(answer.getTest()));
    }

    public Answer mapAnswerDTOToAnswerDomain(AnswerDTO answerDTO){
        Optional<Test> testOptional = testRepository.findById(UUID.fromString(answerDTO.getTestDTO().getId()));
        if (testOptional.isPresent()){
            return new Answer(answerDTO.getIsCorrect(), answerDTO.getText(), testOptional.get());
        }else {
            return new Answer(answerDTO.getIsCorrect(), answerDTO.getText(), testMapper.mapTestDTOToTestDomain(answerDTO.getTestDTO()));
        }
    }
}
