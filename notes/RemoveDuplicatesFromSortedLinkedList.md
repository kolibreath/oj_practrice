# Remove Duplicates from Sorted Linked list

如果是直接使用iterative解法来解决这个问题的话感觉很困难 特别是 对于选择哪一个是下面的节点很有难度。
我发现了这个很棒的递归的解法：

这个解法的优点在于不会找到最后一个才返回，而是到倒数第二个 然后返回的值直接和上面的一个node相连接。

```
class Solution {
        public ListNode deleteDuplicates(ListNode real) {
            if(real == null || real.next == null)
                return real;
            real.next = deleteDuplicates(real.next);
            return real.val == real.next.val ? real.next : real;
        }
    }
```

所以也get到了一个寻找linkedlist 最后一个节点的方法：
可以通过递归解决 但是这样在java 中对于大的链表的话可能会stackoverflow
