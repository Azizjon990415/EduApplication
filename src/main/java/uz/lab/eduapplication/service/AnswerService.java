package uz.lab.eduapplication.service;

import uz.lab.eduapplication.DTO.AnswerDTO;

import java.util.List;
import java.util.UUID;


public interface AnswerService {
    public List<AnswerDTO> getAllAnswers();

    public AnswerDTO getOneAnswer(UUID id);

    public AnswerDTO saveAnswer(AnswerDTO answer);

    public AnswerDTO editAnswer(AnswerDTO answer);

    public String deleteAnswer(UUID id);
}
