package com.asius.bookshop.Controllers;
import com.asius.bookshop.Entity.BooksEntity;
import com.asius.bookshop.Entity.exceptions.ResourceNotFoundException;
import com.asius.bookshop.Services.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BooksControllers {

    @Autowired
    private BooksServices booksServices;

    @PostMapping("/add")
    public ResponseEntity<BooksEntity> saveBook(@RequestBody BooksEntity book) {
        BooksEntity savedBook = booksServices.addNewBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<BooksEntity> getBookById(@PathVariable(value = "idBook") Long idBook)
            throws ResourceNotFoundException {
        BooksEntity book = booksServices.getBookById(idBook);
        if (book == null) {
            throw new ResourceNotFoundException("Book not found with ID: " + idBook);
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping("/allBooks")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(booksServices.getAllBooks());
    }
    @PutMapping("/update")
    public BooksEntity updateBook(@RequestBody BooksEntity book){
        return booksServices.updateBook(book);
    }
    @DeleteMapping("/delete/{idBook}")
    public void deleteBook(@PathVariable("idBook") Long idBook){
        booksServices.deleteBook(idBook);
    }
}
