package com.sparta.Lovedeep.Model;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;

public class GenerateArray {


    public static int[] generateArray(Integer length) {

        return generateArray(length, 1, 1000);
    }

    public static int[] generateArray(int length, int lowest, int highest) {
        int[] generatedArray = new int[length];

        for (int i = 0; i < generatedArray.length; i++) {
            generatedArray[i] = new Random().nextInt(highest - lowest + 1) + lowest;
        }
        return generatedArray;
    }
}
