package com.xin.swapsort;

/**
 * @author Hu·YX
 * @Description 快速排序
 * @Date 2023/04/18
 */
public class QuickSort {
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            // 选择基准元素
            int pivot = arr[left];
            while (i < j) {
                // 从右往左找到第一个小于基准元素的元素
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                // 从左往右找到第一个大于基准元素的元素
                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                }
            }
            // 将基准元素放到正确的位置上
            arr[i] = pivot;
            // 递归排序左半部分
            quickSort(arr, left, i - 1);
            // 递归排序右半部分
            quickSort(arr, i + 1, right);
        }
    }
}
