# Merge intervals

这个题很难的地方是如果在合并之后的节点依然是连续的话，还要继续合并,直到没有连续为止， 这样的话需要反复插入删除才可以，但是Java 中的ArrayList 不方便反复插入删除。 所以可以通过扫描的方式创建一个Interval 的copy然后加入list
