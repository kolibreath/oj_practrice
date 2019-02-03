# Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

```

这道题需要你写出两个list相加的结果,可以使用非常naive的方法，直接使用观察两个式子，如果A的长度小于B，这样就在B后面几位相加的时候加上0.

```
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var carry = 0
            var p1: ListNode?  = l1
            var p2: ListNode? = l2


            val head = ListNode(0)
            var headPointer :ListNode? = head

            while(p1!=null && p2!= null){
                val sum = p1.`val` + p2.`val` + carry
                carry = sum / 10
                headPointer?.`val` = sum % 10

                p1 = p1.next
                p2 = p2.next
                if(p1 != null && p2 != null){
                    headPointer!!.next = ListNode(0)
                    headPointer = headPointer.next!!
                }
            }

            while (p1!=null){
                val sum =  0 + p1.`val` + carry
                carry = sum / 10

                headPointer?.next = ListNode(0)
                headPointer = headPointer?.next
                headPointer?.`val` = sum % 10


                p1 = p1.next
            }

            while(p2!=null){
                val sum =  0 + p2.`val` + carry
                carry = sum / 10

                headPointer?.next = ListNode(0)
                headPointer = headPointer?.next
                headPointer?.`val` = sum % 10


                p2 = p2.next
            }

            return if(carry == 1){
                headPointer?.next= ListNode(carry)
                head
            }else{
                head
            }
        }
```

第二种方法思路源于这里：

[optimal solution](https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what)
```
 fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
            var c1:ListNode? = l1
            var c2:ListNode? = l2

            var sum = 0
            var node    :ListNode?    = ListNode(-1)
            var pointer :ListNode? = node
            while(c1!= null || c2!=null){
                sum /= 10
                if(c1!=null){
                    sum += c1.`val`
                    c1 = c1.next
                }
                if(c2!= null){
                    sum += c2.`val`
                    c2 = c2.next
                }
                pointer?.next = ListNode(sum)
                pointer = pointer?.next
            }

            return if(sum / 10 == 1){
                pointer?.next = ListNode(1)
                node?.next
            }else{
                node?.next
            }
        }
    }
```
