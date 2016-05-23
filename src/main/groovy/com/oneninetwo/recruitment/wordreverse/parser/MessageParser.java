package com.oneninetwo.recruitment.wordreverse.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {

    public enum Message { WELCOME, REVERSE, STOP }

    public final static String STOP = "Stop!";
    private final static Pattern namePattern = Pattern.compile("ohce\\s.*");

    public static Message parse(String message) {
        Message msg;
        if (message.equals(STOP)) {
            msg = Message.STOP;
        }
        else {
            Matcher nameMatcher = namePattern.matcher(message);
            msg = nameMatcher.matches() ? Message.WELCOME : Message.REVERSE;
        }
        return msg;
    }
}