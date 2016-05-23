package com.oneninetwo.recruitment.wordreverse.reverser;

public class WordReverser {

    private final static String NICE_WORD = " Nice word!";

    public static String reverse(String word) {
        String reply = new StringBuilder(word).reverse().toString();
        if (!reply.isEmpty() && reply.equals(word))
            reply = reply + NICE_WORD;
        return reply;
    }
}