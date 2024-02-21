package com.asius.bookshop.Repository;
import com.asius.bookshop.Entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<EventsEntity,Long> {
}
