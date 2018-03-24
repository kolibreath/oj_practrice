

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
#include <iostream>
using namespace std;
struct ListNode {
         int val;
         ListNode *next;
         ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2){
        ListNode *listNode = new ListNode(0);
        ListNode *copy ;
        copy = listNode;
        int c = 0;
        while(l1||l2){
            ListNode *node = new ListNode(0);
            int sum = l1->val + l2->val;
            node->val = sum%10 +c ;
            if(sum>=10){
                c = 1;
            }else{
                c = 0;
            }
            listNode->next = node;
            listNode = listNode->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        copy = copy->next;
        if(c==1){
            ListNode* emptyNode = new ListNode(0);
            emptyNode->val = c;
            listNode->next = emptyNode;
        }
        return copy->next;
    }

};

int main(){

    return 0;
}