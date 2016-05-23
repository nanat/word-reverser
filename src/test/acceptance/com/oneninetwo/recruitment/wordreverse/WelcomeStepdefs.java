package com.oneninetwo.recruitment.wordreverse;

import com.oneninetwo.recruitment.wordreverse.greeter.Greeter;
import com.oneninetwo.recruitment.wordreverse.receptionist.Receptionist;
import com.oneninetwo.recruitment.wordreverse.receptionist.Reply;
import com.oneninetwo.recruitment.wordreverse.reverser.WordReverser;
import cucumber.api.java8.En;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class WelcomeStepdefs implements En {

    private Receptionist receptionist;
    private Reply reply;

    public WelcomeStepdefs() {

        Given("^The user \"([^\"]*)\" is connecting in the morning$", (String arg1) -> {
            Greeter greeter = Mockito.mock(Greeter.class);
            WordReverser wordReverser = Mockito.mock(WordReverser.class);
            when(greeter.welcome(arg1)).thenReturn(String.format("Good morning %s", arg1));
            receptionist = new Receptionist(greeter, wordReverser);
        });

        When("^The user types \"([^\"]*)\"$", (String arg1) -> {
            reply = receptionist.receive(arg1);
        });

        Then("^The user is prompt \"([^\"]*)\"$", (String arg1) -> {
            assertEquals(reply.message, arg1);
            assert(!reply.stop);
        });

        Given("^The user \"([^\"]*)\" is connecting in the afternoon$", (String arg1) -> {
            Greeter greeter = Mockito.mock(Greeter.class);
            WordReverser wordReverser = Mockito.mock(WordReverser.class);
            when(greeter.welcome(arg1)).thenReturn(String.format("Good afternoon %s", arg1));
            receptionist = new Receptionist(greeter, wordReverser);
        });

        Then("^The user is prompt a Good afternoon \"([^\"]*)\" welcome message$", (String arg1) -> {
            assertEquals(reply.message, String.format("Good afternoon %s", arg1));
            assert(!reply.stop);
        });

        Given("^The user \"([^\"]*)\" is connecting in the night$", (String arg1) -> {
            Greeter greeter = Mockito.mock(Greeter.class);
            WordReverser wordReverser = Mockito.mock(WordReverser.class);
            when(greeter.welcome(arg1)).thenReturn(String.format("Good night %s", arg1));
            receptionist = new Receptionist(greeter, wordReverser);
        });

        Then("^The user is prompt a Good night \"([^\"]*)\" welcome message$", (String arg1) -> {
            assertEquals(reply.message, String.format("Good night %s", arg1));
            assert(!reply.stop);
        });
    }
}