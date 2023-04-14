# Algorithm

LeetCode算法代码及笔记，刷题顺序是跟着[代码随想录](https://www.programmercarl.com/)来的，代码数组中有些是养的，后面就是自己的思路和代码了

# 数组

## 二分查找

### 704. 二分查找

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution704.java)

#### 思路

1. 令左指针 l = 0, 右指针 r = n-1。 

2. 当 l <= r 时，执行以下步骤   

	a. 计算中间位置 mid = (l+r)/2。   

	b. 如果 nums[mid] == target，则返回 mid。   

	c. 如果 nums[mid] < target，则在 mid 右侧继续查找，令 l = mid+1。   

	d. 如果 nums[mid] > target，则在 mid 左侧继续查找，令 r = mid-1。 

3. 如果没有找到目标值，则返回 -1。

### 35. 搜索插入位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution35.java)

#### 思路

1. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

2. 当左指针小于等于右指针时，进行循环

	a. 计算中间位置 mid = (left + right) / 2。

	b. 如果目标值等于中间位置的值，则返回中间位置。

	c. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	d. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

3. 如果循环结束后还没有找到目标值，说明目标值不存在于数组中，需要返回它将会被按顺序插入的位置。此时，左指针指向的位置就是插入位置。

### 34. 在排序数组中查找元素的第一个和最后一个位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution34.java)

#### 思路

1. 第一次二分查找找到目标值的左边界（第一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环

	​	i. 计算中间位置 mid = (left + right) / 2。

	​	ii. 如果目标值小于等于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	​	iii. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	c. 如果找到了目标值，需要继续向左查找，直到找到左边界。

2. 第二次二分查找找到目标值的右边界（最后一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环

	​	i. 计算中间位置 mid = (left + right) / 2。

	​	ii. 如果目标值大于等于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	​	iii. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	c. 如果找到了目标值，需要继续向右查找，直到找到右边界。

### 69. x 的平方根 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution69.java)

#### 思路

在区间 [0, x] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否小于等于 x。

如果小于等于 x，则将左指针移动到 mid + 1，否则将右指针移动到 mid - 1。

因为要求整数部分，所以最终返回右指针的值。

### 367. 有效的完全平方数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution367.java)

#### 思路

在区间 [1, num] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否等于 num。

如果等于 num，则返回 true，否则根据 mid 的平方与 num 的大小关系来调整左右边界，直到左右边界相遇时退出循环，并返回 false。

## 双指针

### 27. 移除元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution27.java)

#### 思路

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。

当 nums[j] 等于给定值时，将 j 后移一位，直到找到一个不等于给定值的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i]，并将 i 和 j 同时后移一位。

这样就可以将所有等于给定值的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i 的值，即为新数组的长度。

### 26. 删除排序数组中的重复项

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution26.java)

#### 思路

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。当 nums[j] 等于 nums[i] 时，将 j 后移一位，直到找到一个不等于 nums[i] 的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i + 1]，并将 i 后移一位。

这样就可以将重复的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i + 1 的值，即为新数组的长度。

### 283. 移动零

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution283.java)

#### 思路

一个指针 i 用来遍历数组，另一个指针 j 用来指向下一个非零元素应该放置的位置。

遍历数组时，如果当前元素不为 0，则将其放到 nums[j] 的位置上，并将 j 后移一位。遍历结束后，从 j 开始到数组末尾的位置都应该填上 0。

### 844. 比较含退格的字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution844.java)

#### 思路

遍历字符串 s 和 t，遇到非退格字符时，将其压入栈中；遇到退格字符时，将栈顶元素弹出。

遍历结束后，比较两个栈是否相等即可。

### 977. 有序数组的平方

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution977.java)

#### 思路

用两个指针分别指向数组的左右两端，比较两个指针指向的数的绝对值大小，将较大的数的平方放入新数组的末尾。

然后将指针向中间移动，重复上述操作，直到两个指针相遇。

## 滑动窗口

### 209. 长度最小的子数组

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution209.java)

#### 思路

定义两个指针 left 和 right，分别表示子数组的左右边界，初始值都为 0。

然后用一个变量 sum 来表示子数组中元素的和，初始值为 0。

接下来，我们不断地将 right 右移，同时将 nums[right] 加入 sum 中，直到 sum >= target。

此时，我们更新最短子数组的长度，并将 left 右移，同时将 nums[left] 从 sum 中减去，直到 sum < target。重复上述过程，直到 right 到达数组末尾。

### 904. 水果成篮

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution904.java)

#### 思路

定义两个指针 left 和 right，分别表示窗口的左右边界，初始值都为 0。

然后用一个字典 freq 来记录窗口内每种水果的数量。

接下来，我们不断地将 right 右移，同时更新 freq，直到窗口内包含了超过两种水果为止。

此时，我们更新最大收集数量的值，并将 left 右移，直到窗口内只包含两种水果为止。

重复上述过程，直到 right 到达数组末尾。

### 76. 最小覆盖子串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution76.java)

#### 思路

用两个指针 left 和 right 来表示窗口的左右边界，初始值都为 0。

用一个字典 need 来记录窗口内还需要的每个字符的数量。

初始时，need 中的每个字符的值都为 t 中该字符的数量。

然后，我们不断地将 right 右移，直到窗口内包含了 t 中的所有字符为止。

此时，我们可以更新最小子串的值，并将 left 右移，直到窗口不再包含 t 中的所有字符为止。

重复上述过程，直到 right 到达字符串 s 的末尾。

## 模拟行为

### 59.螺旋矩阵II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Solution59.java)

#### 思路

可以定义四个变量 left、right、top、bottom 分别表示当前需要填充的矩阵的左、右、上、下边界，初始值分别为 0、n-1、0、n-1。

然后我们使用一个循环来不断地填充矩阵，直到左右或上下边界交错为止。

**具体来说**，在每次循环中，我们首先从左到右填充上边界，然后从上到下填充右边界，接着从右到左填充下边界，最后从下到上填充左边界。

填充完四条边界之后，我们更新 left、right、top、bottom 的值，并判断是否还需要继续填充矩阵。

### 54.螺旋矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Solution54.java)

#### 思路

同上

### Offer29. 顺时针打印矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Offer29.java)

#### 思路

这个问题跟上一个问题类似，只不过需要把顺时针打印的数字依次存储在一个数组里面。具体思路可以分为四个步骤

1. 定义上下左右四个边界，初始化为矩阵的边界。
2. 按照顺时针顺序，将矩阵的数字依次存储到结果数组中。具体方法是先从左到右遍历上边界，然后从上到下遍历右边界，然后从右到左遍历下边界，最后从下到上遍历左边界。
3. 每遍历完一条边界后，需要把相应的边界向内缩进一个单位，以便继续遍历下一条边界。
4. 当所有数字都被遍历过后，返回结果数组即可。

# 链表

## 设计链表

### 707.设计链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/base/Solution707.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution203.java)

#### 思路

从头节点开始，遍历链表，删除所有值等于 val 的节点。

需要用两个指针，一个指针 prev 指向当前节点的前一个节点，另一个指针 cur 指向当前节点。

如果当前节点的值等于 val，则需要删除该节点，将 prev 的 next 指针指向 cur 的 next 指针，否则更新 prev 和 cur 指针。

特别地，需要先处理头节点的值等于 val 的情况。

### 24. 两两交换链表中的节点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution24.java)

#### 思路

将链表分成两个节点为一组的小链表，对每一组进行交换。如果链表中节点数量为奇数，最后一个节点不用进行交换。如果链表为空或者只有一个节点，则直接返回该链表。

具体实现时，我们用变量 `first` 记录每一组的第一个节点，变量 `second` 记录每一组的第二个节点。我们对 `first` 和 `second` 进行交换，并将第二个节点的 `next` 指针指向递归处理后的子链表的头节点。最后，返回交换后的链表头节点。

### 19. 删除链表的倒数第 N 个结点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution19.java)

#### 思路

首先将快指针向前移动 n 步。然后将慢指针和快指针同时移动，直到快指针到达链表的末尾。

此时，慢指针就指向了倒数第 n 个结点的前一个结点。我们可以通过修改慢指针的 next 指针来删除倒数第 n 个结点。

需要注意的是，如果要删除的结点是链表的头结点，需要特殊处理。

## 链表相交

### 160.相交链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/intersection/Solution160.java)

#### 思路

设链表 A 长度为 a，链表 B 长度为 b，两个链表的相交部分长度为 c，则有以下结论

两个指针分别从链表 A 和链表 B 的头节点出发，一起向后遍历。

当其中一个指针走到链表尾部时，将其指向另一个链表的头部，继续向后遍历。

当两个指针相遇时，就是相交节点。

**证明如下**

指针 A 走过的距离为 a + c + b，指针 B 走过的距离为 b + c + a。因为 a + c + b = b + c + a，所以当两个指针相遇时，一定是在相交节点。

如果两个链表不相交，则在走过 a + b 的距离后，两个指针会同时指向 null，退出循环。

## 环形链表

### 142. 环形链表 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/circle/Solution142.java)

#### 思路

首先设定两个指针 slow 和 fast，初始时指向链表的头节点。然后让 slow 指针每次前进一步，fast 指针每次前进两步。如果链表中存在环，那么 fast 指针最终一定会追上 slow 指针。具体证明可以参考题目描述中的这个例子

我们使用前面的例子，并在 c3 处连接链表和链表尾部来创建一个带环的链表。pos=1 表示尾部连接到索引为 1 的位置。

在此带环链表中，从 head 开始走到 c1，需要经过 1 次走到 c2，再经过 2 次走到 c3，再经过 2 次回到 c2。在这个过程中，slow 指针走过的节点数为 1+1=2，fast 指针走过的节点数为 1+2+2=5。这是因为在进入环之前，fast 指针的步长始终是 slow 指针的两倍。而一旦进入环之后，两者步长差就会缩小 1，因为每前进 1 次，它们之间的距离就会减小 1，最终追上的时间取决于两者之间的距离差。

假设 slow 指针从 head 节点到环的起点的距离为 x，环的起点到 fast 指针追上 slow 指针的点的距离为 y，slow 指针在环中走了 z 步。那么可以得到以下等式

​																										$2(x+z) = x+z+ny$

其中 n 表示 fast 指针在环中绕了 n 圈。根据等式可以得到 x+z=n(y-z)，也就是说从 head 节点到环的起点的距离加上 z 步恰好等于 n 圈环的长度。因此，当发现 slow 和 fast 相遇时，再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。

具体实现可以分为两个步骤

1. 判断是否有环，并找到相遇点（快慢指针）
2. 找到环的起点（使用一个新指针从链表头部开始遍历，同时从相遇点开始遍历，直到两个指针相遇）

# 哈希表

## 数组作为哈希表

### 242. 有效的字母异位词

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/array/Solution242.java)

#### 思路

先使用哈希表记录字符串 s 中每个字符出现的次数，然后再遍历字符串 t，对于每个字符，将其在哈希表中对应的次数减一。

如果哈希表中某个字符的次数小于 0，说明 t 包含一个不在 s 中的额外字符，不是 s 的字母异位词。

如果遍历完 t 后哈希表中所有字符的次数都大于等于 0，说明 t 是 s 的字母异位词。

### 383.  赎金信

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/array/Solution383.java)

#### 思路

先统计 magazine 中每个字符出现的次数，然后遍历 ransomNote 中的字符，检查其在 magazine 中出现的次数是否大于等于 ransomNote 中出现的次数。

**具体地**，可以用一个长度为 26 的数组来记录 magazine 中每个字符出现的次数。遍历 magazine 中的每个字符，将其对应的计数器加 1。然后遍历 ransomNote 中的每个字符，将其对应的计数器减 1，如果计数器小于 0，说明 magazine 中没有足够的字符来构成 ransomNote，返回 false。

### 49. 字母异位词分组

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/array/Solution49.java)

#### 思路

将每个单词按照字母顺序排序后作为键存储在哈希表中，值为所有字母顺序相同的单词的列表。

具体来说，对于每个单词，将其按照字母顺序排序后作为键，如果该键在哈希表中不存在，则将该键加入哈希表，并将该单词加入值为一个空列表的键所对应的值中。如果该键已经存在，则将该单词加入该键所对应的值中。最后，将所有值非空的键所对应的值加入结果列表中即可。

#### 438. 找到字符串中所有字母异位词

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/array/Solution438.java)

#### 思路

具体来说，可以先用一个哈希表来记录模式串中每个字符出现的次数，然后用两个指针 left 和 right 表示滑动窗口的左右端点。一开始，两个指针都指向 s 的起始位置。然后，不断地增加 right 指针扩大窗口，直到窗口大小等于 p 的长度为止。在扩大窗口的过程中，每当窗口内的字符满足条件（即窗口内的字符出现次数等于模式串中的字符出现次数）时，就将窗口的左端点作为一个答案加入结果集。接下来，移动左指针并缩小窗口，直到窗口内的字符不再满足条件为止，然后再增加 right 指针扩大窗口，如此往复直到 right 指针到达 s 的末尾。

具体实现时，可以用两个数组来记录当前窗口内每个字符出现的次数，一个是 window，用于记录当前窗口内的字符出现次数，另一个是 needs，用于记录模式串中的字符出现次数。每次增加 right 指针扩大窗口时，更新 window 数组；每次移动 left 指针并缩小窗口时，同样要更新 window 数组。需要注意的是，当窗口大小超过 p 的长度时，需要移动 left 指针并缩小窗口。

最终，将所有的答案返回即可。

## set作为哈希表

### 349. 两个数组的交集

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/set/Solution349.java)

#### 思路

首先，我们将一个数组中的元素添加到哈希表中，然后遍历另一个数组，检查它们是否在哈希表中出现过，如果出现过，就加入到结果集合中。

### 350. 两个数组的交集 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/set/Solution350.java)

#### 思路

首先遍历 nums1，将每个数字出现的次数记录在哈希表中。然后遍历 nums2，对于每个数字，如果它在哈希表中出现过，就将它加入答案，并将哈希表中的计数减 1。

具体步骤如下

1. 遍历 nums1，将每个数字及其出现次数记录在哈希表中。
2. 遍历 nums2，对于每个数字，如果它在哈希表中出现过，就将它加入答案，并将哈希表中的计数减 1。
3. 返回答案数组。

#### 202. 快乐数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/set/Solution202.java)

#### 思路

首先定义一个Set集合用于存储每次计算的结果，用于判断是否进入了循环。

然后使用getNext方法，计算n每个位置上的数字的平方和，得到下一个数。

如果下一个数等于1，说明n是快乐数，直接返回true。

如果下一个数已经在Set集合中出现过，说明进入了循环，直接返回false。

如果都不是，则将下一个数加入Set集合中，并将下一个数作为新的n继续计算。

## map作为哈希表

### 1. 两数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/map/Solution1.java)

#### 思路

遍历一遍数组，对于每个数，判断它的差值（即 target - nums[i]）是否在哈希表中出现过，如果出现过，说明找到了这两个数，直接返回它们的下标即可。如果没有找到，就将这个数存入哈希表中，继续遍历下一个数。

### 454. 四数相加II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/map/Solution454.java)

#### 思路

先遍历 `nums1` 和 `nums2`，将两个数组中所有数的和及其出现的次数存储在哈希表 `sums` 中。然后遍历 `nums3` 和 `nums4`，对于每一对数，如果它们的相反数在 `sums` 中出现过，就将 `sums` 中该数的出现次数累加到答案中。最后返回答案即可。

## 双指针

### 15. 三数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/doublepointer/Solution15.java)

#### 思路

首先将数组排序，然后枚举第一个数，使用双指针在剩余的数中寻找符合条件的另外两个数。

具体来说，我们先将给定的数组排序，然后从小到大枚举第一个数，再使用双指针枚举剩下两个数，指针初始位置分别为第一个数的右侧和数组末尾。

如果三个数的和等于 0，则将这三个数添加到答案中。如果三个数的和小于 0，则将左侧指针右移一位。如果三个数的和大于 0，则将右侧指针左移一位。当枚举完成后，返回得到的答案即可。

### 18.四数之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Map/src/main/java/com/xin/doublepointer/Solution18.java)

#### 思路

可以将四数之和转化为三数之和的问题，具体步骤如下

1. 对原数组排序。
2. 确定第一个数的位置 i，从 0 开始遍历到 n-4。
3. 对第一个数之后的数组 nums[i+1..n-1] 执行三数之和，目标值为 target - nums[i]。
4. 如果三数之和的解为 [nums[i], nums[j], nums[k]]，则将该解添加到结果中。
5. 注意去重，避免出现重复的解。

# 字符串

## 双指针

### 344.反转字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/doublepointer/Solution344.java)

#### 思路

1. 定义两个指针left和right，分别指向字符串s的起始和末尾位置；
2. 当left小于right时，交换s[left]和s[right]；
3. left加1，right减1，重复步骤2，直到left>=right。

### 541.反转字符串II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/doublepointer/Solution541.java)

#### 思路

从字符串开头开始，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

具体来说，可以使用一个循环，每次处理 2k 个字符。对于每个 2k 长度的子串，我们先反转前 k 个字符，然后判断剩余字符的数量，若不足 k 个，则将剩余字符全部反转，否则只反转前 k 个字符。循环处理直至处理完整个字符串。

### 剑指Offer 05.替换空格

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/doublepointer/Offer05.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/reverse/Solution151.java)

#### 思路

可以先将字符串去除前导和尾随空格，然后按照空格分割成单词数组，最后将单词数组倒序拼接即可。

### 剑指 Offer 58 - II. 左旋转字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/reverse/Offer58II.java)

#### 思路

可以先将原字符串分为两部分，即要左旋转的部分和剩余部分，然后分别翻转这两部分，最后再将整个字符串翻转一次即可。具体步骤如下

1. 将字符串 s 分为两部分，即要左旋转的部分和剩余部分，分别为 s1 和 s2。s1 包含前 n 个字符，s2 包含剩余字符，即 s1 = s[0:n]，s2 = s[n:len(s)]。
2. 翻转字符串 s1 和 s2，得到 s1' 和 s2'。翻转字符串的方法可以使用双指针，从两端往中间移动，依次交换字符。
3. 将 s1' 和 s2' 拼接成新的字符串 s'，即 s' = s1' + s2'。
4. 翻转字符串 s'，得到最终结果。

## KMP

### 28.找出字符串中第一个匹配项的下标

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/kmp/Solution28.java)

#### 思路

1. 首先判断特殊情况，如果 `needle` 为空字符串，则返回 0。
2. 对于 `haystack` 中的每个字符，从当前位置开始，与 `needle` 中的字符逐一比较。
3. 如果 `needle` 中的所有字符都匹配成功，则返回当前位置。如果 `haystack` 中的字符不足以与 `needle` 中的所有字符比较，则返回 -1。

### 459.重复的子字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/String/src/main/java/com/xin/kmp/Solution459.java)

#### 思路

如果一个字符串可以由一个子串重复多次构成，那么这个子串的长度一定是原字符串长度的因数，并且除了原字符串本身以外，这个子串在原字符串中不会出现。因此，我们可以枚举所有可能的子串长度，对于每个子串长度，判断它是否满足上述两个条件。

具体地，假设原字符串为s，长度为n，我们从小到大枚举i（i为子串长度），如果i是n的因数，那么我们将原字符串分割成 n/i 个长度为 i 的子串。如果这 n/i 个子串都相等，并且它们的值恰好为原字符串 s，那么我们就找到了符合要求的子串。

# 栈与队列

## 栈

### 栈在系统中的应用

#### 71. 简化路径

[代码链接](https://github.com/HappyAxin/Algorithm/tree/main/Algorithm/Stack_Queue/src/main/java/com/xin/stack/system)

##### 思路

遍历整个路径，遇到非斜杠字符则记录开始位置，遇到斜杠字符则记录结束位置，得到一个目录名。然后分类讨论

1. 如果目录名是 "."，则不做任何操作。
2. 如果目录名是 ".."，则将栈顶元素出栈（相当于返回上一级目录）。
3. 如果目录名是其他字符串，则将其入栈。

最后，将栈中的所有元素用斜杠拼接起来即可。

### 括号匹配问题

#### 20. 有效括号

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Stack_Queue/src/main/java/com/xin/stack/bracket/Solution20.java)

##### 思路

遍历字符串，对于每一个字符，如果是左括号，就把它压入栈中；如果是右括号，就弹出栈顶元素并判断是否匹配。如果不匹配，说明字符串无效；如果最后栈不为空，也说明字符串无效。

### 字符串去重问题

#### 1047.删除字符串中的所有相邻重复项

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Stack_Queue/src/main/java/com/xin/stack/deduplication/Solution1047.java)

##### 思路

遍历字符串，如果当前字符和栈顶元素相同，则弹出栈顶元素；否则将当前字符入栈。最终栈中剩余的字符即为答案。

### 逆波兰表达式问题

#### 150.逆波兰表达式求值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Stack_Queue/src/main/java/com/xin/stack/evalRPN/Solution150.java)

##### 思路

逆波兰表达式的求值可以使用栈来实现，具体过程如下

1. 从左到右扫描逆波兰表达式，遇到数字时，将其压入栈中；
2. 遇到运算符时，弹出栈顶的两个数字，进行相应的计算，然后将计算结果压入栈中；
3. 重复上述过程，直到表达式中所有的数字和运算符都被处理；
4. 最终栈中只剩下一个数字，即为表达式的值。

## 队列

### 滑动窗口最大值问题

#### 239.滑动窗口最大值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Stack_Queue/src/main/java/com/xin/quene/array/Solution239.java)

##### 思路

使用双端队列（deque）来实现。

deque 维护一个单调递减的队列，队列中存放的是元素在原数组中的下标。每当移动滑动窗口时，需要将队首元素出队（因为队首元素已经不在滑动窗口中），然后将新的元素依次从队尾入队，并将队列中比当前元素小的元素出队，保证队列的单调性。

在队列中，队首元素就是当前滑动窗口中的最大值，因为它是最早进入队列的，并且在队列中一直保持单调递减，因此它一定是最大的。

### 求前K个高频元素

#### 347.前k个高频元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Stack_Queue/src/main/java/com/xin/quene/priority/Solution347.java)

##### 思路

可以使用哈希表和桶排序结合的方法来解决此问题。具体步骤如下

1. 使用哈希表统计每个元素出现的频率，键为元素，值为出现次数。
2. 对哈希表中的元素按照出现次数进行桶排序，将出现次数相同的元素放在同一个桶中。
3. 遍历桶，按照出现次数从大到小取出前 k 个元素。

# 二叉树

## 遍历方式

### 递归遍历

#### 144.二叉树的前序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/recursion/Solution144.java)

##### 思路

在实现二叉树前序遍历的递归算法时，我们可以先访问根节点，然后递归访问左子树，最后递归访问右子树。具体实现步骤如下

1. 判断当前节点是否为空，如果为空则返回。
2. 访问当前节点的值。
3. 递归遍历左子树。
4. 递归遍历右子树。

#### 94.二叉树的中序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/recursion/Solution94.java)

##### 思路

1. 如果当前节点不为空，先遍历当前节点的左子树
2. 访问当前节点
3. 再遍历当前节点的右子树

递归实现时，先递归遍历左子树，再访问当前节点，最后递归遍历右子树。

#### 145.二叉树的后序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/recursion/Solution145.java)

##### 思路

1. 如果根节点为空，直接返回空列表。
2. 否则，先递归遍历左子树，将左子树的后序遍历结果存入结果列表中。
3. 然后递归遍历右子树，将右子树的后序遍历结果存入结果列表中。
4. 最后将根节点的值加入结果列表中。
5. 返回结果列表。

### 迭代遍历

#### 144.二叉树的前序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/iteration/Solution144.java)

##### 思路

在实现二叉树前序遍历的递归算法时，我们可以先访问根节点，然后递归访问左子树，最后递归访问右子树。具体实现步骤如下

1. 判断当前节点是否为空，如果为空则返回。
2. 访问当前节点的值。
3. 递归遍历左子树。
4. 递归遍历右子树。

#### 94.二叉树的中序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/iteration/Solution94.java)

##### 思路

1. 如果当前节点不为空，先遍历当前节点的左子树
2. 访问当前节点
3. 再遍历当前节点的右子树

递归实现时，先递归遍历左子树，再访问当前节点，最后递归遍历右子树。

#### 145.二叉树的后序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/iteration/Solution145.java)

##### 思路

1. 如果根节点为空，直接返回空列表。
2. 否则，先递归遍历左子树，将左子树的后序遍历结果存入结果列表中。
3. 然后递归遍历右子树，将右子树的后序遍历结果存入结果列表中。
4. 最后将根节点的值加入结果列表中。
5. 返回结果列表。

### 层序遍历

#### 102. 二叉树的层序遍历

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution102.java)

##### 思路

1. 定义一个队列，将根节点加入队列中。

2. 当队列不为空时，进行如下操作

	 a. 记录当前队列的长度 size。 

	 b. 依次取出队列中前 size 个节点，并将它们的值存入当前层的数组中。

	 c. 对于每个取出的节点，将其非空的左右子节点加入队列中。 

	 d. 将当前层的数组加入最终结果中。

3. 返回最终结果。

#### 107. 二叉树的层序遍历II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution107.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution199.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution637.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution429.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution515.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution116.java)

##### 思路

从根节点开始，逐层遍历二叉树。对于每一层，我们可以记录下一层的第一个节点，然后在遍历当前层时，将每个节点的 next 指针指向其在同层中的下一个节点，这可以通过队列的先进先出（FIFO）特性来实现。

#### 117. 填充每个节点的下一个右侧节点指针II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution117.java)

##### 思路

这道题目是上一题的扩展版，但是不再是完美二叉树。不同的是，由于这不再是一棵完美二叉树，我们需要在遍历每个节点时，将其左右子树中的节点添加到队列中，以确保其右侧节点的指针正确连接。

#### 104. 二叉树的最大深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution104.java)

##### 思路

使用 DFS，我们可以递归地遍历每个节点，并将深度作为参数传递。当遇到叶子节点时，返回当前深度。最终，我们将通过比较每个节点的深度来得到最大深度。

使用 BFS，我们可以通过遍历每一层来逐步增加深度。我们将根节点加入队列，然后不断遍历队列中的节点，将它们的子节点加入队列中。每当我们完成遍历当前层的所有节点时，我们会增加深度。重复这个过程，直到队列为空。最后得到的深度即为最大深度。

#### 111. 二叉树的最小深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/traversal/levelorder/Solution111.java)

##### 思路

要求二叉树的最小深度，需要考虑一些特殊情况

1. 当根节点为空时，返回深度为 0。
2. 当左子树为空时，最小深度为右子树的最小深度加 1。
3. 当右子树为空时，最小深度为左子树的最小深度加 1。
4. 当左右子树都不为空时，最小深度为左右子树最小深度的较小值加 1。

## 属性

### 101.对称二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution101.java)

#### 思路

对于一个二叉树，如果它的左子树和右子树轴对称，那么这棵二叉树是轴对称的。

具体实现时，编写一个递归函数 `isSymmetricHelper(TreeNode left, TreeNode right)` 来实现对称性的判断。该函数的作用是判断左子树 `left` 和右子树 `right` 是否轴对称。

判断方式是如果 `left` 和 `right` 都为空，返回 `true`；如果 `left` 和 `right` 中有且仅有一个为空，返回 `false`；如果 `left` 和 `right` 的节点值不相等，返回 `false`；否则，递归判断 `left` 的左子树和 `right` 的右子树是否轴对称，以及 `left` 的右子树和 `right` 的左子树是否轴对称，最终返回两个递归结果的逻辑与。

### 100.相同的树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution100.java)

#### 思路

- 如果两个节点都为 null，则说明此节点相同，返回 true。
- 如果两个节点中有一个为 null，则说明此节点不同，返回 false。
- 如果两个节点的值不同，则说明此节点不同，返回 false。
- 对于左右子树，递归调用函数判断是否相同，如果都相同，则说明整棵树相同，返回 true，否则返回 false。

### 572.另一个树的子树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution572.java)

#### 思路

编写一个函数 `isSameTree`，用来判断两棵树是否相同。然后我们可以遍历树 `root`，对于每个节点，都调用 `isSameTree` 判断其是否与 `subRoot` 相同。如果相同，返回 true；如果不同，分别在左右子树中继续查找。

其中，`isSameTree` 函数用来判断两棵树是否相同。递归的终止条件是，如果两棵树的节点都为 null，返回 true；如果两棵树中有且只有一棵树的节点为 null，返回 false；如果两个节点的值不同，返回 false。如果两个节点的值相同，递归比较它们的左右子树是否相同。

在 `isSubtree` 函数中，我们首先判断 `root` 是否为 null，如果是，返回 false；然后判断 `root` 是否与 `subRoot` 相同，如果是，返回 true；否则，在 `root` 的左右子树中分别继续查找。如果左右子树中存在一个包含 `subRoot` 的子树，返回 true；否则返回 false。

### 104.二叉树的最大深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution104.java)

#### 思路

使用 DFS，我们可以递归地遍历每个节点，并将深度作为参数传递。当遇到叶子节点时，返回当前深度。最终，我们将通过比较每个节点的深度来得到最大深度。

使用 BFS，我们可以通过遍历每一层来逐步增加深度。我们将根节点加入队列，然后不断遍历队列中的节点，将它们的子节点加入队列中。每当我们完成遍历当前层的所有节点时，我们会增加深度。重复这个过程，直到队列为空。最后得到的深度即为最大深度。

### 111.二叉树的最小深度

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution111.java)

#### 思路

要求二叉树的最小深度，需要考虑一些特殊情况

1. 当根节点为空时，返回深度为 0。
2. 当左子树为空时，最小深度为右子树的最小深度加 1。
3. 当右子树为空时，最小深度为左子树的最小深度加 1。
4. 当左右子树都不为空时，最小深度为左右子树最小深度的较小值加 1。

### 222.完全二叉树的节点个数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution222.java)

#### 思路

由于完全二叉树的性质，通过比较左右子树的高度来判断最后一层是否填满。如果左右子树的高度相同，则最后一层节点一定在右子树中；否则，最后一层节点一定在左子树中。因此，可以将问题转化为分别求解左右子树的节点个数。

具体来说，如果左子树的高度等于右子树的高度，则说明左子树是一棵满二叉树，其节点个数可以通过公式 $2^h - 1$ 计算得到，其中 h 是树的高度。此时，可以递归地处理右子树，并加上左子树的节点个数。

如果左子树的高度小于右子树的高度，则说明右子树是一棵满二叉树，其节点个数可以通过公式 $2^h - 1$ 计算得到。此时，可以递归地处理左子树，并加上右子树的节点个数。

最后，根节点的节点个数为左右子树节点个数之和加 1。

### 110.平衡二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution110.java)

#### 思路

对于每个节点，都计算其左右子树的高度差，如果高度差超过了1，就返回False，否则递归判断它的左右子树是否也满足高度平衡的条件。

### 257.二叉树的所有路径

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution257.java)

#### 思路

使用DFS（深度优先搜索）。

在递归过程中，我们先将当前节点的值加入路径中，然后判断当前节点是否为叶子节点，如果是，则将该路径加入结果集；否则，我们在路径中加入 "->" 符号，然后分别递归遍历当前节点的左右子树。需要注意的是，为了避免路径重复，我们在递归左右子树时要分别传入新的 StringBuilder 对象，而不是复用之前的 path 对象。

最后，在主函数中我们判断根节点是否为空，如果为空则直接返回空的结果集；否则，我们调用 dfs 函数，传入根节点、空的 StringBuilder 对象和结果集 res，并将返回的结果集返回即可。

### 404.左叶子之和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution404.java)

#### 思路

首先判断根节点是为空，如果是，则返回0；然后初始化左叶子节点的和为0；如果左子树不为空，则判断其是否为左叶子节点，如果是，则将其值加入到和中；如果不是，则递归遍历左子树。最后，递归遍历右子树并将其结果加入到和中，最后返回左叶子节点的和。

### 513.找树左下角的值

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution513.java)

#### 思路

可以使用 BFS 遍历二叉树，每次遍历完一层后，记录该层的最左边节点的值。最后返回最后一层的最左边节点的值。

### 112.路径总和

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution112.java)

#### 思路

从根节点开始，对于每个节点，我们先将目标值减去当前节点的值，然后递归地搜索其左右子树。如果当前节点是叶子节点，并且目标值等于当前节点的值，则说明存在一条根节点到叶子节点的路径，使得路径上所有节点值相加等于目标和。否则，如果当前节点不是叶子节点，则继续搜索其左右子树，直到找到叶子节点或搜索完整棵树为止。

### 700. 二叉搜索树中的搜索 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution700.java)

#### 思路

根据BST的性质，如果当前节点值小于val，则递归搜索右子树，如果当前节点值大于val，则递归搜索左子树，如果当前节点值等于val，则直接返回该节点即可。如果最终未找到节点，返回null。

### 98. 验证二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution98.java)

#### 思路

过递归判断每个节点是否满足二叉搜索树的定义。

具体来说，对于每个节点，需要判断其左子树的所有节点值都小于当前节点的值，右子树的所有节点值都大于当前节点的值，同时左子树和右子树都必须是二叉搜索树。

### 530.二叉搜索树的最小绝对差

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution530.java)

#### 思路

采用中序遍历的方式遍历二叉搜索树，这样得到的遍历结果就是按照从小到大的顺序排列的。然后再遍历一次这个数组，计算任意两个相邻元素之间的差值，找到其中最小的差值即可。

### 501.二叉搜索树中的众数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/attributes/Solution501.java)

#### 思路

通过中序遍历BST并用HashMap统计每个元素的出现次数，然后找出出现次数最多的元素，即为众数。

具体实现步骤如下

1. 定义一个HashMap来统计每个元素出现的次数。
2. 中序遍历BST，对于每个遍历到的节点，将其值加入到HashMap中，并将出现次数加1。
3. 遍历HashMap，找出出现次数最多的元素，将其加入到结果列表中。

## 修改与构造

### 226.翻转二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution226.java)

#### 思路

可以通过递归实现二叉树的翻转，具体做法是将左右子树分别递归地翻转，然后交换左右子树的位置。

如果当前节点为空，则直接返回null。否则，先递归翻转左子树和右子树，然后交换左右子树的位置，最后返回当前节点。

### 106.从中序与后序遍历序列构造二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution106.java)

#### 思路

后序遍历中，最后一个元素一定是根节点，根据根节点在中序遍历中的位置可以将中序遍历分为左子树和右子树两部分。接下来分别递归构建左子树和右子树，最后将左右子树连接到根节点上，构建完整的二叉树。

### 654.最大二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution654.java)

#### 思路

对于给定的数组 nums，我们首先找到其中的最大值，将其作为根节点，然后将数组分为左右两个部分，递归地构建左子树和右子树。每次递归时，传入数组的左右边界即可。当左边界大于右边界时，返回null即可结束递归。

### 617. 合并二叉树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution617.java)

#### 思路

递归地合并两棵二叉树。如果两个节点都不为 null，则合并它们的值，并继续递归合并它们的左右子树；如果其中一个节点为 null，则直接返回另一个节点。递归结束的条件是，两个节点都为 null。

### 701.二叉搜索树中的插入操作

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution701.java)

#### 思路

对于每个节点，如果要插入的值小于当前节点的值，则将其插入到左子树中；如果要插入的值大于当前节点的值，则将其插入到右子树中。递归插入后返回根节点即可。如果根节点为空，则直接将要插入的值作为根节点返回。由于插入后仍保持为二叉搜索树，因此返回任意一个有效结果即可。

### 450. 删除二叉搜索树中的节点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution450.java)

#### 思路

从根节点开始查找要删除的节点，如果当前节点的值等于要删除的值，则将其删除。删除节点时，需要考虑以下三种情况

1. 要删除的节点是叶子节点，直接删除即可。
2. 要删除的节点只有一个子节点，将其子节点替代要删除的节点即可。
3. 要删除的节点有两个子节点，需要找到其右子树的最小节点，将其值替换到要删除的节点上，并删除右子树中的最小节点。

### 669.修剪二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution669.java)

#### 思路

由于二叉搜索树的性质，当当前节点的值小于low时，我们需要将其右子树保留，去修剪左子树；当当前节点的值大于high时，我们需要将其左子树保留，去修剪右子树；当当前节点的值在[low, high]范围内时，我们需要同时修剪左子树和右子树。

具体实现方法如下

1. 如果根节点为空，则返回空。
2. 对左子树进行递归修剪，并将修剪后的结果作为当前节点的新左子节点。
3. 对右子树进行递归修剪，并将修剪后的结果作为当前节点的新右子节点。
4. 比较当前节点的值与low和high的大小，如果当前节点的值小于low，则返回其右子节点，如果当前节点的值大于high，则返回其左子节点，否则返回当前节点。

### 108. 将有序数组转换为二叉搜索树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution108.java)

#### 思路

使用递归的方式将一个有序数组转换为一棵高度平衡的二叉搜索树。每次选取数组的中间元素作为根节点，左半部分作为左子树，右半部分作为右子树，然后递归构建左右子树。

### 538. 把二叉搜索树转换为累加树

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/modificationAndConstruction/Solution538.java)

#### 思路

使用反向中序遍历（从右到左）二叉搜索树的方式实现。具体来说，对于二叉搜索树中的一个节点，我们可以通过反向中序遍历先访问右子树，再累加到当前节点，最后访问左子树。

具体实现步骤如下

1. 定义一个全局变量sum，用于累加遍历到的节点值之和，初始化为0。
2. 从根节点开始，进行反向中序遍历。如果当前节点为空，直接返回。
3. 对当前节点的右子树进行递归操作。
4. 更新当前节点的节点值为sum加上当前节点的节点值，更新sum为新的节点值。
5. 对当前节点的左子树进行递归操作。
6. 遍历完成后，返回根节点。

## 公共祖先问题

### 236. 二叉树的最近公共祖先

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/ancestor/Solution236.java)

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

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/BinaryTree/src/main/java/com/xin/ancestor/Solution235.java)

#### 思路

在二叉搜索树中，如果节点`p`和`q`分别位于当前节点的左子树和右子树中，那么当前节点就是它们的最近公共祖先，如果它们都在当前节点的左子树中，则递归左子树查找，如果它们都在右子树中，则递归右子树查找。因为二叉搜索树的特性，如果当前节点的值比`p`和`q`都大，那么它们肯定都在左子树中，如果比它们都小，那么它们肯定都在右子树中。

其中，`root`为当前节点，`p`和`q`是需要查找的节点。首先判断当前节点是否为null或者是p或者q中的一个，如果是，直接返回当前节点。如果当前节点的值比`p`和`q`都大，那么递归左子树，否则递归右子树。
