package com.asius.bookshop.Controllers;
import com.asius.bookshop.Entity.EventsEntity;
import com.asius.bookshop.Entity.exceptions.ResourceNotFoundException;
import com.asius.bookshop.Services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventsControllers {

    @Autowired
    private EventsService eventService;
    @PostMapping("/add")
    public ResponseEntity<EventsEntity> saveEvent(@RequestBody EventsEntity event) {
        EventsEntity savedEvent = eventService.addEvent(event);
        return ResponseEntity.ok(savedEvent);
    }
    @GetMapping("/{idEvent}")
    public ResponseEntity<EventsEntity> getEventById(@PathVariable(value = "idEvent") Long idEvent)
            throws ResourceNotFoundException {
        EventsEntity event = eventService.getEventById(idEvent);
        if (event == null) {
            throw new ResourceNotFoundException("Event not found with ID: " + idEvent);
        }
        return ResponseEntity.ok(event);
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PutMapping("/update")
    public EventsEntity updateEvent(@RequestBody EventsEntity event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/delete/{idEvent}")
    public void deleteEvent(@PathVariable("idEvent") Long idEvent) {
        eventService.deleteEvent(idEvent);
    }
}
