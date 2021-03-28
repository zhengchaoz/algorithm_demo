package com.algorithm.demo.strategy.insertionSort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * Shell排序（希尔排序）
 * 不稳定
 * <p>
 * Shell排序就是按照增量k将数据分割成k个组，然后每个组依次的、独立的进行直接选择排序
 * 然后增量k/2，重复排序，最后直到k=1
 * <p>
 * 增量一般定义为length/2 或者 length/3+1 ,增量最小为1
 * 每间隔相同增量下标的元素即为一组，例如长度为10的数组，增量为5，
 * 那么下标[0,5]或[1,6]或[2,7]或[3,8]或[4,9]为同一组，同理增量为2，那么下标[0,2,4,6,8]或[1,3,5,7,9]为同一组
 * 各组内的元素是间隔的而不是相连的，同样排序时也是依次交替进行的。
 *
 * @author
 * @date 2021-03-04-14:03
 */
public class ArrayShellSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     *
     * @param o 数值型数组 int[] a = {3, 1, 2};
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //inc是增量，就是按照inc来分组，每隔inc个元素都是一组的
        //最小分组是1，所以inc最小为1
        //inc增量每次除2
        for (int inc = array.length / 2; inc > 0; inc /= 2) {
            //从增量inc处下标开始进行排序，各个分组依次进行比较，一组一组的进行
            for (int i = inc; i < array.length; i++) {
                int temp = array[i];//待排序元素的值
                int j = i - inc;//待排序元素所在组的上一个元素的下标
                //循环向前（向左）判断同组元素，同组元素间隔inc，因此j-=inc
                for (; j >= 0; j -= inc) {
                    if (array[j] > temp) {//待排序元素和所在组的上一个元素相比较
                        //本循环第一次进入时，i==j+inc，但一组会有多个元素，j会不断的-=inc
                        array[j + inc] = array[j];//j是j+inc的同组上一个元素，将大的元素后移
                    } else {
                        //为什么break而不是继续向前比较？
                        //虽然每个分组依次进行的，即这组元素比较完后进行下一组，
                        //但将每组元素抽离独立来看，实际是同组相邻元素先两两比较，有点类似冒泡排序但顺序相反
                        //因此前面的是必定先比较的，可以看作是有序的
                        break;
                    }
                }
                //此处的j+inc和上面循环的最后一次j-=inc相抵消，实际坐标是j，也是在temp前面的同组元素
                array[j + inc] = temp;
            }
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
