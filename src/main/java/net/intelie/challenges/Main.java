package net.intelie.challenges;

public class Main {
    public static void main(String[] args) {
       EventVector event = new EventVector();
       Event event1 = new Event("botafogo",300);
       Event event2 = new Event("123",300);

       event.insert(event1);
        event.insert(event2);

       event.removeAll("botafogo");
       event.removeAll("botafogo");
    }
}
