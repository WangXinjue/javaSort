package com.example.sort;

import java.util.ArrayList;

/**
 * Created by 王心觉 on 2018/9/30.
 */

public class RadixSort extends AbstructSort{

    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    /**
     * 这个方法是计算一个int型的数字，是几位数
     * 比9小就是1位数，9~99之间是2位数，99~999是3位数，以此类推
     */
    int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    /**
     * 桶排序，设最多为x位数，时间复杂度为线性，
     * @param input
     * @return
     */
    public int[] sort(int [] input){

        int[] mOutput = input;

        //一个数组，包含十个ArrayList，代表十个桶
        //如：24，如果是排序个位数，在放在4号ArrayList
        //如：24，如果是排序十位数，在放在2号ArrayList
        //如：24，如果是排序百位数，在放在0号ArrayList
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i< buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        //计算最大的数字的位数
        //如果数组内，最大的数字是1586，则：maxLength = 4
        int maxFigures = 1;
        for(int i = 0; i<mOutput.length; i++ ){
            int currentLength = sizeOfInt(mOutput[i]);
            if(maxFigures < currentLength){
                maxFigures = currentLength;
            }
        }


        //从个位开始遍历，到最高位数
        for(int currentFigures = 1; currentFigures<=maxFigures; currentFigures++){
            //对应数字入对应的ArrayList（桶）
            int figures = (int) Math.pow(10,currentFigures -1);
            System.out.println("figures = "+figures);
            for(int i = 0; i<mOutput.length; i++ ){
                int temp = mOutput[i] / figures;
                int num = temp % (10);
                buckets[num].add(mOutput[i]);
                System.out.println("number = "+mOutput[i] +" into "+ num +" Bucket");
            }

            // 根据桶的顺序，写入mOutput
            // 0号桶先写入，然后依次写入1号桶子，2号桶子。。。。。。让mOutput局部有序
            // 这样每次排列高位的时候，低位都是排序好的
            // 排到最高位的时候，低位已经全部排好了
            int count = 0;
            for(int i = 0; i<10; i++ ){
                for(Integer num : buckets[i]){
                    mOutput[count] = num;
                    count ++;
                }
                buckets[i].clear();
            }
        }

        SortUtil.print(mOutput);

        return mOutput;
    }
}
