package BasicDataStructure.Tree.BSTOperation;

import BasicDataStructure.Tree.TreeNode;

public class LargestSmallerThanTarget {
    public int largestSmaller(TreeNode root, int target) {
        // Write your solution here
        int largest = Integer.MIN_VALUE;
        while(root != null){
            if(root.key < target){
                if(root.key > largest){
                    largest = root.key;
                    root = root.right;
                }
            }else{
                root = root.left;
            }
        }
        return largest;
    }
}
