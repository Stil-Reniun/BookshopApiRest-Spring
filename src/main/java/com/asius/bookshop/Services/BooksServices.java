package com.asius.bookshop.Services;
import com.asius.bookshop.Entity.BooksEntity;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface BooksServices {
    BooksEntity addNewBook(BooksEntity book);

    BooksEntity updateBook(BooksEntity book);

    Set<BooksEntity> getAllBooks();

    BooksEntity getBookById(Long idBook);

    void deleteBook(Long idBook);
}
