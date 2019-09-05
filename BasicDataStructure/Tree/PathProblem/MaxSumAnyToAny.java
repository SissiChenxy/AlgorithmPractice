package BasicDataStructure.Tree.PathProblem;

import BasicDataStructure.Tree.TreeNode;

public class MaxSumAnyToAny {

    //3部曲方法
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);
        int cur = Math.max(Math.max(left, right), 0) + root.key;
        max[0] = Math.max(max[0], cur);
        return cur;
    }

    //subarray sum方法：记录 the largest sum of a subarray that ends at current node
    public int maxPathSum2(TreeNode root){
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max, root.key);
        return max[0];
    }

    private void helper(TreeNode root, int[] max, int sum){
        if(root == null) return;

        //判断是继承还是另起炉灶(当前root的值)
        if(sum < 0){
            sum = root.key;
        }else{
            sum += root.key;
        }

        //再更新max[0]
        max[0] = Math.max(max[0], sum);

        //再preorder左，preorder右
        helper(root.left, max, sum);
        helper(root.right, max, sum);
    }
}
