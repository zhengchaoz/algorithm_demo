package com.algorithm.demo.strategy.exchangesort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 快速排序算法(顺序很重要，一定是从后往前，从右往左)
 * 不稳定
 *
 * 快速排序算法的实现有挖坑法和左右指针法：
 *          1.挖坑法是先找到比基数大的元素a就将它放入基数的位置，再去找到比基数小的元素b就将它放入a的位置，
 *            如此交替最后放入基数。
 *          2.左右指针法是先找比基数大的元素a，再去找比基数小的元素b，然后将a和b交换位置，
 *            如此交替最后放入基数。
 *
 * 快速排序的优化：
 *          1.随机基数：每次从待排序列中随机选择元素作为基数，而不是固定选择首个或末尾的元素作为基数，
 *            选择完后和首个或尾部的元素交换位置，就可以使用之前的算法。
 *          2.三数取中法：选择第一个、最后一个、n/2即中间数，从这三个元素选出中间值作为基数。
 *          3.当待排序列的长度被分割到一定长度时，直接使用插入排序，由于快速排序会一直递归到元素数为1时才停止，
 *            有可能会出现栈溢出的情况，可以预设一个阈值n，当递归到元素数为n时用插入排序。
 *          4.三路划分：主要应用于待排序列中重复元素过多的情况，首先我们要划分出三个区域，小于基数的、
 *            等于基数的、大于基数的，这样在递归排序数就不用对重复数据作对比。
 *
 */
public class ArrayQuickSortStrategy extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] a = (int[]) o;

        quickSort(a, 0, a.length - 1);
    }

    /**
     * 快速排序：
     * 1.选择一个基数，然后按照从右往左、从后往前的顺序，将大于基数的数放在右边，小于基数的数放在左边
     * 2.然后得到以基数为界的左右两个区间，在这两个区间中分别重复前面的步骤
     *
     * @param a     数值型数组 int[] a = {3, 1, 2};
     * @param left  左边起始坐标
     * @param right 右边结束坐标
     */
    private void quickSort(int[] a, int left, int right) {
        // 判断左右区间是否越位
        if (left >= right) {
            return;
        }
        //取第一位作为基数
        int base = a[left];
        int l = left, r = right;
        //如果相等则意味着此轮排序结束
        while (l != r) {
            //一定要从右边开始，这样最后的落脚点才会在右区间，凡是比基数小的数都丢到左边
            while (a[r] >= base && l < r) {
                r--;
            }
            //凡是比基数大的都扔给右边
            while (a[l] <= base && l < r) {
                l++;
            }
            //判断左右区间没有越界，然后交换左右两边的数
            if (l < r)
                swap(a, r, l);
        }
        //将基数插入中间
        a[left] = a[l];
        a[l] = base;
        //递归调用左右区间
        quickSort(a, left, l - 1);
        quickSort(a, l + 1, right);
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
