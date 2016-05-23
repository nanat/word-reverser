package com.oneninetwo.recruitment.wordreverse;

import com.oneninetwo.recruitment.wordreverse.greeter.TimeWindowGreeter;
import com.oneninetwo.recruitment.wordreverse.receptionist.Receptionist;
import com.oneninetwo.recruitment.wordreverse.receptionist.Reply;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import static org.junit.Assert.assertEquals;

public class StopStepdefs implements En {

    private static Receptionist receptionist;
    private Reply reply;

    @Before
    public static void setUp() {
        receptionist = new Receptionist(new TimeWindowGreeter());
    }

    public StopStepdefs() {

        Given("^The current user name is \"([^\"]*)\"$", (String arg1) -> {
            receptionist.receive(String.format("ohce %s", arg1));
        });

        When("^The user inputs \"([^\"]*)\"$", (String arg1) -> {
            reply = receptionist.receive(arg1);
        });

        Then("^the applications greets \"([^\"]*)\" and stops$", (String arg1) -> {
            assertEquals(reply.message, arg1);
            assert(reply.stop);
        });
    }
}