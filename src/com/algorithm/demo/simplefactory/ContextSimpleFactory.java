package com.algorithm.demo.simplefactory;

import com.algorithm.demo.strategy.AlgorithmStrategy;
import com.algorithm.demo.strategy.exchangesort.ArrayBubbleSortStrategy;
import com.algorithm.demo.strategy.exchangesort.ArrayQuickSortStrategy;
import com.algorithm.demo.strategy.insertionSort.ArrayBinaryInsertionSort;
import com.algorithm.demo.strategy.insertionSort.ArrayShellSort;
import com.algorithm.demo.strategy.insertionSort.ArrayStraightInsertionSort;
import com.algorithm.demo.strategy.mergesort.ArrayTwoWayMergeSort;
import com.algorithm.demo.strategy.noncomparsionsort.CountingSort;
import com.algorithm.demo.strategy.noncomparsionsort.RadixSort;
import com.algorithm.demo.strategy.selectionsort.ArrayHeapSort;
import com.algorithm.demo.strategy.selectionsort.ArrayStraightSelectionSort;

/**
 * 用简单工厂模式自动产生对应的策略对象
 */
public class ContextSimpleFactory {

    private AlgorithmStrategy algorithmStrategy;

    public ContextSimpleFactory(AlgorithmStrategy algorithmStrategy, Object o) {
        algorithmStrategy.sort(o);
    }

    public ContextSimpleFactory(String type) {
        switch (type) {
            case "bubble":
                algorithmStrategy = new ArrayBubbleSortStrategy();
                break;
            case "quick":
                algorithmStrategy = new ArrayQuickSortStrategy();
                break;
            case "straightSelection":
                algorithmStrategy = new ArrayStraightSelectionSort();
                break;
            case "heapSort":
                algorithmStrategy = new ArrayHeapSort();
                break;
            case "straightInsertion":
                algorithmStrategy = new ArrayStraightInsertionSort();
                break;
            case "binaryInsertionSort":
                algorithmStrategy = new ArrayBinaryInsertionSort();
                break;
            case "shellSort":
                algorithmStrategy = new ArrayShellSort();
                break;
            case "twoWayMergeSort":
                algorithmStrategy = new ArrayTwoWayMergeSort();
                break;
            case "countingSort":
                algorithmStrategy = new CountingSort();
                break;
            case "radixSort":
                algorithmStrategy = new RadixSort();
                break;
        }
    }

    public void sort(Object o) {
        algorithmStrategy.sort(o);
    }

}
