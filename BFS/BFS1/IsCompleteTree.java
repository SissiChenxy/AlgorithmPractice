package BFS.BFS1;

import BasicDataStructure.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    /*
    BFS1 按层扫描寻找null
    Data Structure: FIFO Queue
    Algorithm:
        1. initial state : Q = {root}
        2. Expand/Generate Rule:
            expand: dequeue
            generate:
                when flag is false, if the left child or the right child is null, set flag as true
                when flag is true, if the left child or the right child is not null, return false
        3. termination condition:
            Q is Empty
            return false
        4. dedup : no need for tree
     */

    public boolean isComplete(TreeNode root){
        boolean firstNull = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current.left == null){
                firstNull = true;
            }else if(firstNull){
                return false;
            }else{
                queue.offer(root.left);
            }

            if(current.right == null){
                firstNull = true;
            }else if(firstNull){
                return false;
            }else{
                queue.offer(root.right);
            }
        }
        return true;
    }

    //edge case: one node, return true
    public void test1(){
        TreeNode n1 = new TreeNode(1);
        System.out.println(isComplete(n1));
    }
}
