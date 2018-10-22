package com.example.sort;

import static com.example.sort.SortUtil.change;
import static com.example.sort.SortUtil.insert;

/**
 * Created by 王心觉 on 2018/10/9.
 */

public class QuickSort extends AbstructSort {


    private int[] sort(int[] input , int start , int end){

        //oldStart,oldEnd,是起始位置，用来递归下一次排序
        //oldStart，标记初始位置，在一次排序之后，用来把第一个元素，插入相应位置
        //start，end，是游标（哨兵）当前位置
        int oldStart = start;
        int oldEnd = end;

        if(start >= end){
            return input;
        }
        SortUtil.print("begin~~~~~~~~~~~~~~~~~~~~~~~");
        SortUtil.print(input);

        //跑哨兵，交换不符合规定的元素的位置
        while (start < end){

            //先做end -- ，就是哨兵从后面列表的尾部，往前先走
            //假设 1，2，3，4，5，6，7，8，9排序
            //如果从end开始减，最后游标的位置就到1
            //如果从start开始加，最后游标的位置就是到9
            //从end开始减，最后插入那一步的时候，就不用再处理插入的位置了

            //从尾部遍历，如果发现 当前数字 < 初始元素
            for(; start<end ; end--){
                if(input[oldStart] > input[end]){
                    break;
                }
            }

            for(; start< end ; start++){
                if(input[oldStart] < input[start]){
                    break;
                }
            }

            change(input,start,end);

            SortUtil.print("start = " + start);
            SortUtil.print("end = " + end);
            SortUtil.print(input);
        }


        insert(input,oldStart,start);

        SortUtil.print("this Round end ,and reslut:");
        SortUtil.print(input);
        SortUtil.print("end~~~~~~~~~~~~~~~~~~~~");

        //分成头尾两组，递归
        sort(input,oldStart,start -1);
        sort(input,start + 1,oldEnd);

        return input;
    }

    public int[] sort(int[] input) {
     return sort(input,0,input.length - 1);
    }

}
