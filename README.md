# Algorithm

LeetCode算法代码及笔记，刷题顺序是跟着[代码随想录](https://www.programmercarl.com/)来的。

[TOC]



# 00 - 排序

| 算法     | 时间复杂度:最好 | 时间复杂度:平均 | 时间复杂度:最坏 | 空间复杂度:最坏 | 稳定性 |
| -------- | --------------- | --------------- | --------------- | --------------- | ------ |
| 冒泡排序 | O($n$)          | O($n^2$)        | O($n^2$)        | O($1$)          | 稳定   |
| 选择排序 | O($n^2$)        | O($n^2$)        | O($n^2$)        | O($1$)          | 不稳定 |
| 插入排序 | O($n$)          | O($n^2$)        | O($n^2$)        | O($1$)          | 稳定   |
| 希尔排序 | O($n$)          | O($n^{3/2}$)    | O($n^2$)        | O($1$)          | 不稳定 |
| 快速排序 | O($nlogn$)      | O($nlogn$)      | O($n^2$)        | O($logn$)       | 不稳定 |
| 归并排序 | O($nlogn$)      | O($nlogn$)      | O($nlogn$)      | O($n$)          | 稳定   |
| 计数排序 | O($n+k$)        | O($n+k$)        | O($n+k$)        | O($k$)          | 稳定   |
| 基数排序 | O($nk$)         | O($nk$)         | O($nk$)         | O($n+k$)        | 稳定   |
| 堆排序   | O($nlogn$)      | O($nlogn$)      | O($nlogn$)      | O($1$)          | 不稳定 |

## 交换排序

### 冒泡排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/swapsort/BubbleSort.java)

#### 思路

冒泡排序（Bubble Sort）是一种简单的排序算法，它的基本思想是通过不断交换相邻的元素将未排序的最大（或最小）元素逐渐“浮”到数组的末尾（或开头）。具体来说，冒泡排序的算法步骤如下：

1. 从数组的第一个元素开始，依次比较相邻的两个元素，如果前一个元素比后一个元素大，则交换它们的位置。
2. 继续向后比较相邻的两个元素，直到比较到倒数第二个元素为止。此时，数组的最后一个元素应该是未排序中的最大（或最小）元素。
3. 重复步骤1和步骤2，每次将未排序中的最大（或最小）元素“浮”到数组的末尾（或开头），直到所有元素都已排序。

使用了两层循环，外层循环控制排序的趟数，内层循环控制每一趟排序的比较次数。如果相邻的两个元素大小关系不符合要求，就进行交换。最终，通过多趟排序，可以将数组按照从小到大（或从大到小）的顺序排列。

对于某些输入数据，冒泡排序只需要经过一部分排序就可以完成，可以记录最后一次交换的位置，来减少比较的次数。

需要注意的是，冒泡排序的时间复杂度为 O($n^2$)，因此在处理大规模数据时，它的性能可能会受到影响。

### 快速排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/swapsort/QuickSort.java)

#### 思路

快速排序（Quick Sort）是一种基于分治思想的排序算法，其基本思想是选择一个基准元素，然后将数组分为两部分，一部分比基准元素小，一部分比基准元素大，然后递归地对两部分进行排序，最终得到有序数组。

Java 中实现快速排序可以通过递归实现，具体步骤如下：

1. 选择一个基准元素，一般是选取数组的第一个元素或最后一个元素。
2. 将数组分为两部分，一部分比基准元素小，一部分比基准元素大。
3. 对两部分分别进行递归排序。
4. 合并两部分得到有序数组。

在这个实现中，首先选择数组的第一个元素作为基准元素，然后使用双指针法（即快慢指针法）将数组分为两部分，一部分比基准元素小，一部分比基准元素大。具体来说，从右往左找到第一个小于基准元素的元素，然后从左往右找到第一个大于基准元素的元素，将它们交换位置，然后继续寻找下一对需要交换的元素，直到两个指针相遇。最后，将基准元素放到正确的位置上，并递归对左右两部分进行排序，直到数组完全有序。

## 插入排序

### 直接插入排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/insertsort/InsertionSort.java)

#### 思路

直接插入排序（Insertion Sort）是一种简单直观的排序算法，其基本思想是将待排序的数组分为已排序区间和未排序区间，每次取出未排序区间中的第一个元素插入到已排序区间中的合适位置，直到未排序区间为空为止。

具体实现过程如下：

1. 从第二个元素开始遍历数组，将其作为当前待插入元素。
2. 将当前元素与已排序区间中的元素进行比较，找到合适的插入位置。
3. 将已排序区间中大于当前元素的元素后移一位，直到找到合适的插入位置。
4. 将当前元素插入到找到的位置。
5. 重复以上步骤，直到未排序区间为空。

将待插入的元素作为 key，从已排序区间的末尾开始向前遍历，找到第一个小于等于 key 的元素的位置，然后将大于 key 的元素向后移动一位，并将 key 插入到空出来的位置。

直接插入排序的时间复杂度为 O($n^2$)，空间复杂度为 O($1$)，在数据规模较小的情况下表现较好，但对于大规模数据可能不太适用。

### 希尔排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/insertsort/ShellSort.java)

#### 思路

希尔排序（Shell Sort）是插入排序的一种改进，其基本思想是将待排序的数组按照一定的步长进行分组，对每组进行直接插入排序，然后逐步缩小步长，重复以上步骤，直到步长为 1，最后对整个数组进行一次直接插入排序。

具体实现过程如下：

1. 将待排序数组按照步长 gap 进行分组，对每组进行直接插入排序。
2. 缩小步长 gap，重复步骤 1，直到 gap 为 1。
3. 对整个数组进行一次直接插入排序。

首先将数组按照 gap 步长进行分组，对每组进行直接插入排序。然后不断缩小步长 gap，重复以上步骤，直到 gap 为 1，最后对整个数组进行一次直接插入排序。

希尔排序的时间复杂度和空间复杂度都与步长序列的选取有关，一般情况下时间复杂度为 O($n log n$)，空间复杂度为 O($1$)，在数据规模较大的情况下表现较好。

## 选择排序

### 简单选择排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/selectsort/SelectionSort.java)

#### 思路

简单选择排序（Selection Sort）是一种简单直观的排序算法，其基本思想是将待排序的数组分为已排序区间和未排序区间，每次从未排序区间中选择最小的元素放到已排序区间的末尾，直到未排序区间为空为止。

具体实现过程如下：

1. 将数组分为已排序区间和未排序区间，初始时已排序区间为空。
2. 在未排序区间中找到最小的元素，将其和未排序区间的第一个元素交换位置。
3. 将交换后的第一个元素划分到已排序区间中。
4. 重复以上步骤，直到未排序区间为空。

首先将数组分为已排序区间和未排序区间，初始时已排序区间为空。然后在未排序区间中找到最小的元素，将其和未排序区间的第一个元素交换位置，将交换后的第一个元素划分到已排序区间中。重复以上步骤，直到未排序区间为空。

简单选择排序的时间复杂度为 O($n^2$)，空间复杂度为 O($1$)，在数据规模较小的情况下表现较好，但对于大规模数据可能不太适用。

可以进行一些简单的优化，例如：

1. 增加跳过已经有序的子序列的操作。因为在已经有序的子序列中，找到最小元素的时间复杂度为 O(1)，所以可以在每次查找最小元素时跳过已经有序的子序列。
2. 使用双指针，同时查找最小和最大元素，将查找最小和最大元素的时间复杂度从 O(n) 优化为 O($n/2$)。

优化后的简单选择排序将查找最小和最大元素的时间复杂度从 O(n) 优化为 O($n/2$)，性能有一定提升，但是时间复杂度仍然为 O($n^2$)。如果要排序大规模数据，建议使用时间复杂度更低的排序算法。

### 堆排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/selectsort/HeapSort.java)

#### 思路

堆排序是一种基于比较的排序算法，它的时间复杂度为 O($nlogn$)，相比于冒泡排序、插入排序、选择排序等 O($n^2$) 级别的排序算法，堆排序性能更优。

堆排序基于堆这种数据结构，堆是一棵完全二叉树，具有以下两个特点：

1. 父节点的值总是大于（或小于）它的子节点的值。
2. 堆中的每个子树都是一个堆。

堆可以分为两种：大根堆和小根堆。在大根堆中，父节点的值总是大于它的子节点的值；在小根堆中，父节点的值总是小于它的子节点的值。

堆排序的基本思想是：将待排序序列构造成一个大根堆，此时整个序列的最大值就是堆顶的根节点。将它移走（其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值），然后将剩余的 n-1 个元素重新构造成一个堆，这样就得到了 n 个元素的次小值。依此类推，重复执行上述操作，直到整个序列有序。

如果要进一步优化，可以考虑以下几点：

1. 优化空间复杂度

	上面给出的堆排序实现需要额外的 O(n) 空间来存储堆。实际上可以在原地排序的前提下，把堆化和排序操作合并到同一个函数中。这样可以将空间复杂度降到 O($1$)，但是代码实现相对较为复杂。

2. 优化堆化操作

	上面给出的堆化操作是基于递归实现的，递归的深度等于树的高度，最坏情况下为 O($log n$)。如果使用迭代实现堆化操作，可以将堆化操作的时间复杂度降到 O($log n$)。

3. 优化建堆操作

	上面给出的建堆操作的时间复杂度为 O($n$)，实际上可以使用 Floyd 建堆算法将其优化到 O($log n$)。Floyd 建堆算法的基本思想是从最后一个非叶子节点开始，自下而上进行堆化操作。这样可以避免对已经是叶子节点的节点进行堆化，从而减少堆化操作的次数，提高效率。

综上所述，堆排序已经是一个非常高效的算法，进一步的优化空间有限，需要根据具体情况进行考虑和权衡。

### 归并排序

[代码链接（优化）](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/selectsort/MergeSort.java)

#### 思路

归并排序是一种基于分治思想的排序算法，它的基本思想是将原序列划分成多个子序列，对每个子序列进行排序，然后将这些子序列合并成一个有序序列。归并排序的时间复杂度是 O($nlogn$)，它是稳定的排序算法，适用于各种规模的数据。

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, 0, n - 1, temp);
    }

    private static void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid, temp);
            mergeSort(arr, mid + 1, r, temp);
            merge(arr, l, mid, r, temp);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
}
```

这里的 `mergeSort()` 方法是归并排序的入口方法，它接受一个整数数组作为参数，并调用私有方法 `mergeSort()` 完成实际的排序操作。私有方法 `mergeSort()` 的参数包括要排序的数组、左右指针以及一个辅助数组。在 `mergeSort()` 方法中，首先将原序列划分成左右两个子序列，然后分别对这两个子序列进行排序，最后将这两个有序子序列合并成一个有序序列。

私有方法 merge() 实现了两个有序子序列的合并，使用三个指针 i、j、k 分别指向左子序列、右子序列和辅助数组的起始位置，比较两个子序列的元素大小，并将较小的元素放入辅助数组中，直到一个子序列全部放入辅助数组中。最后将辅助数组中的元素复制回原数组中，完成排序。

归并排序的时间复杂度是 O($nlogn$)，空间复杂度是 O(n)，它是一种稳定的排序算法，适用于各种规模的数据。

可以进行进一步的优化。

1. 当子序列的长度小于等于某个阈值时，采用插入排序算法可以提高排序效率。
2. 在 `merge()` 方法中，可以优化比较大小的过程，避免频繁地使用不必要的条件语句。比如，可以先判断两个子序列中的第一个元素哪个更小，然后从较小的子序列开始比较，可以避免一些不必要的比较操作。
3. 在合并有序子序列时，如果左子序列的最大元素小于右子序列的最小元素，就不需要再进行合并操作了，可以直接将两个子序列连接起来。

### 基数排序

[代码链接（优化）](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/selectsort/RadixSort.java)

#### 思路

基数排序是一种非比较排序算法，它将整数按照位数切割成不同的数字，然后按每个位数分别进行排序。它可以看作是桶排序的扩展，需要一个队列或桶数组来辅助实现排序。

```java
public class RadixSort {
    public static void radixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr); // 获取最大位数
        int radix = 10; // 基数为 10
        int[] count = new int[radix]; // 计数数组
        int[] bucket = new int[arr.length]; // 桶数组
        for (int digit = 1; digit <= maxDigit; digit++) {
            // 初始化计数数组
            Arrays.fill(count, 0);
            // 统计当前位上每个数字出现的次数
            for (int i = 0; i < arr.length; i++) {
                int num = getDigit(arr[i], digit);
                count[num]++;
            }
            // 将计数数组转换为累加数组
            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            // 按当前位上的数字，将元素放入桶中
            for (int i = arr.length - 1; i >= 0; i--) {
                int num = getDigit(arr[i], digit);
                bucket[count[num] - 1] = arr[i];
                count[num]--;
            }
            // 将桶中的元素复制回原数组中
            for (int i = 0; i < arr.length; i++) {
                arr[i] = bucket[i];
            }
        }
    }

    private static int getMaxDigit(int[] arr) {
        int maxDigit = 1;
        int base = 10;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
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
        return (num / (int) Math.pow(10, digit - 1)) % 10;
    }
}
```

基数排序的核心思想，通过不断地按照数字的每一位进行排序，最终将数组变为有序状态。其中，getMaxDigit() 方法用于获取最大位数，getDigit() 方法用于获取数字的某一位，radixSort() 方法用于实现基数排序的具体流程。

可以进行优化的地方。

1. 针对负数的处理：以上实现只考虑了正整数，如果数组中存在负数，则需要先将所有数字取相反数再排序，最后再将排序结果取相反数。
2. 桶的大小：以上实现中，桶的大小为原数组的长度，这可能会造成空间浪费。可以根据数字的范围，合理地选择桶的大小。
3. 循环复用计数数组：以上实现中，在每次排序时都会新建一个计数数组，这会带来一定的空间和时间开销。可以在外部先创建一个计数数组，并在每次排序结束后清空其内容，然后重复利用该计数数组。
4. 多线程优化：基数排序是稳定排序，每一位上的排序是独立的，可以考虑使用多线程进行优化。比如，将数组分为多个子数组，然后在每个子数组上开启一个线程进行排序，最后合并各个有序子数组。

### 桶排序

[代码链接（优化）](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/selectsort/BucketSort.java)

#### 思路

桶排序是一种线性排序算法，它利用了额外的空间，将待排序的元素分到不同的桶中，对每个桶内的元素进行排序，最后将桶中元素按照顺序依次输出，即可得到有序序列。桶排序的时间复杂度为 O(n)，但其空间复杂度较高，取决于桶的数量和大小。

```java
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
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - minValue) / bucketSize;
            buckets.get(index).add(arr[i]);
        }
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = buckets.get(i);
            if (bucket.isEmpty()) {
                continue;
            }
            int[] bucketArray = new int[bucket.size()];
            for (int j = 0; j < bucket.size(); j++) {
                bucketArray[j] = bucket.get(j);
            }
            insertionSort(bucketArray); // 对每个桶内元素进行插入排序
            for (int j = 0; j < bucketArray.length; j++) {
                arr[k++] = bucketArray[j];
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}

```

上述代码中，先通过扫描数组得到数组中的最小值和最大值，根据最大值和最小值以及桶的大小，计算出需要的桶数。接着创建桶，并将每个元素分配到对应的桶中。对于每个桶内的元素，可以采用插入排序等简单的排序算法进行排序。最后，将桶中排好序的元素依次输出，即可得到有序序列。

根据具体场景进行一些优化。

1. 桶的大小

	桶的大小可以根据实际情况进行调整，一般来说，桶的大小越大，排序的效率会越高，但同时会增加额外的空间开销。因此，需要根据排序元素的范围大小和数量来选择合适的桶大小。

2. 插入排序算法

	对于每个桶内的元素，可以采用不同的排序算法进行排序。如果桶内元素较少，可以选择插入排序等简单的排序算法。如果桶内元素较多，可以选择更高效的排序算法，如快速排序、归并排序等。

3. 多线程并发排序

	由于桶排序的过程可以被拆分成多个独立的子任务，可以考虑使用多线程并发实现桶排序，以提高排序的效率。

## 并行排序

### 实现并行归并排序

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/0-Sort/src/main/java/com/xin/parallel/ParallelMergeSort.java)

#### 思路

使用了**Fork/Join框架**来实现并行归并排序。首先，创建了一个`MergeSortTask`类来表示一个排序任务。每个任务都表示对数组的一部分进行排序。在任务的`compute()`方法中，首先判断数组是否需要分割成更小的部分。如果是，则创建两个新的任务，并使用`invokeAll()`方法并行执行这两个任务。最后，使用`merge()`方法将两个子数组合并成一个有序数组。

在`main()`方法中，创建了一个新的`ForkJoinPool`对象，并使用`invoke()`方法调用根任务，即对整个数组进行排序。最后，打印出排序后的数组。

需要注意的是，并行归并排序的性能也受多种因素影响，如数组大小、硬件配置等。在实际应用中，需要进行测试和比较，选择最合适的排序方法。

#### Fork/Join框架是什么？

**Fork/Join框架**是Java SE 7中新增的一种并行编程框架，它是一种支持递归任务分割和*工作窃取（Work Stealing）*的线程池实现，可以用于解决一些需要递归划分子任务并合并结果的问题。其核心思想是将大任务拆分成小任务，将小任务交给线程池中的工作线程去执行，工作线程执行完任务后，会尝试窃取其他工作线程队列中的任务继续执行。

Fork/Join框架的基本思路是：

1. 将大任务拆分成多个子任务，直到子任务足够小，可以直接被处理。
2. 多个子任务被提交到线程池的工作队列中。
3. 线程池中的工作线程从队列中取出任务并执行。
4. 当工作线程执行完任务后，会尝试窃取其他工作线程队列中的任务继续执行。
5. 当所有子任务执行完成后，合并所有结果得到最终结果。

Fork/Join框架的使用方法是：

1. 定义一个继承自`RecursiveAction`或`RecursiveTask`的任务类，分别代表无返回值的任务和有返回值的任务。
2. 在任务类中实现任务的分割和合并逻辑，使用`compute()`方法执行具体的任务。
3. 在主程序中，创建一个`ForkJoinPool`对象，使用`invoke()`方法提交任务，等待任务执行完成。

使用Fork/Join框架可以很方便地实现一些并行计算的问题，但需要注意的是，如果任务拆分得不够细，可能会导致工作线程的负载不均衡，影响并行计算的性能。因此，在使用Fork/Join框架时需要考虑任务的拆分粒度和负载均衡问题。

# 01 - 数组

## 二分查找

### 704. 二分查找

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/binarysearch/Solution704.java)

#### 思路

1. 令左指针 l = 0, 右指针 r = n-1。 

2. 当 l <= r 时，执行以下步骤   

	a. 计算中间位置 $mid = (l+r) / 2$。   

	b. 如果 nums[mid] == target，则返回 mid。   

	c. 如果 nums[mid] < target，则在 mid 右侧继续查找，令 $l = mid+1$ 。   

	d. 如果 nums[mid] > target，则在 mid 左侧继续查找，令 $r = mid-1$。 

3. 如果没有找到目标值，则返回 -1。

### 35. 搜索插入位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/binarysearch/Solution35.java)

#### 思路

1. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

2. 当左指针小于等于右指针时，进行循环

	a. 计算中间位置 $mid = (left + right) / 2$。

	b. 如果目标值等于中间位置的值，则返回中间位置。

	c. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	d. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

3. 如果循环结束后还没有找到目标值，说明目标值不存在于数组中，需要返回它将会被按顺序插入的位置。此时，左指针指向的位置就是插入位置。

### 34. 在排序数组中查找元素的第一个和最后一个位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/binarysearch/Solution34.java)

#### 思路

1. 第一次二分查找找到目标值的左边界（第一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环

	​	i. 计算中间位置 $mid = (left + right) / 2$。

	​	ii. 如果目标值小于等于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	​	iii. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	c. 如果找到了目标值，需要继续向左查找，直到找到左边界。

2. 第二次二分查找找到目标值的右边界（最后一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环

	​	i. 计算中间位置 $mid = (left + right) / 2$。

	​	ii. 如果目标值大于等于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	​	iii. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	c. 如果找到了目标值，需要继续向右查找，直到找到右边界。

### 69. x 的平方根 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/binarysearch/Solution69.java)

#### 思路

在区间 [0, x] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否小于等于 x。

如果小于等于 x，则将左指针移动到 mid + 1，否则将右指针移动到 mid - 1。

因为要求整数部分，所以最终返回右指针的值。

### 367. 有效的完全平方数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/binarysearch/Solution367.java)

#### 思路

在区间 [1, num] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否等于 num。

如果等于 num，则返回 true，否则根据 mid 的平方与 num 的大小关系来调整左右边界，直到左右边界相遇时退出循环，并返回 false。

## 双指针

### 27. 移除元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/doublepointer/Solution27.java)

#### 思路

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。

当 nums[j] 等于给定值时，将 j 后移一位，直到找到一个不等于给定值的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i]，并将 i 和 j 同时后移一位。

这样就可以将所有等于给定值的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i 的值，即为新数组的长度。

### 26. 删除排序数组中的重复项

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/doublepointer/Solution26.java)

#### 思路

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。当 nums[j] 等于 nums[i] 时，将 j 后移一位，直到找到一个不等于 nums[i] 的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i + 1]，并将 i 后移一位。

这样就可以将重复的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i + 1 的值，即为新数组的长度。

### 283. 移动零

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/doublepointer/Solution283.java)

#### 思路

一个指针 i 用来遍历数组，另一个指针 j 用来指向下一个非零元素应该放置的位置。

遍历数组时，如果当前元素不为 0，则将其放到 nums[j] 的位置上，并将 j 后移一位。遍历结束后，从 j 开始到数组末尾的位置都应该填上 0。

### 844. 比较含退格的字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/doublepointer/Solution844.java)

#### 思路

遍历字符串 s 和 t，遇到非退格字符时，将其压入栈中；遇到退格字符时，将栈顶元素弹出。

遍历结束后，比较两个栈是否相等即可。

### 977. 有序数组的平方

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/doublepointer/Solution977.java)

#### 思路

用两个指针分别指向数组的左右两端，比较两个指针指向的数的绝对值大小，将较大的数的平方放入新数组的末尾。

然后将指针向中间移动，重复上述操作，直到两个指针相遇。

## 滑动窗口

### 209. 长度最小的子数组

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/slidingwindow/Solution209.java)

#### 思路

定义两个指针 left 和 right，分别表示子数组的左右边界，初始值都为 0。

然后用一个变量 sum 来表示子数组中元素的和，初始值为 0。

接下来，不断地将 right 右移，同时将 nums[right] 加入 sum 中，直到 sum >= target。

此时，更新最短子数组的长度，并将 left 右移，同时将 nums[left] 从 sum 中减去，直到 sum < target。重复上述过程，直到 right 到达数组末尾。

### 904. 水果成篮

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/slidingwindow/Solution904.java)

#### 思路

定义两个指针 left 和 right，分别表示窗口的左右边界，初始值都为 0。

然后用一个字典 freq 来记录窗口内每种水果的数量。

接下来，不断地将 right 右移，同时更新 freq，直到窗口内包含了超过两种水果为止。

此时，更新最大收集数量的值，并将 left 右移，直到窗口内只包含两种水果为止。

重复上述过程，直到 right 到达数组末尾。

### 76. 最小覆盖子串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/slidingwindow/Solution76.java)

#### 思路

用两个指针 left 和 right 来表示窗口的左右边界，初始值都为 0。

用一个字典 need 来记录窗口内还需要的每个字符的数量。

初始时，need 中的每个字符的值都为 t 中该字符的数量。

然后，不断地将 right 右移，直到窗口内包含了 t 中的所有字符为止。

此时，可以更新最小子串的值，并将 left 右移，直到窗口不再包含 t 中的所有字符为止。

重复上述过程，直到 right 到达字符串 s 的末尾。

## 模拟行为

### 59.螺旋矩阵II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/mockaction/Solution59.java)

#### 思路

可以定义四个变量 left、right、top、bottom 分别表示当前需要填充的矩阵的左、右、上、下边界，初始值分别为 0、n-1、0、n-1。

然后使用一个循环来不断地填充矩阵，直到左右或上下边界交错为止。

**具体来说**，在每次循环中，首先从左到右填充上边界，然后从上到下填充右边界，接着从右到左填充下边界，最后从下到上填充左边界。

填充完四条边界之后，更新 left、right、top、bottom 的值，并判断是否还需要继续填充矩阵。

### 54.螺旋矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/mockaction/Solution54.java)

#### 思路

同上

### Offer29. 顺时针打印矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/01-Array/src/main/java/com/xin/mockaction/Offer29.java)

#### 思路

这个问题跟上一个问题类似，只不过需要把顺时针打印的数字依次存储在一个数组里面。具体思路可以分为四个步骤

1. 定义上下左右四个边界，初始化为矩阵的边界。
2. 按照顺时针顺序，将矩阵的数字依次存储到结果数组中。具体方法是先从左到右遍历上边界，然后从上到下遍历右边界，然后从右到左遍历下边界，最后从下到上遍历左边界。
3. 每遍历完一条边界后，需要把相应的边界向内缩进一个单位，以便继续遍历下一条边界。
4. 当所有数字都被遍历过后，返回结果数组即可。

# 02 - 链表

## 设计链表

### 707.设计链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/base/Solution707.java)

#### 思路

1. 定义链表节点类 ListNode，包括三个属性val 表示节点值，next 表示指向下一个节点的指针/引用，prev 表示指向前一个节点的指针/引用（对于双向链表）。
2. 定义 MyLinkedList 类，包括两个属性head 表示链表头节点，tail 表示链表尾节点（对于双向链表）。
3. 实现 MyLinkedList 类的构造函数 MyLinkedList()，将头节点 head 初始化为 null，尾节点 tail 初始化为 null（对于双向链表）。
4. 实现 MyLinkedList 类的 get(int index) 方法，遍历链表，查找下标为 index 的节点，并返回该节点的值。如果下标无效，则返回 -1。
5. 实现 MyLinkedList 类的 addAtHead(int val) 方法，在头节点之前插入一个新节点，将新节点的 next 指向头节点，并将头节点设置为新节点。
6. 实现 MyLinkedList 类的 addAtTail(int val) 方法，在尾节点之后插入一个新节点，将尾节点的 next 指向新节点，并将新节点设置为尾节点。
7. 实现 MyLinkedList 类的 addAtIndex(int index, int val) 方法，在下标为 index 的节点之前插入一个新节点。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
8. 实现 MyLinkedList 类的 deleteAtIndex(int index) 方法，删除下标为 index 的节点。如果下标无效，则不执行任何操作。

## 虚拟头节点

### 203. 移除链表元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/dummyhead/Solution203.java)

#### 思路

从头节点开始，遍历链表，删除所有值等于 val 的节点。

需要用两个指针，一个指针 prev 指向当前节点的前一个节点，另一个指针 cur 指向当前节点。

如果当前节点的值等于 val，则需要删除该节点，将 prev 的 next 指针指向 cur 的 next 指针，否则更新 prev 和 cur 指针。

特别地，需要先处理头节点的值等于 val 的情况。

### 24. 两两交换链表中的节点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/dummyhead/Solution24.java)

#### 思路

将链表分成两个节点为一组的小链表，对每一组进行交换。如果链表中节点数量为奇数，最后一个节点不用进行交换。如果链表为空或者只有一个节点，则直接返回该链表。

具体实现时，用变量 `first` 记录每一组的第一个节点，变量 `second` 记录每一组的第二个节点。对 `first` 和 `second` 进行交换，并将第二个节点的 `next` 指针指向递归处理后的子链表的头节点。最后，返回交换后的链表头节点。

### 19. 删除链表的倒数第 N 个结点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/dummyhead/Solution19.java)

#### 思路

首先将快指针向前移动 n 步。然后将慢指针和快指针同时移动，直到快指针到达链表的末尾。

此时，慢指针就指向了倒数第 n 个结点的前一个结点。可以通过修改慢指针的 next 指针来删除倒数第 n 个结点。

需要注意的是，如果要删除的结点是链表的头结点，需要特殊处理。

## 链表相交

### 160.相交链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/intersection/Solution160.java)

#### 思路

设链表 A 长度为 a，链表 B 长度为 b，两个链表的相交部分长度为 c，则有以下结论

两个指针分别从链表 A 和链表 B 的头节点出发，一起向后遍历。

当其中一个指针走到链表尾部时，将其指向另一个链表的头部，继续向后遍历。

当两个指针相遇时，就是相交节点。

**证明如下**

指针 A 走过的距离为 a + c + b，指针 B 走过的距离为 b + c + a。因为 $a + c + b = b + c + a$，所以当两个指针相遇时，一定是在相交节点。

如果两个链表不相交，则在走过 a + b 的距离后，两个指针会同时指向 null，退出循环。

## 环形链表

### 142. 环形链表 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/02-LinkList/src/main/java/com/xin/circle/Solution142.java)

#### 思路

首先设定两个指针 slow 和 fast，初始时指向链表的头节点。然后让 slow 指针每次前进一步，fast 指针每次前进两步。如果链表中存在环，那么 fast 指针最终一定会追上 slow 指针。具体证明可以参考题目描述中的这个例子

使用前面的例子，并在 c3 处连接链表和链表尾部来创建一个带环的链表。pos=1 表示尾部连接到索引为 1 的位置。

在此带环链表中，从 head 开始走到 c1，需要经过 1 次走到 c2，再经过 2 次走到 c3，再经过 2 次回到 c2。在这个过程中，slow 指针走过的节点数为 1+1=2，fast 指针走过的节点数为 1+2+2=5。这是因为在进入环之前，fast 指针的步长始终是 slow 指针的两倍。而一旦进入环之后，两者步长差就会缩小 1，因为每前进 1 次，它们之间的距离就会减小 1，最终追上的时间取决于两者之间的距离差。

假设 slow 指针从 head 节点到环的起点的距离为 x，环的起点到 fast 指针追上 slow 指针的点的距离为 y，slow 指针在环中走了 z 步。那么可以得到以下等式

​																										$2(x+z) = x+z+ny$

其中 n 表示 fast 指针在环中绕了 n 圈。根据等式可以得到 x+z=n(y-z)，也就是说从 head 节点到环的起点的距离加上 z 步恰好等于 n 圈环的长度。因此，当发现 slow 和 fast 相遇时，再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。

具体实现可以分为两个步骤

1. 判断是否有环，并找到相遇点（快慢指针）
2. 找到环的起点（使用一个新指针从链表头部开始遍历，同时从相遇点开始遍历，直到两个指针相遇）

# 03 - 哈希表

## 数组作为哈希表

### 242. 有效的字母异位词

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/array/Solution242.java)

#### 思路

先使用哈希表记录字符串 s 中每个字符出现的次数，然后再遍历字符串 t，对于每个字符，将其在哈希表中对应的次数减一。

如果哈希表中某个字符的次数小于 0，说明 t 包含一个不在 s 中的额外字符，不是 s 的字母异位词。

如果遍历完 t 后哈希表中所有字符的次数都大于等于 0，说明 t 是 s 的字母异位词。

### 383.  赎金信

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/array/Solution383.java)

#### 思路

先统计 magazine 中每个字符出现的次数，然后遍历 ransomNote 中的字符，检查其在 magazine 中出现的次数是否大于等于 ransomNote 中出现的次数。

**具体地**，可以用一个长度为 26 的数组来记录 magazine 中每个字符出现的次数。遍历 magazine 中的每个字符，将其对应的计数器加 1。然后遍历 ransomNote 中的每个字符，将其对应的计数器减 1，如果计数器小于 0，说明 magazine 中没有足够的字符来构成 ransomNote，返回 false。

### 49. 字母异位词分组

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/array/Solution49.java)

#### 思路

将每个单词按照字母顺序排序后作为键存储在哈希表中，值为所有字母顺序相同的单词的列表。

具体来说，对于每个单词，将其按照字母顺序排序后作为键，如果该键在哈希表中不存在，则将该键加入哈希表，并将该单词加入值为一个空列表的键所对应的值中。如果该键已经存在，则将该单词加入该键所对应的值中。最后，将所有值非空的键所对应的值加入结果列表中即可。

#### 438. 找到字符串中所有字母异位词

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/array/Solution438.java)

#### 思路

具体来说，可以先用一个哈希表来记录模式串中每个字符出现的次数，然后用两个指针 left 和 right 表示滑动窗口的左右端点。一开始，两个指针都指向 s 的起始位置。然后，不断地增加 right 指针扩大窗口，直到窗口大小等于 p 的长度为止。在扩大窗口的过程中，每当窗口内的字符满足条件（即窗口内的字符出现次数等于模式串中的字符出现次数）时，就将窗口的左端点作为一个答案加入结果集。接下来，移动左指针并缩小窗口，直到窗口内的字符不再满足条件为止，然后再增加 right 指针扩大窗口，如此往复直到 right 指针到达 s 的末尾。

具体实现时，可以用两个数组来记录当前窗口内每个字符出现的次数，一个是 window，用于记录当前窗口内的字符出现次数，另一个是 needs，用于记录模式串中的字符出现次数。每次增加 right 指针扩大窗口时，更新 window 数组；每次移动 left 指针并缩小窗口时，同样要更新 window 数组。需要注意的是，当窗口大小超过 p 的长度时，需要移动 left 指针并缩小窗口。

最终，将所有的答案返回即可。

## set作为哈希表

### 349. 两个数组的交集

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/set/Solution349.java)

#### 思路

首先，将一个数组中的元素添加到哈希表中，然后遍历另一个数组，检查它们是否在哈希表中出现过，如果出现过，就加入到结果集合中。

### 350. 两个数组的交集 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/set/Solution350.java)

#### 思路

首先遍历 nums1，将每个数字出现的次数记录在哈希表中。然后遍历 nums2，对于每个数字，如果它在哈希表中出现过，就将它加入答案，并将哈希表中的计数减 1。

具体步骤如下

1. 遍历 nums1，将每个数字及其出现次数记录在哈希表中。
2. 遍历 nums2，对于每个数字，如果它在哈希表中出现过，就将它加入答案，并将哈希表中的计数减 1。
3. 返回答案数组。

#### 202. 快乐数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/set/Solution202.java)

#### 思路

首先定义一个Set集合用于存储每次计算的结果，用于判断是否进入了循环。

然后使用getNext方法，计算n每个位置上的数字的平方和，得到下一个数。

如果下一个数等于1，说明n是快乐数，直接返回true。

如果下一个数已经在Set集合中出现过，说明进入了循环，直接返回false。

如果都不是，则将下一个数加入Set集合中，并将下一个数作为新的n继续计算。

## map作为哈希表

### 1. 两数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/map/Solution1.java)

#### 思路

遍历一遍数组，对于每个数，判断它的差值（即 target - nums[i]）是否在哈希表中出现过，如果出现过，说明找到了这两个数，直接返回它们的下标即可。如果没有找到，就将这个数存入哈希表中，继续遍历下一个数。

### 454. 四数相加II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/map/Solution454.java)

#### 思路

先遍历 `nums1` 和 `nums2`，将两个数组中所有数的和及其出现的次数存储在哈希表 `sums` 中。然后遍历 `nums3` 和 `nums4`，对于每一对数，如果它们的相反数在 `sums` 中出现过，就将 `sums` 中该数的出现次数累加到答案中。最后返回答案即可。

## 双指针

### 15. 三数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/doublepointer/Solution15.java)

#### 思路

首先将数组排序，然后枚举第一个数，使用双指针在剩余的数中寻找符合条件的另外两个数。

具体来说，先将给定的数组排序，然后从小到大枚举第一个数，再使用双指针枚举剩下两个数，指针初始位置分别为第一个数的右侧和数组末尾。

如果三个数的和等于 0，则将这三个数添加到答案中。如果三个数的和小于 0，则将左侧指针右移一位。如果三个数的和大于 0，则将右侧指针左移一位。当枚举完成后，返回得到的答案即可。

### 18.四数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/03-Map/src/main/java/com/xin/doublepointer/Solution18.java)

#### 思路

可以将四数之和转化为三数之和的问题，具体步骤如下

1. 对原数组排序。
2. 确定第一个数的位置 i，从 0 开始遍历到 n-4。
3. 对第一个数之后的数组 nums[i+1..n-1] 执行三数之和，目标值为 target - nums[i]。
4. 如果三数之和的解为 [nums[i], nums[j], nums[k]]，则将该解添加到结果中。
5. 注意去重，避免出现重复的解。

# 04 - 字符串

## 双指针

### 344.反转字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/doublepointer/Solution344.java)

#### 思路

1. 定义两个指针left和right，分别指向字符串s的起始和末尾位置；
2. 当left小于right时，交换s[left]和s[right]；
3. left加1，right减1，重复步骤2，直到left>=right。

### 541.反转字符串II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/doublepointer/Solution541.java)

#### 思路

从字符串开头开始，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

具体来说，可以使用一个循环，每次处理 2k 个字符。对于每个 2k 长度的子串，先反转前 k 个字符，然后判断剩余字符的数量，若不足 k 个，则将剩余字符全部反转，否则只反转前 k 个字符。循环处理直至处理完整个字符串。

### 剑指Offer 05.替换空格

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/doublepointer/Offer05.java)

#### 思路

可以先遍历一遍字符串，计算出空格的数量，然后根据空格数量算出替换后字符串的长度，再从后往前遍历字符串，将字符从后往前依次复制到替换后的位置上。

具体步骤如下

1. 统计空格数量，计算替换后字符串的长度

2. 定义两个指针，分别指向原字符串和替换后的字符串的末尾，然后从后往前遍历原字符串

	a. 如果当前字符不是空格，则将其复制到替换后字符串的指针所指向的位置上，并将两个指针都向前移动一位；

	b. 如果当前字符是空格，则将"%20"复制到替换后字符串的指针所指向的位置上，并将替换后字符串的指针向前移动三位，原字符串的指针向前移动一位。

3. 返回替换后的字符串

## 反转

### 151.反转字符串中的单词

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/reverse/Solution151.java)

#### 思路

可以先将字符串去除前导和尾随空格，然后按照空格分割成单词数组，最后将单词数组倒序拼接即可。

### 剑指 Offer 58 - II. 左旋转字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/reverse/Offer58II.java)

#### 思路

可以先将原字符串分为两部分，即要左旋转的部分和剩余部分，然后分别翻转这两部分，最后再将整个字符串翻转一次即可。具体步骤如下

1. 将字符串 s 分为两部分，即要左旋转的部分和剩余部分，分别为 s1 和 s2。s1 包含前 n 个字符，s2 包含剩余字符，即 s1 = s[0:n]，s2 = s[n:len(s)]。
2. 翻转字符串 s1 和 s2，得到 s1' 和 s2'。翻转字符串的方法可以使用双指针，从两端往中间移动，依次交换字符。
3. 将 s1' 和 s2' 拼接成新的字符串 s'，即 s' = s1' + s2'。
4. 翻转字符串 s'，得到最终结果。

## KMP

### 28.找出字符串中第一个匹配项的下标

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/kmp/Solution28.java)

#### 思路

1. 首先判断特殊情况，如果 `needle` 为空字符串，则返回 0。
2. 对于 `haystack` 中的每个字符，从当前位置开始，与 `needle` 中的字符逐一比较。
3. 如果 `needle` 中的所有字符都匹配成功，则返回当前位置。如果 `haystack` 中的字符不足以与 `needle` 中的所有字符比较，则返回 -1。

### 459.重复的子字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/04-String/src/main/java/com/xin/kmp/Solution459.java)

#### 思路

如果一个字符串可以由一个子串重复多次构成，那么这个子串的长度一定是原字符串长度的因数，并且除了原字符串本身以外，这个子串在原字符串中不会出现。因此，可以枚举所有可能的子串长度，对于每个子串长度，判断它是否满足上述两个条件。

具体地，假设原字符串为s，长度为n，从小到大枚举i（i为子串长度），如果i是n的因数，那么将原字符串分割成 n/i 个长度为 i 的子串。如果这 n/i 个子串都相等，并且它们的值恰好为原字符串 s，那么就找到了符合要求的子串。

# 05 - 栈与队列

## 栈

### 栈在系统中的应用

#### 71. 简化路径

[代码链接](https://github.com/HappyAxin/Algorithm/tree/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/stack/system)

##### 思路

遍历整个路径，遇到非斜杠字符则记录开始位置，遇到斜杠字符则记录结束位置，得到一个目录名。然后分类讨论

1. 如果目录名是 "."，则不做任何操作。
2. 如果目录名是 ".."，则将栈顶元素出栈（相当于返回上一级目录）。
3. 如果目录名是其他字符串，则将其入栈。

最后，将栈中的所有元素用斜杠拼接起来即可。

### 括号匹配问题

#### 20. 有效括号

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/stack/bracket/Solution20.java)

##### 思路

遍历字符串，对于每一个字符，如果是左括号，就把它压入栈中；如果是右括号，就弹出栈顶元素并判断是否匹配。如果不匹配，说明字符串无效；如果最后栈不为空，也说明字符串无效。

### 字符串去重问题

#### 1047.删除字符串中的所有相邻重复项

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/stack/deduplication/Solution1047.java)

##### 思路

遍历字符串，如果当前字符和栈顶元素相同，则弹出栈顶元素；否则将当前字符入栈。最终栈中剩余的字符即为答案。

### 逆波兰表达式问题

#### 150.逆波兰表达式求值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/stack/evalRPN/Solution150.java)

##### 思路

逆波兰表达式的求值可以使用栈来实现，具体过程如下

1. 从左到右扫描逆波兰表达式，遇到数字时，将其压入栈中；
2. 遇到运算符时，弹出栈顶的两个数字，进行相应的计算，然后将计算结果压入栈中；
3. 重复上述过程，直到表达式中所有的数字和运算符都被处理；
4. 最终栈中只剩下一个数字，即为表达式的值。

## 队列

### 滑动窗口最大值问题

#### 239.滑动窗口最大值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/quene/array/Solution239.java)

##### 思路

使用双端队列（deque）来实现。

deque 维护一个单调递减的队列，队列中存放的是元素在原数组中的下标。每当移动滑动窗口时，需要将队首元素出队（因为队首元素已经不在滑动窗口中），然后将新的元素依次从队尾入队，并将队列中比当前元素小的元素出队，保证队列的单调性。

在队列中，队首元素就是当前滑动窗口中的最大值，因为它是最早进入队列的，并且在队列中一直保持单调递减，因此它一定是最大的。

### 求前K个高频元素

#### 347.前k个高频元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/05-Stack_Queue/src/main/java/com/xin/quene/priority/Solution347.java)

##### 思路

可以使用哈希表和桶排序结合的方法来解决此问题。具体步骤如下

1. 使用哈希表统计每个元素出现的频率，键为元素，值为出现次数。
2. 对哈希表中的元素按照出现次数进行桶排序，将出现次数相同的元素放在同一个桶中。
3. 遍历桶，按照出现次数从大到小取出前 k 个元素。

# 06 - 二叉树

## 遍历方式

### 递归遍历

#### 144.二叉树的前序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/recursion/Solution144.java)

##### 思路

在实现二叉树前序遍历的递归算法时，可以先访问根节点，然后递归访问左子树，最后递归访问右子树。具体实现步骤如下

1. 判断当前节点是否为空，如果为空则返回。
2. 访问当前节点的值。
3. 递归遍历左子树。
4. 递归遍历右子树。

#### 94.二叉树的中序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/recursion/Solution94.java)

##### 思路

1. 如果当前节点不为空，先遍历当前节点的左子树
2. 访问当前节点
3. 再遍历当前节点的右子树

递归实现时，先递归遍历左子树，再访问当前节点，最后递归遍历右子树。

#### 145.二叉树的后序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/recursion/Solution145.java)

##### 思路

1. 如果根节点为空，直接返回空列表。
2. 否则，先递归遍历左子树，将左子树的后序遍历结果存入结果列表中。
3. 然后递归遍历右子树，将右子树的后序遍历结果存入结果列表中。
4. 最后将根节点的值加入结果列表中。
5. 返回结果列表。

### 迭代遍历

#### 144.二叉树的前序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/iteration/Solution144.java)

##### 思路

在实现二叉树前序遍历的递归算法时，可以先访问根节点，然后递归访问左子树，最后递归访问右子树。具体实现步骤如下

1. 判断当前节点是否为空，如果为空则返回。
2. 访问当前节点的值。
3. 递归遍历左子树。
4. 递归遍历右子树。

#### 94.二叉树的中序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/iteration/Solution94.java)

##### 思路

1. 如果当前节点不为空，先遍历当前节点的左子树
2. 访问当前节点
3. 再遍历当前节点的右子树

递归实现时，先递归遍历左子树，再访问当前节点，最后递归遍历右子树。

#### 145.二叉树的后序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/iteration/Solution145.java)

##### 思路

1. 如果根节点为空，直接返回空列表。
2. 否则，先递归遍历左子树，将左子树的后序遍历结果存入结果列表中。
3. 然后递归遍历右子树，将右子树的后序遍历结果存入结果列表中。
4. 最后将根节点的值加入结果列表中。
5. 返回结果列表。

### 层序遍历

#### 102. 二叉树的层序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution102.java)

##### 思路

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作

	 a. 记录当前队列的长度 size。 

	 b. 依次取出队列中前 size 个节点，并将它们的值存入当前层的数组中。

	 c. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	 d. 将当前层的数组加入最终结果中。

3. 返回最终结果。

#### 107. 二叉树的层序遍历II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution107.java)

##### 思路

按照自顶向下的层序遍历方法，然后将每层的节点值插入到结果数组的前面，这样最终得到的数组就是自底向上的层序遍历。

具体步骤如下

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作 

	a. 记录当前队列的长度 size。 

	b. 定义一个临时数组 level，依次取出队列中前 size 个节点，并将它们的值存入 level 中。 

	c. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	d. 将 level 插入结果数组的前面。

3. 返回最终结果。

#### 199. 二叉树的右视图

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution199.java)

##### 思路

按层遍历二叉树，在每一层选择最右侧的节点，将其值加入结果数组中。具体步骤如下

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作 

	a. 记录当前队列的长度 size。

	b. 依次取出队列中前 size 个节点，并将它们的值存入当前层的数组中。

	c. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	d. 将当前层最右侧节点的值加入结果数组中。

3. 返回最终结果。

#### 637. 二叉树的层平均值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution637.java)

##### 思路

按层遍历二叉树，在每一层将节点的值加起来，然后求平均值，并将平均值加入结果数组中。

具体步骤如下

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作

	a. 记录当前队列的长度 size。 

	b. 定义一个变量 sum，表示当前层节点值的总和。 

	c. 依次取出队列中前 size 个节点，并将它们的值加入 sum 中。 

	d. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	e. 将 sum 除以 size 得到平均值，并将其加入结果数组中。

3. 返回最终结果。

#### 429. N叉树的层序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution429.java)

##### 思路

可以按层遍历 N 叉树，在每一层将节点的值加入结果数组中，并将节点的所有子节点加入队列中。具体步骤如下

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作 

	a. 记录当前队列的长度 size。 

	b. 定义一个数组 level，表示当前层的节点值。 

	c. 依次取出队列中前 size 个节点，并将它们的值加入 level 中。 

	d. 对于每个取出的节点，将其所有非空的子节点加入队列中。 

	e. 将 level 加入结果数组中。

3. 返回最终结果。

#### 515. 在每个树中找最大值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution515.java)

##### 思路

可以按层遍历二叉树，在每一层找出节点值的最大值，并将其加入结果数组中。具体步骤如下

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作 

	a. 记录当前队列的长度 size。 

	b. 定义一个变量 level_max，表示当前层节点值的最大值，初始值为负无穷。 

	c. 依次取出队列中前 size 个节点，并比较它们的值，更新 level_max。 

	d. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	e. 将 level_max 加入结果数组中。

3. 返回最终结果。

#### 116. 填充每个节点的下一个右侧节点指针

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution116.java)

##### 思路

从根节点开始，逐层遍历二叉树。对于每一层，可以记录下一层的第一个节点，然后在遍历当前层时，将每个节点的 next 指针指向其在同层中的下一个节点，这可以通过队列的先进先出（FIFO）特性来实现。

#### 117. 填充每个节点的下一个右侧节点指针II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution117.java)

##### 思路

这道题目是上一题的扩展版，但是不再是完美二叉树。不同的是，由于这不再是一棵完美二叉树，需要在遍历每个节点时，将其左右子树中的节点添加到队列中，以确保其右侧节点的指针正确连接。

#### 104. 二叉树的最大深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution104.java)

##### 思路

使用 DFS，可以递归地遍历每个节点，并将深度作为参数传递。当遇到叶子节点时，返回当前深度。最终，将通过比较每个节点的深度来得到最大深度。

使用 BFS，可以通过遍历每一层来逐步增加深度。将根节点加入队列，然后不断遍历队列中的节点，将它们的子节点加入队列中。每当完成遍历当前层的所有节点时，会增加深度。重复这个过程，直到队列为空。最后得到的深度即为最大深度。

#### 111. 二叉树的最小深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution111.java)

##### 思路

要求二叉树的最小深度，需要考虑一些特殊情况

1. 当根节点为空时，返回深度为 0。
2. 当左子树为空时，最小深度为右子树的最小深度加 1。
3. 当右子树为空时，最小深度为左子树的最小深度加 1。
4. 当左右子树都不为空时，最小深度为左右子树最小深度的较小值加 1。

## 属性

### 101.对称二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution101.java)

#### 思路

对于一个二叉树，如果它的左子树和右子树轴对称，那么这棵二叉树是轴对称的。

具体实现时，编写一个递归函数 `isSymmetricHelper(TreeNode left, TreeNode right)` 来实现对称性的判断。该函数的作用是判断左子树 `left` 和右子树 `right` 是否轴对称。

判断方式是如果 `left` 和 `right` 都为空，返回 `true`；如果 `left` 和 `right` 中有且仅有一个为空，返回 `false`；如果 `left` 和 `right` 的节点值不相等，返回 `false`；否则，递归判断 `left` 的左子树和 `right` 的右子树是否轴对称，以及 `left` 的右子树和 `right` 的左子树是否轴对称，最终返回两个递归结果的逻辑与。

### 100.相同的树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution100.java)

#### 思路

- 如果两个节点都为 null，则说明此节点相同，返回 true。
- 如果两个节点中有一个为 null，则说明此节点不同，返回 false。
- 如果两个节点的值不同，则说明此节点不同，返回 false。
- 对于左右子树，递归调用函数判断是否相同，如果都相同，则说明整棵树相同，返回 true，否则返回 false。

### 572.另一个树的子树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution572.java)

#### 思路

编写一个函数 `isSameTree`，用来判断两棵树是否相同。然后可以遍历树 `root`，对于每个节点，都调用 `isSameTree` 判断其是否与 `subRoot` 相同。如果相同，返回 true；如果不同，分别在左右子树中继续查找。

其中，`isSameTree` 函数用来判断两棵树是否相同。递归的终止条件是，如果两棵树的节点都为 null，返回 true；如果两棵树中有且只有一棵树的节点为 null，返回 false；如果两个节点的值不同，返回 false。如果两个节点的值相同，递归比较它们的左右子树是否相同。

在 `isSubtree` 函数中，首先判断 `root` 是否为 null，如果是，返回 false；然后判断 `root` 是否与 `subRoot` 相同，如果是，返回 true；否则，在 `root` 的左右子树中分别继续查找。如果左右子树中存在一个包含 `subRoot` 的子树，返回 true；否则返回 false。

### 104.二叉树的最大深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution104.java)

#### 思路

使用 DFS，可以递归地遍历每个节点，并将深度作为参数传递。当遇到叶子节点时，返回当前深度。最终，将通过比较每个节点的深度来得到最大深度。

使用 BFS，可以通过遍历每一层来逐步增加深度。将根节点加入队列，然后不断遍历队列中的节点，将它们的子节点加入队列中。每当完成遍历当前层的所有节点时，会增加深度。重复这个过程，直到队列为空。最后得到的深度即为最大深度。

### 111.二叉树的最小深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution111.java)

#### 思路

要求二叉树的最小深度，需要考虑一些特殊情况

1. 当根节点为空时，返回深度为 0。
2. 当左子树为空时，最小深度为右子树的最小深度加 1。
3. 当右子树为空时，最小深度为左子树的最小深度加 1。
4. 当左右子树都不为空时，最小深度为左右子树最小深度的较小值加 1。

### 222.完全二叉树的节点个数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution222.java)

#### 思路

由于完全二叉树的性质，通过比较左右子树的高度来判断最后一层是否填满。如果左右子树的高度相同，则最后一层节点一定在右子树中；否则，最后一层节点一定在左子树中。因此，可以将问题转化为分别求解左右子树的节点个数。

具体来说，如果左子树的高度等于右子树的高度，则说明左子树是一棵满二叉树，其节点个数可以通过公式 $2^h - 1$ 计算得到，其中 h 是树的高度。此时，可以递归地处理右子树，并加上左子树的节点个数。

如果左子树的高度小于右子树的高度，则说明右子树是一棵满二叉树，其节点个数可以通过公式 $2^h - 1$ 计算得到。此时，可以递归地处理左子树，并加上右子树的节点个数。

最后，根节点的节点个数为左右子树节点个数之和加 1。

### 110.平衡二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution110.java)

#### 思路

对于每个节点，都计算其左右子树的高度差，如果高度差超过了1，就返回False，否则递归判断它的左右子树是否也满足高度平衡的条件。

### 257.二叉树的所有路径

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution257.java)

#### 思路

使用DFS（深度优先搜索）。

在递归过程中，先将当前节点的值加入路径中，然后判断当前节点是否为叶子节点，如果是，则将该路径加入结果集；否则，在路径中加入 "->" 符号，然后分别递归遍历当前节点的左右子树。需要注意的是，为了避免路径重复，在递归左右子树时要分别传入新的 StringBuilder 对象，而不是复用之前的 path 对象。

最后，在主函数中判断根节点是否为空，如果为空则直接返回空的结果集；否则，调用 dfs 函数，传入根节点、空的 StringBuilder 对象和结果集 res，并将返回的结果集返回即可。

### 404.左叶子之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution404.java)

#### 思路

首先判断根节点是为空，如果是，则返回0；然后初始化左叶子节点的和为0；如果左子树不为空，则判断其是否为左叶子节点，如果是，则将其值加入到和中；如果不是，则递归遍历左子树。最后，递归遍历右子树并将其结果加入到和中，最后返回左叶子节点的和。

### 513.找树左下角的值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution513.java)

#### 思路

可以使用 BFS 遍历二叉树，每次遍历完一层后，记录该层的最左边节点的值。最后返回最后一层的最左边节点的值。

### 112.路径总和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution112.java)

#### 思路

从根节点开始，对于每个节点，先将目标值减去当前节点的值，然后递归地搜索其左右子树。如果当前节点是叶子节点，并且目标值等于当前节点的值，则说明存在一条根节点到叶子节点的路径，使得路径上所有节点值相加等于目标和。否则，如果当前节点不是叶子节点，则继续搜索其左右子树，直到找到叶子节点或搜索完整棵树为止。

### 700. 二叉搜索树中的搜索 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution700.java)

#### 思路

根据BST的性质，如果当前节点值小于val，则递归搜索右子树，如果当前节点值大于val，则递归搜索左子树，如果当前节点值等于val，则直接返回该节点即可。如果最终未找到节点，返回null。

### 98. 验证二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution98.java)

#### 思路

过递归判断每个节点是否满足二叉搜索树的定义。

具体来说，对于每个节点，需要判断其左子树的所有节点值都小于当前节点的值，右子树的所有节点值都大于当前节点的值，同时左子树和右子树都必须是二叉搜索树。

### 530.二叉搜索树的最小绝对差

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution530.java)

#### 思路

采用中序遍历的方式遍历二叉搜索树，这样得到的遍历结果就是按照从小到大的顺序排列的。然后再遍历一次这个数组，计算任意两个相邻元素之间的差值，找到其中最小的差值即可。

### 501.二叉搜索树中的众数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/attributes/Solution501.java)

#### 思路

通过中序遍历BST并用HashMap统计每个元素的出现次数，然后找出出现次数最多的元素，即为众数。

具体实现步骤如下

1. 定义一个HashMap来统计每个元素出现的次数。
2. 中序遍历BST，对于每个遍历到的节点，将其值加入到HashMap中，并将出现次数加1。
3. 遍历HashMap，找出出现次数最多的元素，将其加入到结果列表中。

## 修改与构造

### 226.翻转二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution226.java)

#### 思路

可以通过递归实现二叉树的翻转，具体做法是将左右子树分别递归地翻转，然后交换左右子树的位置。

如果当前节点为空，则直接返回null。否则，先递归翻转左子树和右子树，然后交换左右子树的位置，最后返回当前节点。

### 106.从中序与后序遍历序列构造二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution106.java)

#### 思路

后序遍历中，最后一个元素一定是根节点，根据根节点在中序遍历中的位置可以将中序遍历分为左子树和右子树两部分。接下来分别递归构建左子树和右子树，最后将左右子树连接到根节点上，构建完整的二叉树。

### 654.最大二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution654.java)

#### 思路

对于给定的数组 nums，首先找到其中的最大值，将其作为根节点，然后将数组分为左右两个部分，递归地构建左子树和右子树。每次递归时，传入数组的左右边界即可。当左边界大于右边界时，返回null即可结束递归。

### 617. 合并二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution617.java)

#### 思路

递归地合并两棵二叉树。如果两个节点都不为 null，则合并它们的值，并继续递归合并它们的左右子树；如果其中一个节点为 null，则直接返回另一个节点。递归结束的条件是，两个节点都为 null。

### 701.二叉搜索树中的插入操作

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution701.java)

#### 思路

对于每个节点，如果要插入的值小于当前节点的值，则将其插入到左子树中；如果要插入的值大于当前节点的值，则将其插入到右子树中。递归插入后返回根节点即可。如果根节点为空，则直接将要插入的值作为根节点返回。由于插入后仍保持为二叉搜索树，因此返回任意一个有效结果即可。

### 450. 删除二叉搜索树中的节点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution450.java)

#### 思路

从根节点开始查找要删除的节点，如果当前节点的值等于要删除的值，则将其删除。删除节点时，需要考虑以下三种情况

1. 要删除的节点是叶子节点，直接删除即可。
2. 要删除的节点只有一个子节点，将其子节点替代要删除的节点即可。
3. 要删除的节点有两个子节点，需要找到其右子树的最小节点，将其值替换到要删除的节点上，并删除右子树中的最小节点。

### 669.修剪二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution669.java)

#### 思路

由于二叉搜索树的性质，当当前节点的值小于low时，需要将其右子树保留，去修剪左子树；当当前节点的值大于high时，需要将其左子树保留，去修剪右子树；当当前节点的值在[low, high]范围内时，需要同时修剪左子树和右子树。

具体实现方法如下

1. 如果根节点为空，则返回空。
2. 对左子树进行递归修剪，并将修剪后的结果作为当前节点的新左子节点。
3. 对右子树进行递归修剪，并将修剪后的结果作为当前节点的新右子节点。
4. 比较当前节点的值与low和high的大小，如果当前节点的值小于low，则返回其右子节点，如果当前节点的值大于high，则返回其左子节点，否则返回当前节点。

### 108. 将有序数组转换为二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution108.java)

#### 思路

使用递归的方式将一个有序数组转换为一棵高度平衡的二叉搜索树。每次选取数组的中间元素作为根节点，左半部分作为左子树，右半部分作为右子树，然后递归构建左右子树。

### 538. 把二叉搜索树转换为累加树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution538.java)

#### 思路

使用反向中序遍历（从右到左）二叉搜索树的方式实现。具体来说，对于二叉搜索树中的一个节点，可以通过反向中序遍历先访问右子树，再累加到当前节点，最后访问左子树。

具体实现步骤如下

1. 定义一个全局变量sum，用于累加遍历到的节点值之和，初始化为0。
2. 从根节点开始，进行反向中序遍历。如果当前节点为空，直接返回。
3. 对当前节点的右子树进行递归操作。
4. 更新当前节点的节点值为sum加上当前节点的节点值，更新sum为新的节点值。
5. 对当前节点的左子树进行递归操作。
6. 遍历完成后，返回根节点。

## 公共祖先问题

### 236. 二叉树的最近公共祖先

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/ancestor/Solution236.java)

#### 思路

通过递归的方式求解二叉树中两个节点的最近公共祖先。对于每个节点，判断其左右子树中是否包含目标节点，若包含，则返回该子树的最近公共祖先；若不包含，则返回当前节点。

具体步骤如下

1. 若根节点为空，返回空节点。
2. 若根节点为其中一个目标节点，返回该节点。
3. 在左子树中递归查找目标节点`p` 和 `q`，得到 `left`。如果 `left` 非空，说明 `p` 和 `q` 分别在左子树中，返回 `left`。
4. 在右子树中递归查找目标节点 `p` 和 `q`，得到 `right`。如果 `right` 非空，说明 `p` 和 `q` 分别在右子树中，返回 `right`。
5. 如果 `left` 和 `right` 都非空，说明 `p` 和 `q` 分别在根节点的左右子树中，返回根节点。
6. 如果 `left`和 `right` 中有一个为空，则另一个非空节点为目标节点的最近公共祖先，返回非空节点。

### 235. 二叉搜索树的最近公共祖先

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/06-BinaryTree/src/main/java/com/xin/ancestor/Solution235.java)

#### 思路

在二叉搜索树中，如果节点`p`和`q`分别位于当前节点的左子树和右子树中，那么当前节点就是它们的最近公共祖先，如果它们都在当前节点的左子树中，则递归左子树查找，如果它们都在右子树中，则递归右子树查找。因为二叉搜索树的特性，如果当前节点的值比`p`和`q`都大，那么它们肯定都在左子树中，如果比它们都小，那么它们肯定都在右子树中。

其中，`root`为当前节点，`p`和`q`是需要查找的节点。首先判断当前节点是否为null或者是p或者q中的一个，如果是，直接返回当前节点。如果当前节点的值比`p`和`q`都大，那么递归左子树，否则递归右子树。

# 07 - 回溯算法

## 组合问题

### 77. 组合

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/combination/Solution77.java)

#### 思路

回溯法，通过递归地尝试每个数字来构建组合。

具体来说，从第一个数字开始，递归地向下添加数字，直到得到长度为 k 的组合。然后，回溯到上一个数字，并继续尝试其他数字，直到得到了所有可能的组合。最后，返回所有可能的组合。

---

#### 优化

尝试使用“剪枝”来减少递归树的深度。

具体来说，可以在递归过程中，判断剩余可选的数字数量是否足够组成一个组合，如果不足，就直接返回，避免进入无用的递归。这样一来，递归树的深度就可以得到很大的减少，从而节约了内存。

### 216. 组合总和 III

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/combination/Solution216.java)

#### 思路

使用回溯算法来解决。可以从数字 1 到 9 中选择 k 个数字，递归地搜索下去，直到数字和等于 n 或者超过 n。在搜索过程中，为了避免重复，需要保证每个数字只被选一次，因此需要用一个布尔数组来记录每个数字是否已经被选过。

### 17. 电话号码的字母组合 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/combination/Solution17.java)

#### 思路

使用回溯算法来解决。可以用一个 HashMap 来存储每个数字对应的所有字母，然后从字符串的第一个数字开始，递归地生成所有可能的字母组合。在递归的过程中，需要遍历当前数字对应的所有字母，将其添加到当前组合中，并递归生成下一位数字的组合。当组合长度达到字符串长度时，将当前组合添加到结果中。

### 39. 组合总和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/combination/Solution39.java)

#### 思路

使用回溯法来找到所有可能的组合，先将候选数数组进行排序，然后从数组的起始位置开始搜索。

在回溯过程中，将当前候选数添加到中间结果列表中，并将目标数减去该数。然后继续在剩余的候选数中搜索，直到目标数为0或不再存在候选数。如果目标数为0，则将当前中间结果添加到结果列表中。如果没有其他候选数，则将返回到上一个搜索状态。

时间复杂度：**O**($N^{T / M + 1}$)，其中N为数组的长度，T为目标数，M为最小的候选数。

空间复杂度：**O**($T/M$)，其中T为目标数，M为最小的候选数。

### 40. 组合总和II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/combination/Solution40.java)

#### 思路

在搜索过程中保证同一个候选数只能被使用一次。

具体来说，在搜索一个新的候选数之前，需要判断该候选数是否已经被使用过。如果当前候选数已经被用过，或者当前候选数与前一个候选数相同且前一个候选数没有被用过，就跳过。这可以通过添加一个额外的判断条件来实现。

时间复杂度：O($2^N$)，其中N为数组的长度。

空间复杂度：O(N)。

## 排列问题

### 46. 全排列

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/arrangement/Solution46.java)

#### 思路

在`backtrack`方法中，首先检查当前排列的长度是否等于数组的长度，如果是，则将当前排列添加到结果集`permutations`中。

然后，遍历数组中的每个数字，如果当前数字不在当前排列中，将其添加到当前排列中。然后，递归调用`backtrack`方法，继续生成下一个数字的排列。

递归返回后，需要回溯，即将当前数字从排列中移除，以便尝试其他数字。

### 47. 全排列II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/arrangement/Solution47.java)

#### 思路

在`backtrack`方法中，首先检查当前排列的长度是否等于数组的长度，如果是，则将当前排列添加到结果集`permutations`中。

然后，遍历数组中的每个数字，并跳过已经使用过的数字。使用一个布尔数组`used`来追踪数字的使用情况。

在每一步中，将未使用过的数字添加到当前排列中，将对应的`used`数组标记为已使用，然后递归调用`backtrack`方法生成下一个数字的排列。

递归返回后，需要回溯，即将当前数字从排列中移除，并将对应的`used`数组标记为未使用，以便尝试其他数字。

### 332. 重新安排行程 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/arrangement/Solution332.java)

#### 思路

首先构建一个邻接表来表示每个机场和其对应的目的地机场。使用`Map<String, PriorityQueue<String>>`来存储邻接表，其中每个机场对应的目的地机场使用优先队列进行存储，以保证按字典序进行排序。

然后，使用深度优先搜索（DFS）进行行程的规划。从起始机场`JFK`开始，依次访问目的地机场，并递归进行深度优先搜索。

在DFS过程中，首先从邻接表中获取当前机场的目的地机场优先队列，然后依次取出目的地机场进行DFS递归。这样可以保证按字典序选择最小的目的地机场进行下一步搜索。

DFS结束后，将机场添加到行程中。

最后，将行程进行反转，以得到最小行程组合。

## 切割问题

### 131.  分割回文串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/partition/Solution131.java)

#### 思路

和之前的实现非常相似，唯一的区别在于判断子串是否为回文串时使用了`isPalindrome`函数。`isPalindrome`函数用来判断`s`从`start`到`end`位置的子串是否为回文串，具体实现是使用双指针从两端开始向中间移动，判断对应的字符是否相等。

时间复杂度：O($N * 2^N$)，其中N为字符串的长度。对于每个字符，都有两种选择：将其作为一个新的回文串的起始位置，或将其加入到前一个回文串中。

空间复杂度：O($N$)，其中N为字符串的长度。存储中间结果需要使用O(N)的空间。

### 93. 复原IP地址

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/partition/Solution93.java)

#### 思路

可以将IP地址分成4个段，每个段都有一个范围：0-255，对于每一个段，可以枚举所有可能的长度，然后判断其是否合法（即不含有前导0且不大于255），如果合法，则将其加入到中间结果中，并递归地搜索下一段，否则直接返回。当找到了4个合法的IP地址段，并且整个字符串都被扫描完了，则将当前中间结果加入到最终结果中。

在回溯过程中，记录当前搜索的起始位置，以及已经找到了几个IP地址段。当已经找到了4个IP地址段且已经扫描完整个字符串时，将当前中间结果加入到最终结果中。如果已经找到了4个IP地址段但还没扫描完整个字符串，则直接返回。如果还没有找到4个IP地址段，则枚举当前段的长度，判断是否合法，如果合法则将其加入到中间结果中，并递归地搜索下一段，否则直接返回。

时间复杂度：O($3^4$)，即最多枚举$3^4$种可能的IP地址。

空间复杂度：O($1$)，只需要使用常数级别的额外空间。

## 子集问题

### 78. 子集

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/subset/Solution78.java)

#### 思路

在`subsets`方法中，初始化一个空的结果集`subsets`，然后调用`backtrack`方法生成所有可能的子集。`backtrack`方法采用递归的方式生成子集。

在`backtrack`方法中，首先将当前子集添加到结果集`subsets`中。然后从`start`位置开始遍历数组`nums`，将当前元素添加到当前子集中。接下来，递归调用`backtrack`方法，以当前元素为起点，生成以当前元素为起点的子集。递归返回后，将当前元素从当前子集中移除，以便尝试其他元素。通过不断地添加和移除元素，可以生成所有可能的子集。

### 90. 子集II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/subset/Solution90.java)

#### 思路

首先对数组进行排序，以确保重复元素相邻。然后，在`backtrack`方法中，通过添加判断条件跳过重复的元素。具体而言，如果当前元素与前一个元素相同（即`nums[i] == nums[i - 1]`），并且不是从起点开始（即`i > start`），则跳过当前元素。这样可以避免生成重复的子集。

### 491. 递增子序列

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/subset/Solution90.java)

#### 思路

使用回溯算法来生成所有可能的递增子序列。在`backtrack`方法中，首先检查当前子序列的长度，如果长度大于等于2，则将其添加到结果集`subsequences`中。

然后，使用一个`Set`集合`used`来去重，以跳过重复的元素。在遍历数组时，如果当前元素已经在`used`集合中存在，则跳过该元素。

接下来，检查两个条件：

1. 如果当前子序列为空，或者当前元素大于等于子序列中的最后一个元素，则将当前元素添加到子序列中。
2. 然后，递归调用`backtrack`方法，继续向后遍历数组生成下一个递增子序列。
3. 递归返回后，需要回溯，即将当前元素从子序列中移除，以便尝试其他元素。

## 棋盘问题

### 51. N皇后 *

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/checkerboard/Solution51.java)

#### 思路

用的方法肯定是回溯啦！

使用一个二维字符数组`board`来表示棋盘，其中每个位置的字符可以是'Q'（皇后）或'.'（空位）。

在`solveNQueens`方法中，首先创建一个空的棋盘，并将所有位置初始化为'.'。然后，调用`backtrack`方法开始回溯。

在`backtrack`方法中，按行遍历棋盘。对于每一行，尝试将皇后放置在该行的每个位置上，然后递归调用`backtrack`方法处理下一行。

在放置皇后之前，通过调用`isValid`方法检查当前位置是否满足规则。需要检查当前列、左上方斜线和右上方斜线是否存在其他皇后。

如果当前位置满足规则，将该位置标记为'Q'，然后进行递归调用。递归返回后，需要回溯，即将当前位置重新标记为'.'，以便尝试其他位置。

当回溯到最后一行时，将当前棋盘的解决方案添加到结果集`solutions`中。`constructSolution`方法用于将字符数组转换为字符串列表表示解决方案。

### 37. 解数独

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/07-Backtrack/src/main/java/com/xin/checkerboard/Solution37.java)

#### 思路

使用一个9x9的二维字符数组`board`来表示数独棋盘。

在`solveSudoku`方法中，调用`solve`方法开始回溯求解。

在`solve`方法中，按行遍历棋盘，并在遇到空白格时进行处理。对于每个空白格，尝试将数字'1'到'9'填入，并通过调用`isValid`方法检查当前位置是否满足数独规则。

如果当前位置满足规则，将数字填入该位置，并继续递归地调用`solve`方法处理下一个位置。如果最终求解成功，则返回`true`，否则进行回溯，将当前位置重新设置为空白格，并尝试下一个数字。

在`isValid`方法中，检查当前位置所在的行、列和3x3宫格是否满足数独规则。如果存在重复数字，则返回`false`，否则返回`true`。

# 08 - 贪心算法

【注明】：这里的难易程度不是根据LeetCode上面来的，是根据能否通过常识来判断是否可以使用贪心算法。

## 简单题

### 455. 分发饼干

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/easy/Solution455.java)

#### 思路

首先，对孩子的胃口值数组`g`和饼干的尺寸数组`s`进行排序，以便从小到大进行匹配。

接下来，使用两个指针`i`和`j`分别表示当前遍历到的孩子和饼干。从头开始遍历，如果当前饼干的尺寸`s[j]`大于等于当前孩子的胃口值`g[i]`，则将这块饼干分配给孩子，孩子数量加一，并且将孩子指针`i`和饼干指针`j`都向后移动一位。如果当前饼干不能满足当前孩子的胃口，只将饼干指针`j`向后移动一位。

通过遍历完所有的孩子和饼干后，返回满足胃口的孩子数量`contentChildren`即为最大能满足的孩子数量。

### 1005. K 次取反后最大化的数组和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/easy/Solution1005.java)

##### 思路

首先对数组进行排序，然后遍历数组，将负数变为正数，直到负数用完或者达到k次操作。

接下来，如果还有剩余的k次操作且k为奇数，我们需要找到数组中的最小值，并将其取反。

最后，计算修改后数组的和，并返回最大和。

### 860. 柠檬水找零

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/easy/Solution860.java)

#### 思路

使用两个变量`fiveCount`和`tenCount`分别记录手头的5美元和10美元的数量。

遍历顾客付的账单数组`bills`，根据不同的账单金额进行处理。

- 如果账单为5美元，将`fiveCount`加1。
- 如果账单为10美元，需要找零5美元，所以需要至少有一张5美元的钞票。如果没有足够的5美元可以找零，则返回false。否则，将`fiveCount`减1，`tenCount`加1。
- 如果账单为20美元，可以找零15美元。优先使用10美元和5美元进行找零，所以需要至少有一张10美元和一张5美元的钞票。如果没有足够的5美元和10美元可以找零，则需要至少有三张5美元的钞票。如果以上两种情况都不满足，则返回false。

最后，如果遍历完所有账单后没有出现无法找零的情况，则返回true。

## 中等题

### 376. 摆动序列

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/Solution376.java)

##### 思路

首先，处理特殊情况，如果数组长度小于2，则最长摆动子序列长度即为数组长度。

然后，通过遍历数组，从第二个元素开始计算当前差值`currDiff`和前一个差值`prevDiff`。如果当前差值和前一个差值的正负号不同，说明形成了摆动，最长子序列长度加一，并更新前一个差值为当前差值。

最后，返回最长摆动子序列的长度`maxLength`。

### 738. 单调递增的数字

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/Solution738.java)

#### 思路

首先，将整数`n`转换为字符数组`digits`。

然后，从右向左遍历字符数组，找到第一个不满足单调递增的位置`marker`，即当前位数小于前一位数。

找到该位置后，将该位置前一位数减1，并将标记位置及其右侧的所有位数修改为9，使得满足最大单调递增的条件。

最后，将修改后的字符数组转换为整数进行返回。

### 股票问题

#### 122. 买卖股票的最佳时机 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/stock/Solution122.java)

##### 思路

收集每天的正利润就可以，**收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间**。

那么只收集正利润就是贪心所贪的地方！

**局部最优：收集每天的正利润，全局最优：求得最大利润**。

#### 714. 买卖股票的最佳时机含手续费

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/stock/Solution714.java)

##### 思路

首先，定义两个变量`cash`和`hold`，分别表示当前手中的现金和当前持有股票的价值。

从第二天开始遍历股票价格数组`prices`，对于每一天，根据当前的现金和持有股票的价值，分别计算在该天卖出股票和买入股票的可能性，并更新`cash`和`hold`的值。

- 如果卖出股票能获得更高的价值（考虑手续费），则更新`cash`为卖出股票后的现金。
- 如果买入股票能获得更高的价值，则更新`hold`为买入股票后的价值（负值表示花费的现金）。

最后，返回`cash`，即为获得的最大利润。

### 维度权衡问题

#### 135. 分发糖果

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/balance/Solution135.java)

##### 思路

首先初始化每个孩子的糖果数为1。

然后，我们从左到右遍历数组，如果右边孩子的评分更高，我们给右边孩子分配的糖果数为左边孩子糖果数加1。

接下来，我们从右到左遍历数组，处理左边评分更高的孩子获得更多糖果的情况。如果左边孩子的评分更高，我们取当前孩子糖果数和右边孩子糖果数加1的较大值。

最后，我们计算总的糖果数，即每个孩子分配的糖果数的总和。

#### 406. 根据身高重建队列

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/medium/balance/Solution406.java)

##### 思路

首先对输入数组`people`进行排序，排序规则为按照身高降序排序，如果身高相同则按照ki升序排序。

然后，创建一个`List<int[]>`来存储重构后的队列。遍历排序后的数组`people`，根据每个人的ki值将其插入到相应的位置。

最后，将List转换为二维数组，即为重构后的队列。

## 困难题

### 区间

#### 55. 跳跃游戏

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution55.java)

##### 思路

使用变量`maxReach`来记录当前能够到达的最远位置。

遍历数组，对于每个位置，判断是否超过了当前能够到达的最远位置。如果超过了，则说明无法到达最后一个下标，返回`false`。

否则，更新当前能够到达的最远位置，取当前位置加上该位置能够跳跃的最大长度`nums[i]`与`maxReach`的较大值。

最后，判断最后能够到达的位置`maxReach`是否大于等于最后一个下标`nums.length - 1`，如果是，则说明可以到达最后一个下标，返回`true`；否则，返回`false`。

#### 45. 跳跃游戏II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution45.java)

##### 思路

使用变量`jumps`来记录跳跃次数，`currEnd`来记录当前能够到达的最远位置，`currFarthest`来记录当前能够到达的最远距离。

遍历数组，对于每个位置，更新当前能够到达的最远距离`currFarthest`，取当前位置加上该位置能够跳跃的最大长度`nums[i]`与`currFarthest`的较大值。

然后，如果当前位置达到了当前能够到达的最远位置`currEnd`，说明需要进行一次跳跃。我们增加跳跃次数`jumps`，并将`currEnd`更新为`currFarthest`，表示下一次跳跃的范围。

最后，返回跳跃次数`jumps`。

#### 452. 用最少数量的箭引爆气球

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution452.java)

##### 思路

首先对输入数组`points`进行排序，排序规则为按照气球的结束坐标进行升序排序。

然后，初始化弓箭数量`count`为0，初始化当前弓箭的射出位置`end`为最小值。

遍历排序后的数组`points`，如果当前气球的开始坐标大于当前弓箭的射出位置`end`，则需要射出一支新的弓箭，同时更新弓箭的射出位置为当前气球的结束坐标。

最后，返回弓箭数量`count`即为需要射出的最小弓箭数。

> 因为有`points = [[-2147483648,2147483647]]`这个测试用例导致int越界，所以代码中int要强转成long

#### 435. 无重叠区间

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution435.java)

##### 思路

首先对输入数组`intervals`进行排序，排序规则为按照区间的结束位置进行升序排序。

然后，初始化需要移除的区间数量`count`为0，初始化当前区间的结束位置`end`为最小值。

遍历排序后的数组`intervals`，如果当前区间的开始位置大于等于前一个区间的结束位置`end`，说明当前区间和前一个区间不重叠，更新当前区间的结束位置为当前区间的结束位置。

如果当前区间和前一个区间重叠，说明需要移除当前区间，移除区间数量`count`加一。

最后，返回移除区间数量`count`即为需要移除的最小区间数量。

#### 763. 划分字母区间

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution763.java)

##### 思路

首先，创建一个长度为26的数组`lastIndices`，用于记录每个字母最后出现的位置。

然后，遍历字符串`s`，更新每个字母的最后出现位置。

接下来，初始化一个空的列表`partitions`，用于存储每个片段的长度。同时，初始化当前片段的起始位置`start`为0，当前片段的结束位置`end`为0。

然后，遍历字符串`s`，根据每个字母的最后出现位置更新当前片段的结束位置`end`。如果当前位置等于当前片段的结束位置，说明当前片段已经达到最大长度，将当前片段的长度（即`end - start + 1`）加入结果列表`partitions`，并更新下一个片段的起始位置`start`为`end + 1`。

最后，返回结果列表`partitions`即为每个字符串片段的长度。

#### 56. 合并区间

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/interval/Solution56.java)

##### 思路

首先，根据区间的起始位置对数组`intervals`进行排序。

然后，创建一个列表`mergedIntervals`，用于存储合并后的区间。同时，初始化当前区间`currentInterval`为排序后的第一个区间。

接下来，遍历排序后的区间数组，比较当前区间与下一个区间的起始位置和结束位置，根据重叠与否进行合并。

如果下一个区间的起始位置小于等于当前区间的结束位置，说明两个区间有重叠，更新当前区间的结束位置为两个区间的最大结束位置。

如果下一个区间与当前区间没有重叠，将当前区间加入合并后的区间列表，并更新当前区间为下一个区间。

最后，将最后一个区间加入合并后的区间列表，并将列表转换为二维数组进行返回。

### 其他

#### 53.  最大子数组合

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/other/Solution53.java)

##### 思路

使用两个变量`maxSum`和`currSum`来记录最大子数组和和当前子数组和。

从数组的第二个元素开始遍历，对于每个元素，有两种选择：将其加入到当前子数组中，或者以其作为新的起点开始一个新的子数组。

通过比较将当前元素加入到当前子数组后的和`currSum + nums[i]`和当前元素本身`nums[i]`的大小，选择较大的值作为当前子数组和`currSum`。

然后，比较当前子数组和`currSum`和最大子数组和`maxSum`的大小，将较大值更新为最大子数组和`maxSum`。

最终，返回最大子数组和`maxSum`。

#### 134. 加油站

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/other/Solution134.java)

##### 思路

遍历加油站，并计算总的剩余汽油量和当前剩余汽油量。

如果当前剩余汽油量小于0，表示无法从当前加油站前往下一个加油站。此时，我们需要将起始加油站设置为下一个加油站，并将当前剩余汽油量重置为0。

最后，我们判断总的剩余汽油量是否大于等于0，如果是，则表示可以绕环路行驶一周，返回起始加油站的编号；否则，返回-1。

#### 968. 监控二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/08-Greedy/src/main/java/com/xin/hard/other/Solution968.java)

##### 思路

首先，创建一个计数器`cameras`，用于记录摄像头的数量。

然后，调用`dfs`方法进行递归遍历二叉树。在每个节点上，根据其子节点的状态进行判断：

- 如果左子树或右子树的状态为0，表示当前节点未被监控到，则在当前节点安装摄像头，并返回1表示当前节点已被监控。
- 如果左子树或右子树的状态为1，表示当前节点已被监控，则返回2表示当前节点不需要监控。
- 如果左子树和右子树的状态都为2，表示当前节点未被监控且没有子节点被监控，则返回0表示当前节点未被监控。

在递归的过程中，如果根节点的状态为0，说明根节点未被监控到，此时在根节点安装摄像头。

最后，返回摄像头的数量。

# 09 - 动态规划

## 基础

### 509.斐波那契数列

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution509.java)

#### 思路

- 我们使用一个数组 `dp` 来保存计算过的斐波那契数。
- 首先，判断如果 `n` 小于等于 1，则直接返回 `n`。
- 然后，初始化数组中的前两个元素为 0 和 1。
- 接下来，从 `i = 2` 开始，使用状态转移方程 `dp[i] = dp[i - 1] + dp[i - 2]` 逐步计算斐波那契数。
- 最后，返回 `dp[n]` 即为所求的斐波那契数。

**时间复杂度**：O($n$)

**空间复杂度**：O($n$)

### 70.爬楼梯

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution70.java)

#### 思路

- 我们使用一个数组 `dp` 来保存到达每个台阶的方法数。
- 首先，判断如果 `n` 小于等于 2，则直接返回 `n`。
- 然后，初始化数组中的前两个元素为 1 和 2，表示爬1个台阶有1种方法，爬2个台阶有2种方法。
- 接下来，从 `i = 3` 开始，使用状态转移方程 `dp[i] = dp[i - 1] + dp[i - 2]` 逐步计算到达每个台阶的方法数。
- 最后，返回 `dp[n]` 即为爬楼梯的方法数。

**时间复杂度**：O($n$)

**空间复杂度**：O($n$)

### 746.使用最小花费爬楼梯

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution746.java)

#### 思路

- 我们使用一个数组 `dp` 来保存达到每个台阶的最低花费。
- 初始状态：到达第一个台阶和第二个台阶的最低花费分别为 `cost[0]` 和 `cost[1]`。
- 接下来，从 `i = 2` 开始，使用状态转移方程 `dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])` 逐步计算达到每个台阶的最低花费。
- 最后一步可以选择从倒数第一个台阶或倒数第二个台阶跨到顶部，所以返回倒数第一个台阶和倒数第二个台阶的最小值。

**时间复杂度**：O($n$)

**空间复杂度**：O($n$)

### 62.不同路径

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution62.java)

#### 思路

- 我们使用一个二维数组 `dp` 来保存到达每个网格的路径数。
- 首先，初始化边界条件：第一行和第一列的路径数都为 1，因为机器人只能向下或向右移动一步。
- 接下来，从第二行和第二列开始，使用状态转移方程 `dp[i][j] = dp[i - 1][j] + dp[i][j - 1]` 逐步计算到达每个网格的路径数。
- 最后，返回右下角网格的路径数，即为所求的不同路径数。

**时间复杂度**：O($m*n$)

**空间复杂度**：O($m*n$)

### 63.不同路径II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution63.java)

#### 思路

- 我们使用一个二维数组 `dp` 来保存到达每个网格的路径数。
- 首先，处理起始位置和障碍物情况：如果起始位置有障碍物，则无法到达终点，返回0；否则，将起始位置标记为1，表示可达。
- 接下来，处理第一行和第一列的路径数，如果遇到障碍物，后面的路径数均为0；否则，后面的路径数与前面的路径数相同。
- 然后，从第二行和第二列开始，逐步计算到达每个网格的路径数。如果当前位置是障碍物，路径数为0；否则，路径数等于上方格子的路径数加上左方格子的路径数。
- 最后，返回右下角网格的路径数，即为所求的不同路径数。

**时间复杂度**：O($m*n$)

**空间复杂度**：O($m*n$)

### 343.整数拆分

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution343.java)

#### 思路

- 我们使用一个数组 `dp` 来保存拆分整数 i 可获得的最大乘积。
- 初始状态：拆分整数 1 的最大乘积为 1。
- 接下来，从整数 2 开始，逐步计算拆分整数 i 的最大乘积。
- 对于整数 i，我们可以将其拆分为 j 和 i-j 两部分，其中 j 的范围是 1 到 i-1。我们需要比较三种情况的乘积大小：j * (i - j)、j * dp[i - j]、dp[i]（不拆分整数 i）。
- 最终，返回拆分整数 n 可获得的最大乘积，即为所求。

**时间复杂度**：O($n^2$)

**空间复杂度**：O($n$)

### 96.不同的二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/09-DynamicProgramming/src/main/java/com/xin/basic/Solution96.java)

#### 思路

- 我们使用一个数组 `dp` 来保存节点数为 i 的二叉搜索树的种数。
- 初始状态：节点数为 0 和 1 的二叉搜索树的种数都为 1。
- 接下来，从节点数为 2 开始，逐步计算节点数为 i 的二叉搜索树的种数。
- 对于节点数为 i 的二叉搜索树，我们可以选择任意一个节点作为根节点，然后将剩余的节点分为左子树和右子树。
- 我们需要遍历所有可能的根节点，将左子树和右子树的种数相乘，累加到总种数上。
- 最终，返回节点数为 n 的二叉搜索树的种数，即为所求。

**时间复杂度**：O($n^2$)

**空间复杂度**：O($n$)
