package com.oneninetwo.recruitment.wordreverse.receptionist;

public class Reply {

    public final String message;
    public final boolean stop;

    public Reply(final String message, final boolean stop) {
        this.message = message;
        this.stop = stop;
    }

    public Reply(final String message) {
        this(message, false);
    }
}