package net.intelie.challenges;


/**
 * author: Gabriel F F Lobão
 */

import java.util.Arrays;

import java.util.Vector;

public class EventVector implements EventStore {
    /**
     * utilization of Class Vector is because Vector is Thread-Safe
     */
    Vector<Event> eventVector = new Vector<Event>();

    /**
     * @param event add a new event in the vector
     */
    @Override
    public void insert(Event event) {
        this.eventVector.add(event);
    }

    /**
     * @param type will delete some event that has the same type passed in parameter.

     */
    @Override
    public void removeAll(String type) {
        this.eventVector.removeIf(eventEach -> eventEach.type().equals(type));
    }

    @Override
    public EventIterator query(String type, long startTime, long endTime) {

        return null;


    }


}
