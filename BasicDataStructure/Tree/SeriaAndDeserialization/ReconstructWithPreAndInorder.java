package BasicDataStructure.Tree.SeriaAndDeserialization;

import BasicDataStructure.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructWithPreAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        if(inOrder.length == 0 && preOrder.length == 0){
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            inOrderMap.put(inOrder[i], i);
        }
        return construct(inOrderMap, inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1);
    }

    private TreeNode construct(Map<Integer, Integer> inOrderMap, int[] inOrder, int inLeft, int inRight, int[] preOrder, int preLeft, int preRight){
        if(preLeft > preRight){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        int leftSize = inOrderMap.get(root.key) - inLeft;

        root.left = construct(inOrderMap, inOrder, inLeft, inLeft + leftSize - 1, preOrder, preLeft + 1, preLeft + leftSize);
        root.right = construct(inOrderMap, inOrder, inLeft + leftSize + 1, inRight, preOrder, preLeft + leftSize + 1, preRight);
        return root;
    }
}
