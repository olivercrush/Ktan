package com.orinine.ktan.dice;

import java.util.Random;

public class DiceThrower {

    public static int throwDice() {
        return new Random().nextInt(5) + 1;
    }

    public static int throwTwoDice() {
        return throwDice() + throwDice();
    }

}
