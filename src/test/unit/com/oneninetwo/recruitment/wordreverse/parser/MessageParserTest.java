package com.oneninetwo.recruitment.wordreverse.parser;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import org.junit.runner.RunWith;
import static com.insightfullogic.lambdabehave.Suite.describe;

@RunWith(JunitSuiteRunner.class)
public class MessageParserTest {{

    describe("user input parsing", it -> {
        it.should("parse the user input and reply with WELCOME", expect -> {
            String userInput = "ohce Simona";

            MessageParser.Message parsed = MessageParser.parse(userInput);

            expect.that(parsed).is(MessageParser.Message.WELCOME);
        });

        it.should("parse the user input and reply with REVERSE", expect -> {
            String userInput = "hello";

            MessageParser.Message parsed = MessageParser.parse(userInput);

            expect.that(parsed).is(MessageParser.Message.REVERSE);
        });

        it.should("parse the user input and reply with STOP", expect -> {
            String userInput = MessageParser.STOP;

            MessageParser.Message parsed = MessageParser.parse(userInput);

            expect.that(parsed).is(MessageParser.Message.STOP);
        });
    });
}}