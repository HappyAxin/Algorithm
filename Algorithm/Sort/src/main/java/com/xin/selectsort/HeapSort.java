package com.xin.selectsort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建大根堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出堆顶元素并放到已排序序列的末尾
        for (int i = n - 1; i > 0; i--) {
            // 将栈顶元素交换到已排序序列的末尾
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 维护堆的性质
            heapify(arr, i, 0);
        }
    }

    /**
     * 对以 root 为根的子树进行堆化
     *
     * @param arr  数组
     * @param n    堆的大小
     * @param root 以root为根的子树
     */
    private static void heapify(int[] arr, int n, int root) {
        // 初始化最大元素的位置为根节点
        int largest = root;
        // 左孩子的位置
        int left = 2 * root + 1;
        // 右孩子的位置
        int right = 2 * root + 2;

        // 找到最大元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大元素不在根节点，需要交换根节点和最大元素，并递归堆化最大元素所在的子树
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
