package com.oneninetwo.recruitment.wordreverse.receptionist;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import com.oneninetwo.recruitment.wordreverse.greeter.TimeWindowGreeter;
import com.oneninetwo.recruitment.wordreverse.parser.MessageParser;
import org.junit.runner.RunWith;
import java.time.LocalDateTime;
import static com.insightfullogic.lambdabehave.Suite.describe;

@RunWith(JunitSuiteRunner.class)
public class ReceptionistIntegrationTest {{

    describe("process user input", it -> {
        it.should("process the user input and reply with a welcome message", expect -> {
            Receptionist receptionist = new Receptionist(new TimeWindowGreeter());
            int currentHour = LocalDateTime.now().getHour();
            String userInput = "ohce Simona";

            Reply reply = receptionist.receive(userInput);

            if (currentHour >= 20 || currentHour < 6)
                expect.that(reply.message).is(String.format("%s %s", TimeWindowGreeter.Greetings.NIGHT_GREET.get(), "Simona"));
            else if (currentHour >= 6 && currentHour < 12)
                expect.that(reply.message).is(String.format("%s %s", TimeWindowGreeter.Greetings.MORNING_GREET.get(), "Simona"));
            else
                expect.that(reply.message).is(String.format("%s %s", TimeWindowGreeter.Greetings.AFTERNOON_GREET.get(), "Simona"));

            expect.that(reply.stop).is(false);
        });

        it.should("process the user input and reply with the reversed input", expect -> {
            Receptionist receptionist = new Receptionist(new TimeWindowGreeter());
            String userInput = "hello";

            Reply reply = receptionist.receive(userInput);

            expect.that(reply.message).is("olleh");
            expect.that(reply.stop).is(false);
        });

        it.should("process the user input and reply with a goodbye", expect -> {
            Receptionist receptionist = new Receptionist(new TimeWindowGreeter());
            receptionist.receive("ohce Simona");
            String userInput = MessageParser.STOP;

            Reply reply = receptionist.receive(userInput);

            expect.that(reply.message).is(String.format("%s %s", TimeWindowGreeter.Greetings.GOODBYE_GREET.get(), "Simona"));
            expect.that(reply.stop).is(true);
        });
    });
}}