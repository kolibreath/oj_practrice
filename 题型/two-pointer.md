# 双指针类型
- [intersection of two array](https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/26/)

求两个数组的交集，可以先通过排序之后双指针秒掉

- [move zero](https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/28/)

使用两个指针 一个指向0 另外一个指向非零的数字 然后交换这个指针指向的位置 秒掉i

- [is pandrome](https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/36/)

这个题有点坑 要忽略掉空格和一些除了字母数字之外的的符号，直接使用replace去除所有的空格和特殊符号除了要猜测出完整oj的特殊符号集合之外很复杂，所以直接使用 toLowerCase 先变成小写 然后双指针 如果不是字母或者数字就 lower++ 或者higher --。
<br>
如果全部是特殊符号的话和空字符串同样看待，直接return true


# slow fast 指针类型
使用这样的方法可以减少时间复杂度<br>

方法模版:
````
  while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
````

- [回文链表](https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/45/)

使用双指针slow fast 各自找到到中间的node 和 结尾的node，然后反转slow到结尾的部分<br>，使用一个开始的指针指向head，同时遍历反转过的链表reversed 和 从start 到中间的这一段链表，只要没有问题就return true 

