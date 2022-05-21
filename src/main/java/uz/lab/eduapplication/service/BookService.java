package uz.lab.eduapplication.service;

import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.BookDTO;

import java.util.List;
import java.util.UUID;

@Service
public interface BookService {
    public List<BookDTO> getAllBooks();
    public BookDTO getOneBook(UUID id);
    public BookDTO saveBook(BookDTO book);
    public BookDTO editBook(BookDTO book);
    public String deleteBook(UUID id);
}
