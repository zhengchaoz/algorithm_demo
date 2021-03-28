package com.algorithm.demo.strategy.selectionsort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 直接选择排序
 * 不稳定
 *
 * @author
 * @date 2021-03-03-10:14
 */
public class ArrayStraightSelectionSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     * 选择数组0下标，将其它元素与这个位置上的元素对比，如果小于就交换位置，持续这个操作直到最小元素
     * 然后后续数组下标持续上述操作
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;

        int temp, small;
        for (int i = 0; i < array.length; i++) {
            small = i;

            for (int j = i + 1; j < array.length; j++) {//查找最小元素
                if (array[j] < array[small]) {//记录最小元素位置
                    small = j;
                }
            }

            if (small != i)//交换元素
                swap(array, small, i);
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
