package com.example;

import java.util.Random;

public class MyClass {

    private static String[] joke = {
            "Isn't it great to live in the 21st century? Where deleting history has become more important than making it.",
            "Whenever I'm sad I just read my blood donor ID. It always says \"B\n" +
                    "positive\".\n" ,
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\"",
            "It has four legs and it can fly, what is it? \n" +
                    "-\n" +
                    "Two birds.\n",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it."
    };


    public static final String getJoke() {
        Random rm = new Random();
        return joke[rm.nextInt(joke.length)];
    }
}
