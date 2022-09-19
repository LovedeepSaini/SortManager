package com.sparta.Lovedeep.Model;

import com.sparta.Lovedeep.Controller.Sorter;
import com.sparta.Lovedeep.View.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort implements Sorter {
   public static Logger logger= LogManager.getLogger(Starter.class);
    public void BubbleSort(int[] arrayToSort) {



        int i = 0, n = arrayToSort.length;

    boolean swap = true;
        while (i < n - 1 && swap) {
        swap = false;
        for (int j = 1; j < n - i; j++) {
            if (arrayToSort[j - 1] > arrayToSort[j]) {
                int temp = arrayToSort[j - 1];
                arrayToSort[j - 1] = arrayToSort[j];
                arrayToSort[j] = temp;
                swap= true;
            }
        }
        if (!swap) {
            break;
        }
        i++;
    }

}
    @Override
    public int[] sortArray(int[] arrayToSort) throws EmptyArrayException,SmallArrayException{
        if (arrayToSort == null) {
            logger.error("NullPointerException: Array is null!");
          // throw new NullPointerException("Array is null!");
        } else if (arrayToSort.length == 0) {
            logger.error("EmptyArrayException: Empty array!");
            //throw new EmptyArrayException("Empty array!");
        } else if (arrayToSort.length == 1) {
            logger.error("SmallArrayException: Array must be larger than one!");
           //throw new SmallArrayException("Array must be larger than one!");
        }

        BubbleSort(arrayToSort);

        return arrayToSort;
    }
    public static boolean isSorted(int[] arrayToCheck) {

        for(int i = 0; i < arrayToCheck.length - 1; i++) {
            if(arrayToCheck[i] > arrayToCheck[i+1]) {
                return false;
            }
        }
        return true;
    }

}

