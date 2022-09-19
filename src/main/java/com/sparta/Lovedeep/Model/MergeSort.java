package com.sparta.Lovedeep.Model;

import com.sparta.Lovedeep.Controller.Sorter;
import com.sparta.Lovedeep.View.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MergeSort implements Sorter {
    public static Logger logger= LogManager.getLogger(Starter.class);
    public static void mergeSort(int[] a, int n) {
        long startTime = System.nanoTime();
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    @Override
    public int[] sortArray(int[] arrayToSort)throws EmptyArrayException,SmallArrayException {
        if (arrayToSort == null) {
            logger.error("NullPointerException: Array is null!");
           // throw new NullPointerException("Array is null!");
        } else if (arrayToSort.length == 0) {
            logger.error("EmptyArrayException: Empty array!");
           //throw new EmptyArrayException("Empty array!");
        } else if (arrayToSort.length == 1) {
            logger.error("ArrayTooSmallException: Array must be larger than one!");
           // throw new SmallArrayException("Array must be larger than one!");
        } else

            mergeSort(arrayToSort, arrayToSort.length - 1);
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
