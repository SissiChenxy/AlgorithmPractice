package BasicDataStructure.Tree.LowestCommonAncestor;

import BasicDataStructure.Tree.TreeNode;

import java.util.Set;

public class LCALeftRight {

    //two nodes in binary tree
    public TreeNode lca(TreeNode root, int p, int q){
        if(root == null || root.key == p || root.key == q){
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left == null && right == null){
            return null;
        }
        return left == null ? right : left;
    }

    //two nodes in bst
    public TreeNode lca2(TreeNode root, int p, int q) {
        // Write your solution here
        if(root == null || root.key == p || root.key == q){
            return root;
        }
        if(p > root.key && q > root.key){
            return lca2(root.right, p, q);
        }else if(p < root.key && q < root.key){
            return lca2(root.left, p, q);
        }
        return root;
    }

    //k nodes in binary tree
    public TreeNode lca3(TreeNode root, Set<TreeNode> set){
        if(root == null || set.contains(root)){
            return root;
        }
        TreeNode left = lca3(root.left, set);
        TreeNode right = lca3(root.right, set);
        if(left != null && right != null){
            return root;
        }
        if(left == null && right == null){
            return null;
        }
        return left == null ? right : left;
    }

    //two nodes in k-nary tree, use temp
    public TreeNode lca4(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null || root == a || root == b){
            return root;
        }

        TreeNode temp = null;
        for(TreeNode child : root.children){
            TreeNode result = lca4(child, a, b);
            if(result == null){
                if(temp == null){
                    temp = result;
                }else{
                    return root;
                }
            }
        }
        return temp;
    }

    //n nodes in k-nary tree, use count
    public TreeNode lca5(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null || root == a || root == b){
            return root;
        }

        TreeNode temp = null;
        int count = 0;
        for(TreeNode child : root.children){
            TreeNode result = lca4(child, a, b);
            if(result != null){
                count++;
                if(count > 1){
                    return root;
                }
                temp = result;
            }
        }
        return temp;
    }


}
