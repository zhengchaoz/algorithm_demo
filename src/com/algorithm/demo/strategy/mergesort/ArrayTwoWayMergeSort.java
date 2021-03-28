package com.algorithm.demo.strategy.mergesort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 两路归并排序(分治法)
 * 稳定
 *
 * 此排序就是将一个无序序列逐步拆分成多个无序序列，每次步长是要拆分序列长度的一半，一直拆分成长度为1
 * 然后将拆分后的序列分别排序成有序序列，再两两对比后合并，直到重新合并成一个完整的有序序列
 *
 * 形象的说就是将类二叉树从上往下拆然后再从下往上合并
 *
 * @author
 * @date 2021-03-05-11:05
 */
public class ArrayTwoWayMergeSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     *
     * 具体步骤是；
     *          1.分解  将无序序列按照length/2的步长一直分解成长度为1的多个无序序列
     *          2.排序  将这些无序序列分别排序成有序序列
     *          3.合并  将相邻的两个有序序列合并后重新排序，直到合并成完整的一个序列
     *
     * 注意：具体到代码逻辑中，并不是先将所有的最小长度的无序序列排序，然后再合并；
     *      而是再将第一个最小长度的无序序列排序后，先去将要合并的另一个序列排序，
     *      有时这个序列下仍会有可以分割的无序序列
     *
     *      以 {7, 3, 1, 13, 5, 9, 11, 8, 4} 为例：
     *      {7, 3, 1, 13, 5} {9, 11, 8, 4}
     *      {7, 3, 1} {13, 5} {9, 11, 8, 4}
     *      {7, 3} {1} {13, 5} {9, 11, 8, 4} 先分解出第一个无序序列
     *      {3, 7} {1} {13, 5} {9, 11, 8, 4} 将它排序后合并相邻的序列{1}并排序
     *      {1, 3, 7} {5, 13} {9, 11, 8, 4} 合并相邻的序列{5, 13}前要将{5, 13}排序
     *      {1, 3, 5, 7, 13} {9, 11, 8, 4} 合并相邻的序列{9, 11, 8, 4}前将它分解
     *      {1, 3, 5, 7, 13} {9, 11} {8, 4}
     *      {1, 3, 5, 7, 13} {9, 11} {8, 4}
     *      {1, 3, 5, 7, 13} {9, 11} {4, 8} 分解后依次排序
     *      {1, 3, 5, 7, 13} {4, 8, 9, 11} 先自己合并排序
     *      {1, 3, 4, 5, 7, 8, 9, 11, 13} 再合成一个完整的
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;

        twoWayMerge(array, 0, array.length - 1);
    }

    /**
     * 分解无序序列
     *
     * 顺序是先分割出第一个最小无序序列，然后再合并时向右分割出第二个，以此类推
     *
     * @param array
     * @param low 序列的开始下标位置
     * @param high 序列的结束下标位置
     */
    private void twoWayMerge(int[] array, int low, int high) {
        //最小长度序列{7, 3}即0<1
        if (low < high) {
            //步长 length/2 以此分割序列，因此mid也是左区间的最大下标，mid+1是右区间的最小下标
            int mid = (low + high) / 2;
            //分割出第一个最小长度序列
            twoWayMerge(array, low, mid);
            //合并前检查被合并的序列是否需要排序、是否需要向下分割
            twoWayMerge(array, mid + 1, high);
            //将当前分割的序列排序
            mergeSort(array, low, mid, high);
        }
    }

    /**
     * 将分割序列排序，或是合并序列排序
     *
     * @param array
     * @param low 最小坐标
     * @param mid 中间值，mid是左区间的最大下标，mid+1是右区间的最小下标
     * @param high 最大坐标
     */
    private void mergeSort(int[] array, int low, int mid, int high) {
        //临时数组，+1是因为high-low是数组下标
        int[] temp = new int[high - low + 1];
        int l = low;//左区间的最小下标
        int h = mid + 1;//右区间的最小下标
        int i = 0;//临时数组temp的下标
        //注意：l是左区间的初始值low，最大是mid；h是右区间的初始值mid+1，最大值是high\
        //因为左右区间都是有序序列，因此只有一种情况：一边比较完，一边还剩
        while (l <= mid && h <= high) {
            //把小的数放入temp，然后下标自增比较下一个
            if (array[l] <= array[h]) {
                temp[i++] = array[l++];
            } else {
                temp[i++] = array[h++];
            }
        }
        //下面两个while没有先后顺序区别，剩下的那肯定是大的，因为左右区间都是有序的
        //注意：l是左区间的初始值low，最大是mid
        while (l <= mid) {
            temp[i++] = array[l++];
        }

        while (h <= high) {
            temp[i++] = array[h++];
        }
        //将排序好的临时数组填入，low是是最下标，是不变的
        for (int j = 0; j < temp.length; j++) {
            array[low + j] = temp[j];
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
