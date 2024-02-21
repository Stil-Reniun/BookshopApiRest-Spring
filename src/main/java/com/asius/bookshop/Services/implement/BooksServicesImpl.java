package com.asius.bookshop.Services.implement;
import com.asius.bookshop.Entity.BooksEntity;
import com.asius.bookshop.Repository.BooksRepository;
import com.asius.bookshop.Services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BooksServicesImpl implements BooksServices {
    @Autowired
    private BooksRepository booksRepository;
    @Override
    public BooksEntity addNewBook(BooksEntity book) {
        return booksRepository.save(book);
    }
    @Override
    public BooksEntity updateBook(BooksEntity book) {
        return booksRepository.save(book);
    }
    @Override
    public Set<BooksEntity> getAllBooks() {
        return new LinkedHashSet<>(booksRepository.findAll());
    }
    @Override
    public BooksEntity getBookById(Long idBook) {
        return booksRepository.findById(idBook).get();
    }
    @Override
    public void deleteBook(Long idBook) {
        BooksEntity book = new BooksEntity();
        book.setIdBook(idBook);
        booksRepository.delete(book);
    }
}
