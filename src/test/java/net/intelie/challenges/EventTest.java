package net.intelie.challenges;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventTest {
    @Test
    public void thisIsAWarning() throws Exception {
        Event event = new Event("some_type", 123L);

        //THIS IS A WARNING:
        //Some of us (not everyone) are coverage freaks.
        assertEquals(123L, event.timestamp());
        assertEquals("some_type", event.type());
    }

    /**
     *
     * Insert two events
     */
    @Test
    public void insertTesting()  {
        Event event = new Event("some_type", 123L);
        Event event2 = new Event("some_type", 123L);
        EventRepository eventRepository = new EventRepository();
        eventRepository.insert(event);
        eventRepository.insert(event2);
        assertEquals(event,eventRepository.getRepository().get(0));
        assertEquals(event2,eventRepository.getRepository().get(1));

    }


    @Test
    public void testRemovingType()  {
        Event event = new Event("some_type", 123L);
        Event event2 = new Event("type", 123L);
        EventRepository eventRepository = new EventRepository();
        eventRepository.insert(event);
        eventRepository.insert(event2);
       eventRepository.removeAll(event.type());
        assertEquals(null,eventRepository.getRepository().get(0));



    }
    @Test
    public void moveIterator()  {
        Event event = new Event("some_type", 123L);
        Event event2 = new Event("some_type", 123L);
        EventRepository eventRepository = new EventRepository();
        eventRepository.insert(event);
        eventRepository.insert(event2);
        assertEquals(event,eventRepository.getRepository().get(0));
        eventRepository.query("some_type",123L,123L).moveNext();
        assertEquals(event,eventRepository.getRepository().get(1));

    }

}