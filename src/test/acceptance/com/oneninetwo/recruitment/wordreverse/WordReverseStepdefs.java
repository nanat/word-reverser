package com.oneninetwo.recruitment.wordreverse;

import com.oneninetwo.recruitment.wordreverse.greeter.TimeWindowGreeter;
import com.oneninetwo.recruitment.wordreverse.receptionist.Receptionist;
import com.oneninetwo.recruitment.wordreverse.receptionist.Reply;
import com.oneninetwo.recruitment.wordreverse.reverser.WordReverserWithComments;
import cucumber.api.java.Before;
import cucumber.api.java8.En;

import static org.junit.Assert.assertEquals;

public class WordReverseStepdefs implements En {

    private static Receptionist receptionist;
    private Reply reply;

    @Before
    public static void setUp() {
        receptionist = new Receptionist(new TimeWindowGreeter(), new WordReverserWithComments());
    }

    public WordReverseStepdefs() {

        When("^The user inputs a word such as \"([^\"]*)\"$", (String arg1) -> {
            reply = receptionist.receive(arg1);
        });

        Then("^The application will reply with \"([^\"]*)\"$", (String arg1) -> {
            assertEquals(reply.message, arg1);
            assert(!reply.stop);
        });

        When("^The user inputs a palindrome such as \"([^\"]*)\"$", (String arg1) -> {
            reply = receptionist.receive(arg1);
        });

        Then("^The applications replies with a nice comment: \"([^\"]*)\"$", (String arg1) -> {
            assertEquals(reply.message, arg1);
            assert(!reply.stop);
        });
    }
}