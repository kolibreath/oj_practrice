# Flatten Binary Tree 2 Linkedlist

[原题](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

我的想法非常的naive 
将这个树先序遍历 然后防盗一个list中去 然后放在整个树的右侧，然后再断掉左边的节点
但是这样会有问题，leetcode貌似需要不让左边的节点还存在，需要置空才可以

但是有一个非常巧妙的递归解法
```

TreeNode pre = null;
public void traverse(TreeNode node){
    if(node == null)
        return;
    traverse(node.right);
    traverse(node.left);
    
    node.left = null;
    node.right = pre;
    
    pre = node;
}
```

可以说是非常巧妙了
