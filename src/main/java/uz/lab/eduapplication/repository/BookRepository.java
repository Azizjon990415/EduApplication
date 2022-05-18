package uz.lab.eduapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.eduapplication.domain.Book;


import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
