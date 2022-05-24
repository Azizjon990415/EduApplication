package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.lab.eduapplication.domain.Answer;
import uz.lab.eduapplication.domain.Section;

import java.util.List;
import java.util.UUID;

public interface SectionRepository extends JpaRepository<Section, UUID> {
    @Query(value = "select * from section where book_id = :bookId",nativeQuery = true)
    List<Section> findSectionsByBookId(UUID bookId);
}
