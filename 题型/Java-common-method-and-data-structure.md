# Java 中常见的数据结构和算法

## A
- Arrays.sort
使用快速排序的方法排序数组
![](http://wx1.sinaimg.cn/large/d6225d36ly1fzt5ufnvgbj235s0os473.jpg)<br>
有多种3重载方法基本类型数组重载没有问题

## C
- Collections.sort
使用快速排序的方法排序各种Collections结构，如List Set等<br>
这个方法没有返回值<br>
![](http://wx1.sinaimg.cn/large/d6225d36ly1fzt5so0locj21n90u0nhh.jpg)


## List 系列 
> 注意需要使用``import``指令 ``import java.util.*;`` 
- LinkedList 

LinkedList既可以作为Queue也可以作为Stack ，其中实现了的poll()方法可以按照先进先出的原则取出队列中的元素
<br>
![](http://wx3.sinaimg.cn/large/d6225d36ly1fzt5imrm3zj21f80jugqb.jpg)
还有pop方法可以按照先进后出的方法取出Stack中的元素
<br>
![](http://wx2.sinaimg.cn/large/d6225d36ly1fzt5i6dzo6j21f80ju44f.jpg)
常见的使用LinkedList的情景<br>
    - BFS
    ```
    //指定泛型
    LinkedList queue = new LinkedList<TreeNode>();

    while(!queue.isEmpty()){
        int size = queue.size();
        TreeNode temp = queue.poll();
        int counter = 0;
        //这样的BFS可以遍历二叉树还可以遍历森林
        //完全按层遍历 
        while(counter < size){
            //需要进行左右节点的判空操作
            TreeNode left = temp.left;
            TreeNode right = temp.right;

            if(left!=null)
                queue.add(left);

            if(right != null)
                queue.add(right);

            counter ++;
        }
    }
    ```

