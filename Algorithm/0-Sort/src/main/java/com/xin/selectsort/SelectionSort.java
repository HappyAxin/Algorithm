package com.xin.selectsort;

/**
 * @author Hu·YX
 * @Description 简单选择排序
 * @Date 2023/04/18
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int minIndex = i;
            int maxIndex = j;
            // 在当前未排序区间中找到最小元素和最大元素
            for (int k = i; k <= j; k++) {
                if (arr[k] < arr[minIndex]) {
                    minIndex = k;
                }
                if (arr[k] > arr[maxIndex]) {
                    maxIndex = k;
                }
            }
            // 将最小元素交换到已排序区间的末尾
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            // 如果最大元素在最小元素原来的位置，由于已经交换了最小元素，
            // 所以最大元素实际上被移动到了最小元素的位置，需要更新其索引
            if (maxIndex == i) {
                maxIndex = minIndex;
            }
            // 将最大元素交换到已排序区间的开头
            if (maxIndex != j) {
                int temp = arr[j];
                arr[j] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}
