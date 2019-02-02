fun main(){

    val head1 = ListNode(-9)
    val head2 = ListNode(3)

    val head3 = ListNode(5)
    val head4 = ListNode(7)

    head1.next = head2

    head3.next = head4


    val remove = Merge2LinkedList.Solution()
    val head = remove.mergeTwoLists(head1,head3)

    var cur = head;
    while(cur!=null){
        println(cur.`val`)
        cur = cur.next
    }
}