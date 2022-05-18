package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.eduapplication.domain.Section;

import java.util.UUID;

public interface SectionRepository extends JpaRepository<Section, UUID> {
}
