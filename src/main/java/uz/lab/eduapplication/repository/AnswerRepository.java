package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Answer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    @Query(value = "select * from answer where test_id = :testId",nativeQuery = true)
    List<Answer> findAnswersByTestId(UUID testId);
}
