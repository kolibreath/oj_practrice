//
// Created by kolibreath on 18-5-1.
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
using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(head==NULL){
            return NULL;
        }
        ListNode *list = new  ListNode(0);
        list = head;
        int start = 0;
        while(list!=NULL&&list->next!=NULL){
            int temp = list->val;
            list->val = list->next->val;
            list->next->val= temp;
            list = list->next->next;
        }
        return head;
    }
};

int main(){
    Solution so;
    ListNode *list = new ListNode(1);
//    ListNode *list1 = new ListNode(2);
//    ListNode *list2 = new ListNode(3);
//    ListNode *list3 = new ListNode(4);
//    ListNode *list4 = new ListNode(0);
//
//    list->next = list1;
//    list1->next = list2;
//    list2->next = list3;

    cout<<so.swapPairs(list)->val
            ;
    return 0;
}