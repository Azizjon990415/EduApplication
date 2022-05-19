package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Answer;

import java.util.UUID;

    public interface AnswerRepository extends JpaRepository<Answer, UUID> {
}
