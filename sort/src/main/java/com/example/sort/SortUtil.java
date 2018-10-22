package com.example.sort;

/**
 * Created by 王心觉 on 2018/10/9.
 */

public class SortUtil {
    static public void print(int[] output){
        for(int i = 0; i<output.length ; i++){
            System.out.print(output[i]+",");
        }
        System.out.println();
    }

    static public void print(String s){
        System.out.println(s);
    }

    static public void print(int s){
        System.out.println(s);
    }

    //改变两个元素位置
    static public int[] change(int[] result, int index, int index2){
        int temp = result[index];
        result[index] = result[index2];
        result[index2] = temp;
        return result;
    }

    //把某个元素插入相应的位置
    static public int[] insert(int[] result, int startIndex, int endIndex){
        int temp = result[startIndex];
        for(int i = startIndex; i<endIndex; i++){
            result[i] = result[i+1];
        }
        result[endIndex] = temp;
        return result;
    }

    static public void copyArray(int[] fromArray , int fromStart ,int fromEnd ,int [] toArray,int toStart,int toEnd ){
        if(fromEnd - fromStart != toEnd - toStart){
            print("copyArray error");
        }

        for(int i = 0; i<=fromEnd - fromStart; i++){
             toArray[i + toStart] = fromArray[i + fromStart] ;
        }

        print(fromArray);
        print(toArray);

    }
}
