//
// Created by kolibreath on 18-4-25.
//





/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

#include <vector>
#include <iostream>
using namespace std;

struct ListNode {
        int val;
         ListNode *next;
         ListNode(int x) : val(x), next(NULL) {}
     };
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int n = lists.size();
        if (n == 0) return NULL;
        while (n) {
            int mid = (n + 1) / 2;
            for (int i = 0; i < n/2

                    ; i++) {
                lists[i] = mergeTwoLists(lists[0], lists[0 + mid]);
            }
            n = mid;
        }
        return lists[0];
    }


    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *dummy = new ListNode(-1), *cur = dummy;
       while (l1 && l2) {
            if (l1->val < l2->val) {
                cur->next = l1;
                l1 = l1->next;
            } else {
                cur->next = l2;
                l2 = l2->next;
            }
            cur = cur->next;
        }
        cur->next = l1 ? l1 : l2;
        return dummy->next;
    }
};

