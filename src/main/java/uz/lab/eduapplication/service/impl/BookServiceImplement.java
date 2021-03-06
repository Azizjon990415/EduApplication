package uz.lab.eduapplication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.lab.eduapplication.DTO.BookDTO;
import uz.lab.eduapplication.DTO.BookWithSectionDTO;
import uz.lab.eduapplication.DTO.SectionWithoutBookDTO;
import uz.lab.eduapplication.domain.Book;
import uz.lab.eduapplication.mapper.BookMapper;
import uz.lab.eduapplication.repository.BookRepository;
import uz.lab.eduapplication.service.BookService;
import uz.lab.eduapplication.service.SectionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImplement implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private SectionService sectionService;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        books.forEach(book -> {
            BookDTO bookDTO = bookMapper.mapBookDomainToBookDTO(book);
            bookDTOS.add(bookDTO);
        });
        return bookDTOS;
    }

    @Override
    public BookDTO getOneBook(UUID id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            BookDTO bookDTO = bookMapper.mapBookDomainToBookDTO(book);
            return bookDTO;
        } else {
            throw new NullPointerException("I can not find the Book with  id" + id);
        }
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.mapBookDTOToBookDomain(bookDTO);
        Book savedBook = bookRepository.save(book);
        BookDTO savedBookDTO = bookMapper.mapBookDomainToBookDTO(savedBook);
        return savedBookDTO;
    }

    @Override
    public BookDTO editBook(BookDTO bookDTO) {
        boolean exists = bookRepository.existsById(UUID.fromString(bookDTO.getId()));
        if (exists) {
            Book book = bookMapper.mapBookDTOToBookDomain(bookDTO);
            Book savedBook = bookRepository.save(book);
            BookDTO savedBookDTO = bookMapper.mapBookDomainToBookDTO(savedBook);
            return savedBookDTO;
        } else {
            throw new NullPointerException("I can't find the Book with id" + bookDTO.getId());
        }
    }

    @Override
    public String deleteBook(UUID id) {
        boolean exists = bookRepository.existsById(id);
        if (exists) {
            bookRepository.deleteById(id);
            return "Data deleted";
        } else {
            throw new NullPointerException("I can not find the Sectione with id" + id);
        }
    }

    @Override
    public BookWithSectionDTO getBookWithSections(UUID bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            List<SectionWithoutBookDTO> sectionwithBookId = sectionService.getSectionwithBookId(bookId);
            BookWithSectionDTO bookWithSectionDTO = bookMapper.mapBookWithSectionDTO(book, sectionwithBookId);
            return bookWithSectionDTO;
        } else {
            throw  new NullPointerException();
        }
    }
}
