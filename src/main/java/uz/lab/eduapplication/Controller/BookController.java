package uz.lab.eduapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.eduapplication.DTO.BookDTO;
import uz.lab.eduapplication.DTO.BookWithSectionDTO;
import uz.lab.eduapplication.DTO.QuestionDTO;
import uz.lab.eduapplication.service.BookService;
import uz.lab.eduapplication.service.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping()
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable UUID id) {
        return bookService.getOneBook(id);
    }

    @PostMapping()
    public BookDTO saveNewBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping()
    public BookDTO editBook(@RequestBody BookDTO bookDTO) {
        return bookService.editBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable UUID id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/book-with-section/{bookId}")
    public BookWithSectionDTO getBookWithSections(@PathVariable UUID bookId){
        return bookService.getBookWithSections(bookId);
    }

}
