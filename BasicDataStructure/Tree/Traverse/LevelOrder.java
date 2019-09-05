package BasicDataStructure.Tree.Traverse;

import BasicDataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */

public class LevelOrder {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> curLayer = new ArrayList<Integer>();

            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                curLayer.add(node.key);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(curLayer);
        }
        return result;
    }
}
