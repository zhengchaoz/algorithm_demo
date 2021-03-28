package com.algorithm.demo.strategy.insertionSort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 折半插入排序
 * 稳定
 *
 * @author
 * @date 2021-03-04-10:22
 */
public class ArrayBinaryInsertionSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     * 折半插入排序是对直接插入排序的一种改进，以前需要将待排序元素依次比较有序元素然后插入适当的位置，
     * 现在是利用二分法将有序元素看作是一个区间，取出中间值和待排序元素比较，
     * 小于就放入右区间，然后取出右区间的中间值比较大小，然后分割左右区间，如此直到找到合适的位置，反之亦然
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //外层循环是待排序的无序序列，将首位元素看作是有序序列
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];//取出待排序元素
            int low = 0, high = i - 1;//low为低边界坐标，初始为0（从小到大），high为高边界坐标
            //判断高低边界坐标是否越位，越位意味着找到了合适的位置
            while (low <= high) {
                int middle = (low + high) / 2;//获得区间内的中间值
                if (array[middle] > temp) {
                    high = middle - 1;//如果中间值大于待排序元素，则高边界坐标下降到中间值坐标-1
                } else {
                    low = middle + 1;//如果中间值小于等于待排序元素，则低边界坐标上升到中间值坐标+1
                }
            }
            //将低边界坐标到待排序元素之前的元素向后移，给待排序元素腾位置
            for (int j = i - 1; j >= low; j--) {
                array[j + 1] = array[j];
            }
            //将待排序元素归位，为什么是低边界坐标？因为while判断到最后一定是low=high=middle，
            //如果待排序元素大于等于middle，则low+1，插入到middle后面
            //如果待排序元素小于middle，则low不变，high-1，插入到middle前面
            array[low] = temp;
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
