package BasicDataStructure.Tree.LowestCommonAncestor;

import BasicDataStructure.Tree.TreeNode;

public class CousinNodes {
    public boolean cousinNodes(TreeNode root, TreeNode a, TreeNode b){
        if(root == null){
            return false;
        }

        boolean[] result = new boolean[1];
        getLevel(root, a, b, result, 0);
        return result[0];
    }

    private int getLevel(TreeNode root, TreeNode a, TreeNode b, boolean[] result, int level){
        if(root == null){
            return -1;
        }

        if(root == a || root == b){
            return level;
        }

        int left = getLevel(root.left, a, b, result, level + 1);
        int right = getLevel(root.right, a, b, result, level + 1);
        if(left != -1 && right != -1){
            if(left == right && left - level > 1){
                result[0] = true;
            }else{
                return -1;
            }
        }
        return left == -1 ? right : left;
    }

    private TreeNode root;
    private TreeNode one;
    private TreeNode two;
    private TreeNode three;
    private TreeNode four;
    private TreeNode five;
    private TreeNode six;

    public CousinNodes(){
        root = new TreeNode(6);
        one = new TreeNode(3);
        two = new TreeNode(5);
        three = new TreeNode(7);
        four = new TreeNode(8);
        five = new TreeNode(1);
        six = new TreeNode(2);
        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
    }



    public void test1(){
        System.out.println(cousinNodes(root, three, five));
    }

    public void test2(){
        System.out.println(cousinNodes(root, one, two));
    }
}
