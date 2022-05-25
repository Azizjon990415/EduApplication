package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.lab.eduapplication.domain.Section;
import uz.lab.eduapplication.domain.Test;

import java.util.List;
import java.util.UUID;

public interface TestRepository extends JpaRepository<Test, UUID> {
    @Query(value = "select * from test where section_id = :sectionId",nativeQuery = true)
    List<Test> findTestsBySectionId(UUID sectionId);
}
