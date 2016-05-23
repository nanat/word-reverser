package com.oneninetwo.recruitment.wordreverse.greeter;

import java.time.LocalDateTime;

public class TimeWindowGreeter implements Greeter {

    public enum Greetings {
        MORNING_GREET("Good morning"),
        AFTERNOON_GREET("Good afternoon"),
        NIGHT_GREET("Good night"),
        GOODBYE_GREET("Goodbye");

        private final String message;

        Greetings(String message) {
            this.message = message;
        }

        public String get() {
            return this.message;
        }
    }

    public String welcome(String name) {
        return String.format("%s %s", getTimeWindowGreetings(), name);
    }

    public String goodbye(String name) {
        return String.format("%s %s", Greetings.GOODBYE_GREET.get(), name);
    }

    private String getTimeWindowGreetings() {
        int hour = LocalDateTime.now().getHour();

        if (hour >= 20 || hour < 6)
            return Greetings.NIGHT_GREET.get();
        else if (hour >= 6 && hour < 12)
            return Greetings.MORNING_GREET.get();
        else
            return Greetings.AFTERNOON_GREET.get();
    }
}