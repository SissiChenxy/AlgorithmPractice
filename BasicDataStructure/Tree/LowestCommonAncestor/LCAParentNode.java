package BasicDataStructure.Tree.LowestCommonAncestor;

import BasicDataStructure.Tree.TreeNode;

public class LCAParentNode {
    public TreeNode lca(TreeNode one, TreeNode two){
        int h1 = height(one);
        int h2 = height(two);
        if(h1 <= h2){
            return mergeNodes(one, two, h2 - h1);
        }else{
            return mergeNodes(one, two, h1 - h2);
        }
    }

    private int height(TreeNode node){
        int height = 0;
        while (node != null){
            height += 1;
            node = node.parent;
        }
        return height;
    }

    private TreeNode mergeNodes(TreeNode higher, TreeNode lower, int diff){
        while(diff > 0){
            lower = lower.parent;
            diff--;
        }

        while(higher != lower){
            higher = higher.parent;
            lower = lower.parent;
        }
        return lower;
    }
}
