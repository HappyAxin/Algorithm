package com.xin.selectsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 桶排序
 * @Date 2023/04/18
 */
public class BucketSort {
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int minValue = arr[0], maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i : arr) {
            int index = (i - minValue) / bucketSize;
            buckets.get(index).add(i);
        }
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            if (bucket.isEmpty()) {
                continue;
            }
            if (bucket.size() < 100) {
                // 对每个桶内元素进行插入排序
                insertionSort(bucket);
            } else {
                // 对每个桶内元素进行并行排序
                parallelSort(bucket);
            }
            for (Integer integer : bucket) {
                arr[k++] = integer;
            }
        }
    }

    private static void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            int temp = list.get(j);
            while (j > 0 && temp < list.get(j - 1)) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, temp);
        }
    }

    private static void parallelSort(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.parallelSort(array);
        list.clear();
        list.addAll(Arrays.asList(array));
    }
}
