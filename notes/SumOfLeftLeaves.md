# Sum Of Left Leaves
[原题](https://leetcode.com/problems/sum-of-left-leaves/description/)

这道题可以很容易的使用递归的思路解决，在写的过程中，我使用了list保存在遍历过程中的左子树，左子树一定是左边过来的，所以可以通过一个boolean变量判断。

然后如果是子树的话，再对这个树进行收割，增加到sum中去。

其实可以不用使用list保存所有的左子树的数值，因为每次都会使用sum在遍历中作为一个参数去尝试相加。

## Better Solution
````
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        if (!root) return 0;
        if (root->left && !root->left->left && !root->left->right) {
            return root->left->val + sumOfLeftLeaves(root->right);
        }
        return sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
    }
};
````
