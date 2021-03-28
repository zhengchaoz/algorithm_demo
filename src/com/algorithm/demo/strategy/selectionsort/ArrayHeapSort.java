package com.algorithm.demo.strategy.selectionsort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 堆排序（不稳定）
 * 该排序是利用堆的结构所设计的一种算法，堆的定义：
 * 1.是一种近似完全二叉树的结构 2.满足堆积性质，即子节点的数值和索引总是小于父节点
 * 将数组按照堆的结构定义构建成大顶堆（堆顶的值是堆中最大的，并且父节点的值大于子节点）或小顶堆（相反）
 * 将堆顶和堆尾元素交换并断开堆顶，然后重新构建堆
 * 最后重复以上两个步骤
 *                      大顶堆值[索引]
 *                             50[0]
 *                      45[1]             40[2]
 *                20[3]     25[4]    35[5]   30[6]
 *           10[7]   15[8]
 *  arr [50, 45, 40, 20, 25, 35, 30, 10, 15]
 *
 * @author
 * @date 2021-03-03-16:10
 */
public class ArrayHeapSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //array.length / 2 - 1 得到非叶子节点的个数
        //推到过程：1.首先有n个节点的二叉树会有n-1个度，因为从下往上看，除了根节点，每个节点都有一个入度（即父节点）
        //        2.设n个节点中有x个非叶子节点和y个叶子节点，那么x+y=n，而从上往下看，
        //        所有非叶子节点节点都有1到2个出度（即子节点），叶子节点没有，则有：
        //        2x=n-1 -> 2x=x+y-1 -> x=y-1 （都是两个子节点的情况）
        //        2x-1=n-1 -> 2x-1=x+y-1 -> x=y （有一个子节点的情况）
        //因此非叶子节点会比叶子节点少一个或是相等，而int在进行除法是会自动去除小数，所以相当于(n-1)/2，
        //而因为是数组下标所以要-1
        //从最后一个非叶子节点往前推进
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);//调整以i为局部顶点的数组为大顶堆
        }
        //将堆顶元素和末尾元素对调，将最大元素“沉”到最后
        //重新调整堆的结构，使其满足堆的定义，然后将堆顶元素和末尾元素对调，反复执行
        for (int j = array.length - 1; j > 0; j--) {
            //将推到堆顶的最大值调换到最后，并再次调整堆
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            //0作为初始调整的索引，方便使用 j是每次循环都要排除以排序好的数
            adjustHeap(array, 0, j);
        }
    }

    /**
     * 调整数组为大顶堆
     *
     * @param array  数组
     * @param index  非叶子节点的下标(局部顶点)
     * @param length 数组长度
     */
    private void adjustHeap(int[] array, int index, int length) {
        //将非叶子节点(局部顶点)的值取出
        int temp = array[index];
        //获得该非叶子节点(index)的左子节点(k)，并循环获取左子节点(k)的左子节点，直到遍历数组
        //index * 2 + 1 == index的左子节点，index * 2 + 2 == index的右子节点
        for (int k = index * 2 + 1; k < array.length; k = index * 2 + 1) {
            //获得右子节点(k + 1)，判断右子节点出否超出数组长度并且左子节点的值小于右子节点的值，就指向右子节点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;//因为是大顶堆，所以将较大的值向上推
            }
            //如果子节点的值大于父节点，就覆盖父节点的值，否则退出循环
            if (array[k] > temp) {
                array[index] = array[k];
                index = k;//更新非叶子节点（可能不是）的下标
            } else {
                break;//即便子节点是非叶子节点，因为大顶堆的定义，父节点的值一定大于子节点，所以没必要遍历
            }
        }
        //循环结束，已经将以index为顶点的堆调整为大顶堆，将最大值推到了堆顶
        //将非叶子节点(局部顶点)的值赋给最终的位置，index已经被k多次赋值
        array[index] = temp;
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
