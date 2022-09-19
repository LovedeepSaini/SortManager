package com.sparta.Lovedeep.View;

import com.sparta.Lovedeep.Controller.Sorter;
import com.sparta.Lovedeep.Controller.SortFactory;
import com.sparta.Lovedeep.Model.EmptyArrayException;
import com.sparta.Lovedeep.Model.GenerateArray;
import com.sparta.Lovedeep.Model.SmallArrayException;

import java.util.Arrays;
import java.util.Scanner;

public class Starter {
    public static void start() throws SmallArrayException, EmptyArrayException {



            System.out.println(Arrays.toString(chooseMethod()));



    }

    public static int[] chooseMethod() throws SmallArrayException, EmptyArrayException {
        SortFactory sortFactory = new SortFactory();
        Sorter bubbleSort = SortFactory.getSort("BubbleSort");

        Sorter binarySort = SortFactory.getSort("BinarySort");

        Sorter mergeSort = SortFactory.getSort("MergeSort");
        GenerateArray genArray = new GenerateArray();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int len = s.nextInt();
        System.out.println("1.Binary ");
        System.out.println("2. Bubble");
        System.out.println("3. Merge");
        System.out.println("Enter your choice:");

        Scanner input = new Scanner(System.in);
        String choose = input.next();


        if (choose.equals("1")) {


            return binarySort.sortArray(genArray.generateArray(len));

        } else if (choose.equals("2")) {

            return bubbleSort.sortArray(genArray.generateArray(len));

        }

        return mergeSort.sortArray(genArray.generateArray(len));
    }

}
