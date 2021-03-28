package com.algorithm.demo.strategy.exchangesort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 冒泡排序算法
 * 稳定
 */
public class ArrayBubbleSortStrategy extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     * 重复比较两个相邻元素，顺序相反就交换，大的放后面，小的放前面
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] a = (int[]) o;
        //标识每轮比较是否发生了交换
        boolean isSwap = false;
        for (int i = 0; i < a.length; i++) {
            //将a.length-1改成a.length-1-i是因为每轮比较都会将本轮的最大值放到会后，因此就不用再下一轮比较了
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    isSwap = true;//发生了交换就改变值
                }
            }
            //没有发生交换就说明已经排序完毕，直接跳出
            if (!isSwap)
                break;
        }

//        cocktailSort(o);
    }

    /**
     * 鸡尾酒排序、定向冒泡排序、搅拌排序 是对冒泡排序的一种改进
     * 在将最大值向后交换的同时，也将最小值向前交换，增大两边的有序区间，缩小中间的无序区间
     * <p>
     * 和冒泡排序的区别：
     * 1.冒泡排序每次比较一轮，即从右往左将本轮最大值沉到后面
     * 2.鸡尾酒排序每次比较两轮，即从右往左将本轮最大值沉到后面，从左往右将本轮最小值冒到前面
     *
     * @param o
     */
    private void cocktailSort(Object o) {
        int[] array = (int[]) o;
        //左右区间，表示需要排序的元素范围，最开始right-left=length，每次（两轮）排序后左右缩减边界
        int left = 0, right = array.length;
        while (left < right) {
            //从右往左遍历本轮最大值，沉到后面
            for (int i = left; i < right; i++)
                if (array[i] < array[i + 1])
                    swap(array, i, i + 1);
            right--;//每轮比较完最大值后，左区间-1
            //从左往右遍历本轮最小值，冒到前面
            for (int i = right; i > left; i--)
                if (array[i] < array[i - 1])
                    swap(array, i, i - 1);
            left++;//每轮比较完最小值后，右区间+1
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
