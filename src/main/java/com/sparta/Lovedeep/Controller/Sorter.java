package com.sparta.Lovedeep.Controller;

import com.sparta.Lovedeep.Model.EmptyArrayException;
import com.sparta.Lovedeep.Model.SmallArrayException;

public interface Sorter {
    int[] sortArray(int[] arrayToSort) throws EmptyArrayException, SmallArrayException;

}
