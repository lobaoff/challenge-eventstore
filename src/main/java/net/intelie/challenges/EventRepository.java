package net.intelie.challenges;

/**
 * @author: Gabriel F F Lobão
 */

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class EventRepository implements EventStore {
    /**
     * utilization of Class Vector is because Vector is Thread-Safe
     */
    private Vector<Event> repository;

    public EventRepository() {
        this.repository = new Vector<Event>();
    }


    /**
     * @param event add a new event in the vector
     */
    @Override
    public synchronized void insert(Event event) {
        this.repository.add(event);
    }

    /**
     * @param type will delete some event that has the same type passed in parameter.
     */
    @Override
    public synchronized void removeAll(String type) {
        this.repository.removeIf(eventEach -> eventEach.type().equals(type));
    }

    @Override
    public synchronized EventIterator query(String type, long startTime, long endTime) {
        Vector<Event> listVector = new Vector<Event>();

        repository.stream().filter(event -> {
                    return event.type().equals(type) && ((event.timestamp() >= startTime && event.timestamp() <= endTime));
                }
        ).forEach(listVector::add);

        return new EventResult(listVector);
    }



    public synchronized Vector<Event> getRepository() {
        return this.repository;
    }
}
