package com.algorithm.demo.strategy.noncomparsionsort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

/**
 * 桶排序（前提是要求待排序列中的元素是均匀分布的）
 * 稳定
 *
 * 桶排序需要预先假设待排序列中的元素是均匀分布的，然后划分出n个桶，遍历待排序列中的元素，
 * 依次将元素落入相应的桶中，最后取出桶中的元素就是排序好的序列。
 *
 * 所谓桶其实可以看作区间，例如1-100的数，可以划分出10个区间，每个区间范围依次是【1-10】、【11-20】。。。
 * 也就是说桶的范围本身是有序的，但桶的数量或范围都不是固定的，要根据不同的情况具体分析。
 * 当所有待排序列元素都分别放入桶中后，还要对各个桶中的元素进行排序，
 * 这一步可以借助其他比较排序算法或是以递归方式继续使用桶排序进行排序。
 * 最终桶是有序的，桶里的元素也是有序的，只要依次遍历桶，取出其中的元素就得到了有序序列。
 *
 * 在所有情况中最极端的两种是：
 *      1.只有一个桶或是待排序列分布十分不均匀，都会导致所有元素都落入一个桶中，这样桶内自排序的算法为插入算法
 *      2.桶的数量等于待排序列长度，相当于每个桶中只装一个元素，这样速度最快但所占用的空间资源最多（和上面相反）
 *
 * 总的来说桶的区间或桶的个数划分需要在上面两种极端情况中间，在速度和空间上做取舍，
 * 即让待排序列的元素尽可能平均的落入到每个桶中，并且只有待排序列中的元素是均匀分布的才合适使用桶排序。
 *
 * @author
 * @date 2021-03-08-11:03
 */
public class BucketSort extends AlgorithmStrategy {
    @Override
    public void sort(Object o) {

    }

    @Override
    public Object find(Object o) {
        return null;
    }
}
