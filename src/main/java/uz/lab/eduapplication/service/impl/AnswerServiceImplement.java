package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import uz.lab.eduapplication.DTO.AnswerDTO;
import uz.lab.eduapplication.DTO.BookDTO;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.mapper.AnswerMapper;
import uz.lab.eduapplication.repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

    @AllArgsConstructor
    public class AnswerServiceImplement implements AnswerService {

        private AnswerRepository answerRepository;
        private AnswerMapper answerMapper;

        @Override
        public List<AnswerDTO> getAllAnswers() {
            List<Answer> answers = answerRepository.findAll();
            List<AnswerDTO> answerDTOS = new ArrayList<>();
            answers.forEach(answer -> {
                AnswerDTO answerDTO = answerMapper.mapAnswerDomainToAnswerDTO(answer);
                answerDTOS.add(answerDTO);
            });
            return answerDTOS;
        }

        @Override
        public AnswerDTO getOneAnswer(UUID id) {
            Optional<Answer> optionalAnswer = answerRepository.findById(id);
            if (optionalAnswer.isPresent()){
                Answer answer = optionalAnswer.get();
                AnswerDTO answerDTO = answerMapper.mapAnswerDomainToAnswerDTO(answer);
                return answerDTO;
            } else {
                throw new NullPointerException("I can not find the Answer with  id" + id);
            }
        }

        @Override
        public AnswerDTO saveAnswer(AnswerDTO answerDTO) {
            Answer answer = answerMapper.mapAnswerDTOToAnswerDomain(answerDTO);
            Answer savedAnswer = answerRepository.save(answer);
            AnswerDTO savedAnswerDTO = answerMapper.mapAnswerDomainToAnswerDTO(savedAnswer);
            return savedAnswerDTO;
        }

        @Override
        public AnswerDTO editAnswer(AnswerDTO answerDTO) {
            boolean exists = answerRepository.existsById(UUID.fromString(answerDTO.getId()));
            if (exists) {
                Answer answer = answerMapper.mapAnswerDTOToAnswerDTO(answerDTO);
                Answer savedAnswer = answerMapper.save(answer);
                AnswerDTO savedAnswerDTO = answerMapper.mapAnswerDomainToAnswerDTO(savedAnswer);
                return savedAnswerDTO;
            }else {
                throw new NullPointerException("I can't find the Answer with id"+ answerDTO.getId());
            }
        }

        @Override
        public String deleteAnswer(UUID id) {
            boolean exists = answerRepository.existsById(id);
            if (exists) {
                answerRepository.deleteById(id);
                return "Data deleted";
            }else {
                throw new NullPointerException("I can not find the Answer with id" + id);
            }
        }
    }
