package com.example.sort;

import static com.example.sort.SortUtil.change;

/**
 * Created by 王心觉 on 2018/10/12.
 */

public class SelectionSort extends AbstructSort{


    @Override
    public int[] sort(int[] input) {
        return selectionSort(input,0,input.length - 1);
    }


    public int[] selectionSort(int[] input , int start , int end ) {
        SortUtil.print(input);

        for(int i = start; i<end ; i++) {
            int mark = i;
            for(int j = i + 1 ; j<=end ; j++){
                if(input[mark] > input[j]) {
                    mark = j;
                }
            }
            change(input,i,mark);
        }

        SortUtil.print("selectionSort:");
        SortUtil.print(input);

        return input;
    }
}
