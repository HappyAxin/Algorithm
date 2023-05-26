package com.xin.selectsort;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description 基数排序
 * @Date 2023/04/18
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr);
        int radix = 10;
        int[] count = new int[radix];
        int[] bucket = new int[arr.length];
        for (int digit = 1; digit < maxDigit; digit++) {
            Arrays.fill(count, 0);
            for (int i : arr) {
                int num = getDigit(i, digit);
                count[num]++;
            }
            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                int num = getDigit(arr[i], digit);
                bucket[count[num] - 1] = arr[i];
                count[num]--;
            }
            // 复制桶到原数组
            System.arraycopy(bucket, 0, arr, 0, arr.length);
        }
        // 处理负数
        if (arr[0] < 0) {
            int[] negArr = new int[arr.length];
            int negCount = 0;
            for (int i = arr.length - 1; i >= 0 && arr[i] < 0; i--) {
                negArr[negCount++] = -arr[i];
            }
            // 对正整数排序
            radixSort(negArr);
            for (int i = 0; i < negCount; i++) {
                arr[i] = -negArr[negCount - i - 1];
            }
        }
    }

    private static int getMaxDigit(int[] arr) {
        int maxDigit = 1;
        int base = 10;
        for (int i = 0; i < arr.length; i++) {
            int num = Math.abs(arr[i]);
            int digit = 1;
            while (num >= base) {
                num /= base;
                digit++;
            }
            maxDigit = Math.max(maxDigit, digit);
        }
        return maxDigit;
    }

    private static int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit - 1) % 10);
    }
}
