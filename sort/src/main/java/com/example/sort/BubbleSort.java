package com.example.sort;

import static com.example.sort.SortUtil.change;

/**
 * Created by 王心觉 on 2018/10/11.
 */

public class BubbleSort extends AbstructSort{


    public int[] sort(int [] input){
        //是否完成的标志位
        boolean needSwap ;

        //每排完一遍，大的已经到最后了
        //下次排列，最后一个数字可以不用参与排列了
        for(int i = 1; i<input.length -1;i++){

            needSwap = true;

            //两两比较，把大的往后挪
            for(int j= 0; j < input.length - i ;j++){
                if(input[j] > input[j + 1]){
                    change(input,j,j+1);
                    needSwap = false;
                }
            }

            //如果这趟，一个元素也没有换，那么这个序列，就已经是有序的了，不用再排了
            //这样保证，冒泡排序，最好的时间复杂度是O（n）
            if(needSwap == true){
                SortUtil.print(input);
                return input;
            }

        }

        SortUtil.print(input);
        return input;
    }
}
