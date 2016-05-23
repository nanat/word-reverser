package com.oneninetwo.recruitment.wordreverse.receptionist;

import com.oneninetwo.recruitment.wordreverse.greeter.Greeter;
import com.oneninetwo.recruitment.wordreverse.parser.MessageParser;
import com.oneninetwo.recruitment.wordreverse.reverser.WordReverser;

public class Receptionist {

    private Greeter greeter;
    private WordReverser reverser;
    private String userName = "";

    public Receptionist(Greeter greeter, WordReverser reverser) {
        this.greeter = greeter;
        this.reverser = reverser;
    }

    public Reply receive(String message) {

        MessageParser.Message messageType = MessageParser.parse(message);

        Reply reply;
        switch (messageType) {
            case WELCOME:
                userName = message.split(" ")[1];
                reply = new Reply(greeter.welcome(userName));
                break;
            case REVERSE:
                reply = new Reply(reverser.reverse(message));
                break;
            case STOP:
                reply = new Reply(greeter.goodbye(userName), true);
                break;
            default:
                reply = new Reply("");
                break;
        }

        return reply;
    }
}