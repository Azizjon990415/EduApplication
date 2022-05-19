package uz.lab.eduapplication.mapper;

import uz.lab.eduapplication.DTO.AnswerDTO;
import uz.lab.eduapplication.domain.Answer;

public class AnswerMapper {
    public AnswerDTO mapAnswerDomainToAnswerDTO(Answer answer){
        return new AnswerDTO(answer.getId().toString(), answer.getIsCorrect(), answer.getText(), answer.getTest());
    }

    public Answer mapAnswerDTOToAnswerDomain(AnswerDTO answerDTO){
        return new Answer(answerDTO.getIsCorrect(), answerDTO.getText(), answerDTO.getTest());
    }
}
