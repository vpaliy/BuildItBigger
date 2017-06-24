package com.vpaliy.joker;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class JokeProvider implements Iterable<String> {

    private List<String> jokes;
    private Random random;
    private int lastJoke;

    public JokeProvider(){
        jokes= Arrays.asList(
                "There are 10 types of people in the world: those who understand binary, and those who don't.",
                "Knock, knock. Who's there?\n" +
                        "very long pause...\n" +
                        "Java."+
        "I put so much more effort into naming my first Wi-Fi than my first child."+
        "A programmer had a problem. He decided to use Java. He now has a ProblemFactory.");

        random=new Random();
        lastJoke=-1;
    }

    public String tellJoke(){
        int index=random.nextInt(jokes.size());
        while(index!=lastJoke){
            index=random.nextInt(jokes.size());
        }
        return jokes.get(index);
    }

    public List<String> getJokes() {
        return jokes;
    }

    @Override
    public Iterator<String> iterator() {
        return jokes.iterator();
    }
}
