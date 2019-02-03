# Intersection of Two Linked Lists

[一个非常牛逼的解法：](https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!)

一般情况下要求两个链表的公共集合，需要知道两个链表的长度，如果通过两次遍历获取两个链表的长度之后，就能够调整两个pointer的指向的速度
之后遍历到相等的时候就可以、

但是下面的方法时间复杂度很低，两个指针一起向后遍历，如果A指针越界的话调整到B链表上去多运行一下，等到B越界，在回到A链表上。这样A指针在B链表上就会省略掉两个链表之间的公共距离

```
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
```
