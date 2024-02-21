package com.asius.bookshop.Repository;
import com.asius.bookshop.Entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksEntity, Long> {
}
