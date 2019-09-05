package BasicDataStructure.Tree.PathProblem;

import BasicDataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSumTarget {

    //parse prefix-path
    public boolean exist1(TreeNode root, int target) {
        // Write your solution here
        if(root == null){
            return false;
        }
        List<Integer> path = new ArrayList<>();
        return exist(root, target, path);
    }

    private boolean exist(TreeNode root, int target, List<Integer> path){
        path.add(root.key);

        int current = 0;
        for(Integer i : path){
            current += i;
            if(current == target){
                return true;
            }
        }

        if(root.left != null && exist(root.left, target, path)){
            return true;
        }
        if(root.right != null && exist(root.right, target, path)){
            return true;
        }

        //clean up when return to the previous level
        path.remove(path.size() - 1);
        return false;
    }


    //parse all pathPrefixSum set
    public boolean exist2(TreeNode root, int target){
        Set<Integer> prefixSum = new HashSet<>();
        return helper(root, prefixSum, 0, target);
    }

    private boolean helper(TreeNode root, Set<Integer> prefixSum, int prevSum, int target){
        int cur = prevSum + root.key;
        if(cur == target || prefixSum.contains(cur - target)){
            return true;
        }

        boolean needRemove = prefixSum.add(cur);
        if(root.left != null && helper(root.left, prefixSum, cur, target)){
            return true;
        }
        if(root.right != null && helper(root.right, prefixSum, cur, target)){
            return true;
        }
        if(needRemove){
            prefixSum.remove(cur);
        }
        return false;
    }
}
