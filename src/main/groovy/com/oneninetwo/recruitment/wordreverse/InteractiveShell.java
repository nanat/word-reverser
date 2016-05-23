package com.oneninetwo.recruitment.wordreverse;

import com.oneninetwo.recruitment.wordreverse.greeter.TimeWindowGreeter;
import com.oneninetwo.recruitment.wordreverse.receptionist.Receptionist;
import com.oneninetwo.recruitment.wordreverse.receptionist.Reply;
import com.oneninetwo.recruitment.wordreverse.reverser.WordReverserWithComments;

import java.util.Scanner;

public class InteractiveShell {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Receptionist receptionist = new Receptionist(new TimeWindowGreeter(), new WordReverserWithComments());
        boolean stop = false;

        System.out.print("If you'd like to introduce yourself, type 'ohce' followed by your name.\n");

        while (!stop) {
            String message = scanner.nextLine();
            Reply reply = receptionist.receive(message);
            stop = reply.stop;
            System.out.print(reply.message + "\n");
        }
    }
}