package uz.lab.eduapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.eduapplication.domain.Question;

import java.util.UUID;

public interface QuestionRepository  extends JpaRepository<Question, UUID> {

}
