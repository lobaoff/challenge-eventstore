package net.intelie.challenges;

import java.util.*;

public class EventResult implements EventIterator {
    private final Iterator<Event> eventIterator;
    private static int countMoveNext = 0;
    private Event current;

    public EventResult( Vector<Event> listEvent) {
        this.current = listEvent.firstElement();
        this.eventIterator = listEvent.iterator();
    }


    @Override
    public synchronized boolean moveNext() {
       if (this.eventIterator.hasNext()) {
            this.eventIterator.next();
         this.current = this.eventIterator.next();
           countMoveNext++;
         return true;
        }
        return false;
    }

    @Override
    public synchronized Event current() {
        return this.current;
        }


    @Override
    public synchronized void remove() {
        if((!this.eventIterator.hasNext())|| countMoveNext ==0) {
            throw new IllegalStateException();
        } else {
            eventIterator.remove();
        }
    }

    @Override
    public void close() throws Exception {

    }
}

