package com.asius.bookshop.Services;
import com.asius.bookshop.Entity.EventsEntity;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public interface EventsService {
    EventsEntity addEvent(EventsEntity event);

    EventsEntity updateEvent(EventsEntity event);

    Set<EventsEntity> getAllEvents();

    EventsEntity getEventById(Long idEvent);

    void deleteEvent(Long idEvent);
}
