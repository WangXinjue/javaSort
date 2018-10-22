package com.example.sort;

import static com.example.sort.SortUtil.copyArray;
import static com.example.sort.SortUtil.print;

/**
 * Created by 王心觉 on 2018/10/11.
 */

public class MergeSort extends AbstructSort{

    public static int count = 0;

    @Override
    public int[] sort(int[] input) {
        return mergeSort(input,0,input.length - 1);
    }

    //并归排序
    private int[] mergeSort(int[] input , int start , int end ) {
        count ++;
        if(count > 300){
            return input;
        }
        int longth = end - start;

        //长度小于3，就直接选择排序了
        if(longth <= 3) {
            print("selectionSort start="+start);
            print("selectionSort end="+end);
            return new SelectionSort().selectionSort(input,start,end);
        }

        int middle = start + longth/2;

        //拆分成两个归并排序
        mergeSort(input,start,middle);
        mergeSort(input,middle + 1,end);

        //两个有序的数列，进行插入排序，遍历一次，就可以排完了
        insertSort(input,start,end,middle);

        return input;
    }


    //把一个数列，按中间点，分成两个数列
    //这两个数列，已经是经过并归排序生成的有序数列
    //
    private int[] insertSort(int[] input ,int start,int end ,int middle){

        print("insertSort start= " + start + " end= "+end);

        //辅助数组，存放一次并归的结果
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = middle + 1;
        int count = 0;

        while (j <= end && i<=middle){
            if(input[i] > input[j]) {
                temp [count] = input[j];
                j++;

            } else {
                temp [count] = input[i];
                i++;

            }
            count ++;
        }

        print("print temp middle");
        print(temp);

        if(j > end ) {
            for(;count<temp.length;count++){
                temp [count] = input[i];
                i++;
            }
        }

        if(i > middle ) {
            for(;count<temp.length;count++){
                temp [count] = input[j];
                j++;
            }
        }

        print("print temp final");
        print(temp);


        copyArray(temp,0,temp.length - 1,input,start,end);
        print("print input:");
        print(temp);

        return input;
    }

}
