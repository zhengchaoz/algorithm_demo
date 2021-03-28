package com.algorithm.demo.strategy.noncomparsionsort;

import com.algorithm.demo.strategy.AlgorithmStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * 稳定
 *
 * 从待排序列的个位数开始排序，然后是十位、百位、千位。。。最终完成整个排序，
 * 由于十进制每位的范围是0-9，因此可以用桶排序或计数排序来进行排序，基数排序的稳定性正是从此而来，
 * 既可以从大到小，也可以从小到大。
 *
 * @author
 * @date 2021-03-08-16:59
 */
public class RadixSort extends AlgorithmStrategy {

    /**
     * 重写父类排序方法
     *
     * @param o
     */
    @Override
    public void sort(Object o) {
        int[] array = (int[]) o;
        //位数从个位开始
        int digit = 1;
        int decimal = 10;//十进制
        for (int i = 0; i < array.length; i++) {//获得待排序列的最大位数
            while (array[i] >= decimal) {
                digit++;
                decimal *= 10;
            }
        }
        //最大位数有几位就进行几次排序
        for (int j = 0; j < digit; j++) {
            int pow = (int) Math.pow(10, j);//pow次幂，10的j次幂，就是1、10、100等位数
            //准备桶的个数，十进制就是0-9
            List<ArrayList<Integer>> list = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                list.add(new ArrayList<>());
            }
            //遍历待排序列的某位数的顺序
            for (int i = 0; i < array.length; i++) {
                int a = array[i] / pow % 10;//除位数后取余
                list.get(a).add(array[i]);//落入相应的桶中
            }
            //输出排序好的序列
            int index = 0;
            for (ArrayList<Integer> l : list) {
                for (Integer i : l) {
                    array[index++] = i;
                }
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
