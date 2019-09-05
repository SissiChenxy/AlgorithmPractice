package BasicDataStructure.Tree.BSTOperation;

import BasicDataStructure.Tree.TreeNode;

public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        TreeNode smallest = null;
        int[] diff = new int[1];
        diff[0] = Integer.MAX_VALUE;
        closest(root, target, smallest, diff);
        return smallest.key;
    }

    private void closest(TreeNode root, int target, TreeNode smallest, int[] diff){
        if(root == null){
            return;
        }
        if(root.key == target){
            smallest.key = root.key;
            return;
        }

        int originalDiff = diff[0];
        diff[0] = Math.min(diff[0], Math.abs(target - root.key));
        if(diff[0] < originalDiff){
            smallest.key = root.key;
        }
        if(root.key < target){
            closest(root.right, target, smallest, diff);
        }else if(root.key > target){
            closest(root.left, target, smallest, diff);
        }
    }


    //更新int变量即可
    public int closest1(TreeNode root, int target) {
        // smallest 初始值不可以赋值为 null，null没有.key
        int closest = Integer.MAX_VALUE;
        while(root != null){
            if(root.key == target){
                closest = target;
            }else if(Math.abs(root.key - target) < Math.abs(closest - target)){
                closest = root.key;
            }

            if(root.key < target){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return closest;
    }
}
