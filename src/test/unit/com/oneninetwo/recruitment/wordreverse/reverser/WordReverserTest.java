package com.oneninetwo.recruitment.wordreverse.reverser;

import com.insightfullogic.lambdabehave.JunitSuiteRunner;
import org.junit.runner.RunWith;
import static com.insightfullogic.lambdabehave.Suite.describe;

@RunWith(JunitSuiteRunner.class)
public class WordReverserTest {{

    describe("word reversing", it -> {
        it.should("return the reversed input string", expect -> {
            String word = "awesome";

            String reversed = WordReverser.reverse(word);

            expect.that(reversed).is("emosewa");
        });
    });
}}