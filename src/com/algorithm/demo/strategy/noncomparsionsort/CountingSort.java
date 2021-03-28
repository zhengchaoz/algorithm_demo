package com.algorithm.demo.strategy.noncomparsionsort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 计数排序（最好提前直到待排序列的取值范围）
 * 稳定
 *
 * @author
 * @date 2021-03-08-14:44
 */
public class CountingSort extends AlgorithmStrategy {

    /**
     * 重写排序方法
     *
     * 计数排序需要一个辅助序列count，count的下标表示待排序列的元素值，即count[5]对应待排序列中值为5的元素，
     * count的下标的值表示待排序列的元素出现的个数，即count[5]=2对应待排序列中值为5的元素出现两次，
     * 统计好后只需输出辅助序列即可。
     *
     * @param o
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //当不知道待排元素的范围时，用最大值-最小值来确定范围
        int max = Integer.MIN_VALUE;//要求最大值先赋最小的
        int min = Integer.MAX_VALUE;//要求最小值先赋最大的
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //万一包含负数，记录偏移量
        int offset = 0 - min;
        //如果min是负数，辅助序列长度向左向高边界偏移
        //如果min是正数，辅助序列长度向右向低边界偏移
        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            //因为数组下标从0开始，所以此处加上偏移量将负数转为正数
            //如果min是负数，那么加上offset（正的mid）就是0
            //如果min是正数，那么加上offset（负的mid）还是0
            count[array[i] + offset]++;
        }

        int index = 0;
        for (int j = 0; j < count.length; j++) {
            while(count[j] > 0){
                array[index++] = j - offset;//输出时再减去偏移量
                count[j]--;
            }
        }
    }

    /**
     * 无效方法
     *
     * @param o
     * @return
     */
    @Override
    public Object find(Object o) {
        return null;
    }

}
