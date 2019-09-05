package BasicDataStructure.Tree;

import java.util.List;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public List<TreeNode> children;
    public TreeNode(int key) {
      this.key = key;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("root="+this.key);

        if(this.left != null){
            sb.append("\n");
            sb.append(this.toStringHelper(1, this.left, "left ="));
        }

        if(this.right !=null) {
            sb.append("\n");
            sb.append(this.toStringHelper(1, this.right, "right="));
        }

        return sb.toString();
    }

    private String toStringHelper(int ident, TreeNode node, String prefix) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ident; i++) {
            sb.append("\t");
        }
        sb.append(prefix);
        sb.append(node.key);
        if(node.left != null){
            sb.append("\n");
            sb.append(this.toStringHelper(ident+1, node.left, "left ="));
        }

        if(node.right != null) {
            sb.append("\n");
            sb.append(this.toStringHelper(ident+1, node.right, "right="));
        }

        return sb.toString();
    }
}
