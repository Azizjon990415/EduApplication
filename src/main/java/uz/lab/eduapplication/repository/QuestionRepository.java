package uz.lab.eduapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository  extends JpaRepository<Question, UUID> {
    @Query(value = "select * from question where test_id = :testId",nativeQuery = true)
    List<Question> findWuestionsByTestId(UUID testId);
}
