package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.lab.eduapplication.DTO.BookDTO;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class QuestionDTO {
        private String id;
        private String computer;
        private String Math;
        private String aboutYou;
        private Boolean words;
        private QuestionDTO questionDTO;

        public static Thread getQuestion() {
            return null;
        }

        public String getOrd() {
        }

        public String getScore() {
        }
    }
