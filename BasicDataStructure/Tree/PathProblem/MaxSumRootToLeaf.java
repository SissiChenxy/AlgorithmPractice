package BasicDataStructure.Tree.PathProblem;

import BasicDataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxSumRootToLeaf {

    //3部曲方法
    public int maxPathSumLeafToRoot1(TreeNode root) {
        // Write your solution here
        if(root == null){
            return 0;
        }
        int left = maxPathSumLeafToRoot1(root.left);
        int right = maxPathSumLeafToRoot1(root.right);
        return Math.max(left, right) + root.key;
    }

    //对树的形状做讨论
    public int maxPathSumLeafToRoot2(TreeNode root) {
        // Write your solution here
        if(root.left == null && root.right == null){
            return root.key;
        }
        if(root.left == null){
            return maxPathSumLeafToRoot2(root.right) + root.key;
        }
        if(root.right == null){
            return maxPathSumLeafToRoot2(root.left) + root.key;
        }
        return Math.max(maxPathSumLeafToRoot2(root.left), maxPathSumLeafToRoot2(root.right)) + root.key;
    }

    //pre-order traverse + list pathPrefix
    public int maxPathSumLeafToRoot3(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        List<Integer> pathPrefix = new ArrayList<>();
        helper1(root, pathPrefix, max);
        return max[0];
    }

    private void helper1(TreeNode root,List<Integer> pathPrefix, int[] max){
        if(root == null) return;

        if(root.left == null && root.right == null){
            int sum = 0;
            for(Integer in : pathPrefix){
                sum += in;
            }
            max[0] = Math.max(max[0], sum + root.key);
        }

        pathPrefix.add(root.key);
        helper1(root.left, pathPrefix, max);
        helper1(root.right, pathPrefix, max);
        pathPrefix.remove(pathPrefix.size() - 1);
    }


    //pre-order traverse + int prefixSum
    public int maxPathSumLeafToRoot4(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper2(root, 0, max);
        return max[0];
    }

    private void helper2(TreeNode root,int prefixSum, int[] max){
        if(root == null) return;
        if(root.left == null && root.right == null){
            max[0] = Math.max(max[0], prefixSum + root.key);
            return;
        }

        //go left
        helper2(root.left, prefixSum + root.key, max);
        //go right
        helper2(root.right, prefixSum + root.key, max);
    }
}
