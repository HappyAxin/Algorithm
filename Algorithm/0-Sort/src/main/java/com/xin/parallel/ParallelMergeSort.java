package com.xin.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Hu·YX
 * @Description 并行归并排序
 * @Date 2023/04/19
 */
public class ParallelMergeSort {

    public static void parallelMergeSort(int[] arr) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(arr, 0, arr.length - 1));
        pool.shutdown();
    }

    private static class MergeSortTask extends RecursiveAction {
        private final int[] arr;
        private final int start;
        private final int end;

        public MergeSortTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start >= end) {
                return;
            }

            int mid = start + (end - start) / 2;
            MergeSortTask leftTask = new MergeSortTask(arr, start, mid);
            MergeSortTask rightTask = new MergeSortTask(arr, mid + 1, end);
            invokeAll(leftTask, rightTask);
            merge(start, mid, end);
        }

        private void merge(int start, int mid, int end) {
            int[] temp = new int[end - start + 1];
            int i = start;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= end) {
                if (arr[i] < arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            while (i <= end) {
                temp[k++] = arr[j++];
            }

            System.arraycopy(temp, 0, arr, start, temp.length);
        }
    }
}
