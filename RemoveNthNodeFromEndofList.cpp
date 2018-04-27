//
// Created by kolibreath on 18-4-23.
//




/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

#include <iostream>
#include <vector>
using namespace std;
//Definition for singly-linked list.
 struct ListNode {
         int val;
         ListNode *next;
         ListNode(int x) : val(x), next(NULL) {}
     };
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int total = 0;
        ListNode *headNode = head;
        while(headNode!= NULL){
            total ++;
            headNode = headNode->next;
        }
        if(total==0){
            return  NULL;
        }

        int fromStart = total - n;
        if(fromStart==0){
            return head->next;
        }
        ListNode *listNode = head;
        for(int i=0;i<fromStart-1;i++){
            listNode = listNode->next;
        }
        ListNode *nextTarget = listNode->next;
        listNode->next = nextTarget->next;

        return  head;
    }
};

int main(){
    Solution solution;
    ListNode *listNode = new ListNode(1);
    ListNode *listNode1 = new ListNode(2);
    listNode->next = listNode1;
    cout<<solution.removeNthFromEnd(listNode,2)->val;
    return 0;
}