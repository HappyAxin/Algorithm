package com.xin.selectsort;

/**
 * @author Hu·YX
 * @Description 归并排序
 * @Date 2023/04/18
 */
public class MergeSort {
    /**
     * 阈值
     */
    private static final int THRESHOLD = 10;

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, 0, n - 1, temp);
    }

    private static void mergeSort(int[] arr, int l, int r, int[] temp) {
        // 当子序列长度小于等于阈值时，采用插入排序
        if (r - l <= THRESHOLD) {
            insertionSort(arr, l, r);
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        // 左子序列的最大值小于右子序列的最小值，才进行合并操作
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1, k = 0;
        if (arr[i] <= arr[j]) {
            while (i <= mid && j <= r) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
        } else {
            while (i <= mid && j <= r) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        k = 0;
        while (l <= r) {
            arr[l++] = temp[k++];
        }
    }

    private static void insertionSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 1 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
