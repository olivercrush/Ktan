package com.orinine.ktan.dice;

import java.util.Random;

public class DiceThrower {

    public static int throwDice() {
        return new Random().nextInt(5) + 1;
    }

    // TODO : simulate probabilities of 2 die
    public static int throwTwoDice() {
        return throwDice() + throwDice();
    }

}
