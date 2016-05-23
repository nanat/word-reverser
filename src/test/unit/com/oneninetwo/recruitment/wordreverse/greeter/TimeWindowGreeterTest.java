package com.oneninetwo.recruitment.wordreverse.greeter;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import org.junit.runner.RunWith;
import java.time.LocalDateTime;

import static com.insightfullogic.lambdabehave.Suite.describe;

@RunWith(JunitSuiteRunner.class)
public class TimeWindowGreeterTest {{

    describe("user welcome", it -> {
        it.should("reply with a welcome message depending on the current time", expect -> {
            TimeWindowGreeter greeter = new TimeWindowGreeter();
            String userName = "Simona";
            int currentHour = LocalDateTime.now().getHour();

            String message = greeter.welcome(userName);

            if (currentHour >= 20 || currentHour < 6)
                expect.that(message).is(String.format("%s %s", TimeWindowGreeter.Greetings.NIGHT_GREET.get(), "Simona"));
            else if (currentHour >= 6 && currentHour < 12)
                expect.that(message).is(String.format("%s %s", TimeWindowGreeter.Greetings.MORNING_GREET.get(), "Simona"));
            else
                expect.that(message).is(String.format("%s %s", TimeWindowGreeter.Greetings.AFTERNOON_GREET.get(), "Simona"));
        });
    });

    describe("user goodbye", it -> {
        it.should("reply with a good bye message", expect -> {
            TimeWindowGreeter greeter = new TimeWindowGreeter();
            String userName = "Simona";

            String message = greeter.goodbye(userName);

            expect.that(message).is(String.format("%s %s", TimeWindowGreeter.Greetings.GOODBYE_GREET.get(), "Simona"));
        });
    });
}}