package com.algorithm.demo.strategy;

/**
 * 算法策略抽象类
 */
public abstract class AlgorithmStrategy {

    /**
     * 定义排序算法抽象方法
     *
     * @param o
     */
    public abstract void sort(Object o);

    /**
     * 定义查找算法抽象方法
     *
     * @param o
     * @return
     */
    public abstract Object find(Object o);

    /**
     * 交换数组的指定元素位置
     *
     * @param array
     * @param a
     * @param b
     */
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
