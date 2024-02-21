package com.asius.bookshop.Services.implement;
import com.asius.bookshop.Entity.EventsEntity;
import com.asius.bookshop.Repository.EventsRepository;
import com.asius.bookshop.Services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class EventsServicesImpl implements EventsService {
    @Autowired
    private EventsRepository eventsRepository;
    @Override
    public EventsEntity addEvent(EventsEntity event) {
        return eventsRepository.save(event);
    }

    @Override
    public EventsEntity updateEvent(EventsEntity event) {
        return eventsRepository.save(event);
    }

    @Override
    public Set<EventsEntity> getAllEvents() {
        return new LinkedHashSet<>(eventsRepository.findAll());
    }

    @Override
    public EventsEntity getEventById(Long idEvent) {
        return eventsRepository.findById(idEvent).get();
    }

    @Override
    public void deleteEvent(Long idEvent) {
        EventsEntity event = new EventsEntity();
        event.setIdEvent(idEvent);
        eventsRepository.delete(event);

    }
}