package com.xin.swapsort;

/**
 * @author Hu·YX
 * @Description 冒泡排序
 * @Date 2023/04/18
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int k = n - 1;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            int last = k;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                    k = j;
                }
            }
            if (! flag) {
                break;
            }
        }
    }
}
