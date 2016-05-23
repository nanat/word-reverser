package com.oneninetwo.recruitment.wordreverse.receptioninst;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import com.oneninetwo.recruitment.wordreverse.greeter.Greeter;
import com.oneninetwo.recruitment.wordreverse.parser.MessageParser;
import com.oneninetwo.recruitment.wordreverse.receptionist.Receptionist;
import com.oneninetwo.recruitment.wordreverse.receptionist.Reply;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.insightfullogic.lambdabehave.Suite.describe;

@RunWith(JunitSuiteRunner.class)
public class ReceptionistTest {{

    describe("process user input", it -> {
        it.should("process the user input and reply with a welcome message containing the user name", expect -> {
            String userName = "Simona";
            Greeter greeter = Mockito.mock(Greeter.class);
            when(greeter.welcome(userName)).thenReturn(String.format("Good morning %s", userName));
            Receptionist receptionist = new Receptionist(greeter);
            String userInput = String.format("ohce %s", userName);

            Reply reply = receptionist.receive(userInput);

            verify(greeter, times(1)).welcome(userName);
            expect.that(reply.stop).is(false);
        });

        it.should("process the user input and reply with the reversed input", expect -> {
            Greeter greeter = Mockito.mock(Greeter.class);
            Receptionist receptionist = new Receptionist(greeter);
            String userInput = "hello";

            Reply reply = receptionist.receive(userInput);

            expect.that(reply.message).is("olleh");
            expect.that(reply.stop).is(false);
        });

        it.should("process the user input and reply with a goodbye message containing the user name", expect -> {
            String userName = "Simona";
            Greeter greeter = Mockito.mock(Greeter.class);
            when(greeter.goodbye(userName)).thenReturn(String.format("Good bye %s", userName));
            Receptionist receptionist = new Receptionist(greeter);
            receptionist.receive(String.format("ohce %s", userName));
            String userInput = MessageParser.STOP;

            Reply reply = receptionist.receive(userInput);

            verify(greeter, times(1)).goodbye(userName);
            expect.that(reply.stop).is(true);
        });
    });
}}