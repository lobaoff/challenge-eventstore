package net.intelie.challenges;

import java.util.LinkedList;
import java.util.Vector;

public class EventResult implements EventIterator {
    EventVector event = new EventVector();
    
    public EventResult(EventVector listEvent) {
        this.event = listEvent;
    }

    @Override
    public boolean moveNext() {
        return false;
    }

    @Override
    public Event current() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void close() throws Exception {

    }
}
