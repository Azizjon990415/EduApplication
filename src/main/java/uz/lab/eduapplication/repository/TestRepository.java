package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.eduapplication.domain.Test;

import java.util.UUID;

public interface TestRepository extends JpaRepository<Test, UUID> {
}
