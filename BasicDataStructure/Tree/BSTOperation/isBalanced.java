package BasicDataStructure.Tree.BSTOperation;

import BasicDataStructure.Tree.TreeNode;

public class isBalanced {
    /*
    Determine if a binary tree is balanced

    Brute force:
        for each node, check if the diff of subtree heights is no longer than 1
    Time = O(nlogn) worst case: O(n^2)
    isBalanced() 和 getHeight() 重复recursively call
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return false;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /*
    brute force has many duplicated computation
        save the result(each node's height) --- extra space cost

    return height if the subtree is balanced; else -1
        similar to DP's record -- only save one value
    Time = O(n)
    Space = O(logn)
     */
    public int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        //step 1: 各要一个返回值
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        //step 2：当前层操作
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        //step 3：返回给parent：谁高取谁 + 1
        return Math.max(left, right) + 1;
    }

}
