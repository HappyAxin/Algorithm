# Algorithm

算法代码及笔记，刷题顺序是跟着[代码随想录](https://www.programmercarl.com/)来的

# 数组

## 二分查找

### 704. 二分查找

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution704.java)

#### 思路：

1. 令左指针 l = 0, 右指针 r = n-1。 

2. 当 l <= r 时，执行以下步骤：   

	a. 计算中间位置 mid = (l+r)/2。   

	b. 如果 nums[mid] == target，则返回 mid。   

	c. 如果 nums[mid] < target，则在 mid 右侧继续查找，令 l = mid+1。   

	d. 如果 nums[mid] > target，则在 mid 左侧继续查找，令 r = mid-1。 

3. 如果没有找到目标值，则返回 -1。

### 35. 搜索插入位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution35.java)

#### 思路：

1. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

2. 当左指针小于等于右指针时，进行循环：

	a. 计算中间位置 mid = (left + right) / 2。

	b. 如果目标值等于中间位置的值，则返回中间位置。

	c. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	d. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

3. 如果循环结束后还没有找到目标值，说明目标值不存在于数组中，需要返回它将会被按顺序插入的位置。此时，左指针指向的位置就是插入位置。

### 34. 在排序数组中查找元素的第一个和最后一个位置

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution34.java)

#### 思路：

1. 第一次二分查找找到目标值的左边界（第一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环：

	​	i. 计算中间位置 mid = (left + right) / 2。

	​	ii. 如果目标值小于等于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	​	iii. 如果目标值大于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	c. 如果找到了目标值，需要继续向左查找，直到找到左边界。

2. 第二次二分查找找到目标值的右边界（最后一次出现的位置）。

	a. 初始化左右指针，左指针指向数组的起始位置，右指针指向数组的末尾位置。

	b. 当左指针小于等于右指针时，进行循环：

	​	i. 计算中间位置 mid = (left + right) / 2。

	​	ii. 如果目标值大于等于中间位置的值，则在右半部分继续查找，将左指针更新为 mid + 1。

	​	iii. 如果目标值小于中间位置的值，则在左半部分继续查找，将右指针更新为 mid - 1。

	c. 如果找到了目标值，需要继续向右查找，直到找到右边界。

### 69. x 的平方根 

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution69.java)

#### 思路：

在区间 [0, x] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否小于等于 x。

如果小于等于 x，则将左指针移动到 mid + 1，否则将右指针移动到 mid - 1。

因为要求整数部分，所以最终返回右指针的值。

### 367. 有效的完全平方数

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/binarysearch/Solution367.java)

#### 思路：

在区间 [1, num] 上进行二分查找，每次找到中间位置 mid，并判断 mid 的平方是否等于 num。

如果等于 num，则返回 true，否则根据 mid 的平方与 num 的大小关系来调整左右边界，直到左右边界相遇时退出循环，并返回 false。

## 双指针

### 27. 移除元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution27.java)

#### 思路：

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。

当 nums[j] 等于给定值时，将 j 后移一位，直到找到一个不等于给定值的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i]，并将 i 和 j 同时后移一位。

这样就可以将所有等于给定值的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i 的值，即为新数组的长度。

### 26. 删除排序数组中的重复项

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution26.java)

#### 思路：

用两个指针 i 和 j 分别指向数组的开头，然后遍历数组。当 nums[j] 等于 nums[i] 时，将 j 后移一位，直到找到一个不等于 nums[i] 的元素 nums[j']，然后将 nums[j'] 赋值给 nums[i + 1]，并将 i 后移一位。

这样就可以将重复的元素移动到数组的末尾，同时保持其他元素的相对顺序不变。

最后返回 i + 1 的值，即为新数组的长度。

### 283. 移动零

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution283.java)

#### 思路：

一个指针 i 用来遍历数组，另一个指针 j 用来指向下一个非零元素应该放置的位置。

遍历数组时，如果当前元素不为 0，则将其放到 nums[j] 的位置上，并将 j 后移一位。遍历结束后，从 j 开始到数组末尾的位置都应该填上 0。

### 844. 比较含退格的字符串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution844.java)

#### 思路：

遍历字符串 s 和 t，遇到非退格字符时，将其压入栈中；遇到退格字符时，将栈顶元素弹出。

遍历结束后，比较两个栈是否相等即可。

### 977. 有序数组的平方

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/doublepointer/Solution977.java)

#### 思路：

用两个指针分别指向数组的左右两端，比较两个指针指向的数的绝对值大小，将较大的数的平方放入新数组的末尾。

然后将指针向中间移动，重复上述操作，直到两个指针相遇。

## 滑动窗口

### 209. 长度最小的子数组

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution209.java)

#### 思路：

定义两个指针 left 和 right，分别表示子数组的左右边界，初始值都为 0。

然后用一个变量 sum 来表示子数组中元素的和，初始值为 0。

接下来，我们不断地将 right 右移，同时将 nums[right] 加入 sum 中，直到 sum >= target。

此时，我们更新最短子数组的长度，并将 left 右移，同时将 nums[left] 从 sum 中减去，直到 sum < target。重复上述过程，直到 right 到达数组末尾。

### 904. 水果成篮

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution904.java)

#### 思路：

定义两个指针 left 和 right，分别表示窗口的左右边界，初始值都为 0。

然后用一个字典 freq 来记录窗口内每种水果的数量。

接下来，我们不断地将 right 右移，同时更新 freq，直到窗口内包含了超过两种水果为止。

此时，我们更新最大收集数量的值，并将 left 右移，直到窗口内只包含两种水果为止。

重复上述过程，直到 right 到达数组末尾。

### 76. 最小覆盖子串

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/slidingwindow/Solution76.java)

#### 思路：

用两个指针 left 和 right 来表示窗口的左右边界，初始值都为 0。

用一个字典 need 来记录窗口内还需要的每个字符的数量。

初始时，need 中的每个字符的值都为 t 中该字符的数量。

然后，我们不断地将 right 右移，直到窗口内包含了 t 中的所有字符为止。

此时，我们可以更新最小子串的值，并将 left 右移，直到窗口不再包含 t 中的所有字符为止。

重复上述过程，直到 right 到达字符串 s 的末尾。

## 模拟行为

### 59.螺旋矩阵II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Solution59.java)

#### 思路：

可以定义四个变量 left、right、top、bottom 分别表示当前需要填充的矩阵的左、右、上、下边界，初始值分别为 0、n-1、0、n-1。

然后我们使用一个循环来不断地填充矩阵，直到左右或上下边界交错为止。

**具体来说**，在每次循环中，我们首先从左到右填充上边界，然后从上到下填充右边界，接着从右到左填充下边界，最后从下到上填充左边界。

填充完四条边界之后，我们更新 left、right、top、bottom 的值，并判断是否还需要继续填充矩阵。

### 54.螺旋矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Solution54.java)

#### 思路：

同上

### Offer29. 顺时针打印矩阵

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/Array/src/main/java/com/xin/mockaction/Offer29.java)

#### 思路：

这个问题跟上一个问题类似，只不过需要把顺时针打印的数字依次存储在一个数组里面。具体思路可以分为四个步骤：

1. 定义上下左右四个边界，初始化为矩阵的边界。
2. 按照顺时针顺序，将矩阵的数字依次存储到结果数组中。具体方法是先从左到右遍历上边界，然后从上到下遍历右边界，然后从右到左遍历下边界，最后从下到上遍历左边界。
3. 每遍历完一条边界后，需要把相应的边界向内缩进一个单位，以便继续遍历下一条边界。
4. 当所有数字都被遍历过后，返回结果数组即可。

# 链表

## 设计链表

### 707.设计链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/base/Solution707.java)

#### 思路：

1. 定义链表节点类 ListNode，包括三个属性：val 表示节点值，next 表示指向下一个节点的指针/引用，prev 表示指向前一个节点的指针/引用（对于双向链表）。
2. 定义 MyLinkedList 类，包括两个属性：head 表示链表头节点，tail 表示链表尾节点（对于双向链表）。
3. 实现 MyLinkedList 类的构造函数 MyLinkedList()，将头节点 head 初始化为 null，尾节点 tail 初始化为 null（对于双向链表）。
4. 实现 MyLinkedList 类的 get(int index) 方法，遍历链表，查找下标为 index 的节点，并返回该节点的值。如果下标无效，则返回 -1。
5. 实现 MyLinkedList 类的 addAtHead(int val) 方法，在头节点之前插入一个新节点，将新节点的 next 指向头节点，并将头节点设置为新节点。
6. 实现 MyLinkedList 类的 addAtTail(int val) 方法，在尾节点之后插入一个新节点，将尾节点的 next 指向新节点，并将新节点设置为尾节点。
7. 实现 MyLinkedList 类的 addAtIndex(int index, int val) 方法，在下标为 index 的节点之前插入一个新节点。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
8. 实现 MyLinkedList 类的 deleteAtIndex(int index) 方法，删除下标为 index 的节点。如果下标无效，则不执行任何操作。

## 虚拟头节点

### 203. 移除链表元素

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution203.java)

#### 思路：

从头节点开始，遍历链表，删除所有值等于 val 的节点。

需要用两个指针，一个指针 prev 指向当前节点的前一个节点，另一个指针 cur 指向当前节点。

如果当前节点的值等于 val，则需要删除该节点，将 prev 的 next 指针指向 cur 的 next 指针，否则更新 prev 和 cur 指针。

特别地，需要先处理头节点的值等于 val 的情况。

### 24. 两两交换链表中的节点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution24.java)

#### 思路：

将链表分成两个节点为一组的小链表，对每一组进行交换。如果链表中节点数量为奇数，最后一个节点不用进行交换。如果链表为空或者只有一个节点，则直接返回该链表。

具体实现时，我们用变量 `first` 记录每一组的第一个节点，变量 `second` 记录每一组的第二个节点。我们对 `first` 和 `second` 进行交换，并将第二个节点的 `next` 指针指向递归处理后的子链表的头节点。最后，返回交换后的链表头节点。

### 19. 删除链表的倒数第 N 个结点

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/dummyhead/Solution19.java)

#### 思路：

首先将快指针向前移动 n 步。然后将慢指针和快指针同时移动，直到快指针到达链表的末尾。

此时，慢指针就指向了倒数第 n 个结点的前一个结点。我们可以通过修改慢指针的 next 指针来删除倒数第 n 个结点。

需要注意的是，如果要删除的结点是链表的头结点，需要特殊处理。

## 链表相交

### 160.相交链表

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/intersection/Solution160.java)

#### 思路：

设链表 A 长度为 a，链表 B 长度为 b，两个链表的相交部分长度为 c，则有以下结论：

两个指针分别从链表 A 和链表 B 的头节点出发，一起向后遍历。

当其中一个指针走到链表尾部时，将其指向另一个链表的头部，继续向后遍历。

当两个指针相遇时，就是相交节点。

**证明如下**：

指针 A 走过的距离为 a + c + b，指针 B 走过的距离为 b + c + a。因为 a + c + b = b + c + a，所以当两个指针相遇时，一定是在相交节点。

如果两个链表不相交，则在走过 a + b 的距离后，两个指针会同时指向 null，退出循环。

## 环形链表

### 142. 环形链表 II

[代码链接](https://github.com/HappyAxin/Algorithm/blob/main/Algorithm/LinkList/src/main/java/com/xin/circle/Solution142.java)

#### 思路：

首先设定两个指针 slow 和 fast，初始时指向链表的头节点。然后让 slow 指针每次前进一步，fast 指针每次前进两步。如果链表中存在环，那么 fast 指针最终一定会追上 slow 指针。具体证明可以参考题目描述中的这个例子：

我们使用前面的例子，并在 c3 处连接链表和链表尾部来创建一个带环的链表。pos=1 表示尾部连接到索引为 1 的位置。

在此带环链表中，从 head 开始走到 c1，需要经过 1 次走到 c2，再经过 2 次走到 c3，再经过 2 次回到 c2。在这个过程中，slow 指针走过的节点数为 1+1=2，fast 指针走过的节点数为 1+2+2=5。这是因为在进入环之前，fast 指针的步长始终是 slow 指针的两倍。而一旦进入环之后，两者步长差就会缩小 1，因为每前进 1 次，它们之间的距离就会减小 1，最终追上的时间取决于两者之间的距离差。

假设 slow 指针从 head 节点到环的起点的距离为 x，环的起点到 fast 指针追上 slow 指针的点的距离为 y，slow 指针在环中走了 z 步。那么可以得到以下等式：

​																										$2(x+z) = x+z+ny$

其中 n 表示 fast 指针在环中绕了 n 圈。根据等式可以得到 x+z=n(y-z)，也就是说从 head 节点到环的起点的距离加上 z 步恰好等于 n 圈环的长度。因此，当发现 slow 和 fast 相遇时，再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。

具体实现可以分为两个步骤：

1. 判断是否有环，并找到相遇点（快慢指针）
2. 找到环的起点（使用一个新指针从链表头部开始遍历，同时从相遇点开始遍历，直到两个指针相遇）
