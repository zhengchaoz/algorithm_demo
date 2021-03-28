package com.algorithm.demo.strategy.insertionSort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 直接插入排序
 * 稳定
 * <p>
 * 将一个元素插入到一个有序的序列中，使之成为一个新的有序、元素+1的序列，
 * 可以将具有n个元素的序列，看作是由具有1个元素的有序序列和具有n-1个元素的无序序列组成，
 * 从有n-1个元素的无序序列中取出一个元素去和有1个元素的有序序列比较，插入合适的位置，然后重复这个步骤
 *
 * @author
 * @date 2021-03-04-9:25
 */
public class ArrayStraightInsertionSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     * 将数组前两个元素相比较，并排序
     * 将第三个元素和前两个元素相比较，并排序插入到合适的位置
     * 将第四个元素和前三个元素相比较，并排序插入到合适的位置
     * ··· ···
     * 如此直到将最后一个元素和之前所有元素相比较，并排序插入到合适的位置
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //外层循环可以看做是待排序的无序序列（n-1），i从1开始是因为第0个元素是有序序列
        for (int i = 1; i < array.length; i++) {//无序序列从左至右
            int temp = array[i];//记录要排序的元素
            int j = i - 1;//j可以看做是已排序的有序序列的最后一个元素
            //将从无序序列中取出一个的元素去和有序序列中的所有元素倒序比较
            for (; j >= 0 && temp < array[j]; j--) {//有序序列从右至左
                array[j + 1] = array[j];//如果temp小于当前元素，就将当前元素后移，否则不动
            }
            //将要排序的元素插入应当的位置，j+1是因为前面j--之后不合要求的话要+1补一位
            array[j + 1] = temp;
        }
    }

    /**
     * 无效方法
     *
     * @param o
     * @return null
     */
    @Override
    public Object find(Object o) {
        return null;
    }

}
