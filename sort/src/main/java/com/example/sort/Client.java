package com.example.sort;

public class Client {
    public static void main(String[] str){
        System.out.println("start sort");
        int [] number = {22,33,4,66,99,1,654,999,78,4567,3214,1234,44,564,2,1,334,12,22,33};
//        AbstructSort sort = new RadixSort();
//        AbstructSort sort = new QuickSort();
//        AbstructSort sort = new BubbleSort();
        AbstructSort sort = new MergeSort();

//        AbstructSort sort = new SelectionSort();

        sort.sort(number);
    }
}
