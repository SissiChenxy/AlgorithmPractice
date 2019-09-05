package BasicDataStructure.Tree.SeriaAndDeserialization;

import BasicDataStructure.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FlattenToLinkedList {
    /*
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    Given a binary tree, flatten it to a linked list in-place.

    data structure:
        stack
        prev, current
    algorithm:
        preorder traversal -- stack.offer(right), stack.offer(left)

     */
    public TreeNode flatten(TreeNode root) {
        // Write your solution here
        if(root == null) return null;

        TreeNode dummyHead = new TreeNode(0);
        TreeNode prev = dummyHead;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            prev.left = null;
            prev.right = cur;
            prev = cur;

            //preorder traversal decides that offer right child first and then left child
            if(cur.right != null){
                stack.offerFirst(cur.right);
            }

            if(cur.left != null){
                stack.offerFirst(cur.left);
            }
        }
        return dummyHead.right;
    }


    /*
    data structure:
        arraylist
    algorithm:
        preorder traversal -- recursion list.add(root), preorder(root.left), preorder(root.right)
     */
    public void flatten2(TreeNode root) {
        if(root == null) return;

        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        TreeNode prev = root;
        for(int i = 1; i < list.size(); i++){
            TreeNode current = list.get(i);
            prev.left = null;
            prev.right = current;
            prev = current;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }


}
