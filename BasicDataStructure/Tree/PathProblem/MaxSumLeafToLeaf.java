package BasicDataStructure.Tree.PathProblem;

import BasicDataStructure.Tree.TreeNode;

public class MaxSumLeafToLeaf {
    //step 1：左边直上直下path的最大值，右边直上直下path的最大值
    //step 2：left + right + root 更新 globalMax (必须左右都非空时！！！)
    //step 3: 返回给parent： Math.max(left, right) + root
    public int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int[] max = new int[1];
        max[0] = Integer.MAX_VALUE;
        helper(root, max);
        return max[0];
    }

    //一定要有返回值，要返回给parent
    private int helper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        //step 1: find max sum in left and right subtree
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        //step 2: find the max sum passing through root
        int cur = left + right + root.key;
        //update result only when needed
        if(max[0] < cur && (root.left != null && root.right != null)){
            max[0] = cur;

        }

        //step 3: return the max (root to leaf path) cost
        if(root.left == null){
            return right + root.key;
        }else if(root.right == null){
            return left + root.key;
        }

        return Math.max(left, right) + root.key;
    }
}
