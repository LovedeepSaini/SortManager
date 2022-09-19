package com.sparta.Lovedeep.Controller;

import com.sparta.Lovedeep.Model.BinarySort;
import com.sparta.Lovedeep.Model.BubbleSort;
import com.sparta.Lovedeep.Model.MergeSort;

public class SortFactory {
    public static Sorter getSort(String sortType) {
        if(sortType == null){
            return null;
        }
        if(sortType.equalsIgnoreCase("BinarySort")){
            return new BinarySort();

        } else if(sortType.equalsIgnoreCase("BubbleSort")){
            return new BubbleSort();

        } else if(sortType.equalsIgnoreCase("MergeSort")){
            return new MergeSort();
        }

        return null;
    }

}
