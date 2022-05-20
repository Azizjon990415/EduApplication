package uz.lab.eduapplication.service.impl;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.AnswerDTO;
import uz.lab.eduapplication.DTO.BookDTO;

import java.util.List;
import java.util.UUID;

@Service
public interface AnswerService {
    public List<AnswerDTO> getAllAnswers();
    public AnswerDTO getOneAnswer(UUID id);
    public AnswerDTO saveAnswer(AnswerDTO answer);
    public AnswerDTO editAnswer(AnswerDTO answer);
    public String deleteAnswer(UUID id);
}
