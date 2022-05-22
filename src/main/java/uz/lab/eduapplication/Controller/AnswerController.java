package uz.lab.eduapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.AnswerDTO;
import uz.lab.eduapplication.service.impl.AnswerService;

import java.util.List;
import java.util.UUID;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping("api/answer")
    public List<AnswerDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("api/answer/{id}")
    public AnswerDTO getAnswer(@PathVariable UUID id) {
        return answerService.getOneAnswer(id);
    }

    @PostMapping("api/answer")
    public AnswerDTO saveNewAnswer(@RequestBody AnswerDTO answerDTO) {
        return answerService.saveAnswer(answerDTO);
    }

    @PutMapping("api/answer/{id}")
    public AnswerDTO editAnswer(@PathVariable Long id, @RequestBody AnswerDTO answerDTO) {
        return answerService.editAnswer(answerDTO);
    }

    @DeleteMapping("api/answer/{id}")
    public String deleteAnswer(@PathVariable UUID id) {
        return answerService.deleteAnswer(id);
    }
}
