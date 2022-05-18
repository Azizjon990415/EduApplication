package uz.lab.eduapplication.mapper;

import org.springframework.stereotype.Component;
import uz.lab.eduapplication.DTO.BookDTO;
import uz.lab.eduapplication.domain.Book;

@Component
public class BookMapper {
    public BookDTO mapBookDomainToBookDTO(Book book){
        return new BookDTO(book.getId().toString(), book.getNameUz(), book.getNameRu(), book.getNameEn(), book.getActive());
    }

    public Book mapBookDTOToBookDomain(BookDTO bookDTO){
        return new Book(bookDTO.getNameUz(), bookDTO.getNameRu(), bookDTO.getNameEn(), bookDTO.getActive());
    }
}
