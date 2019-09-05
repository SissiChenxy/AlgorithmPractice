package BasicDataStructure.Tree.SeriaAndDeserialization;

import BasicDataStructure.Tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReconstructBSTWithPostorder {
    public TreeNode reconstruct(int[] post) {
        // Write your solution here
        int[] in = Arrays.copyOf(post, post.length);
        Arrays.sort(in);
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            inMap.put(in[i], i);
        }

        return construct(inMap, in, 0, in.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(Map<Integer, Integer> inMap, int[] in, int inLeft, int inRight, int[] post, int postLeft, int postRight){
        if(postLeft > postRight){
            return null;
        }

        TreeNode root = new TreeNode(post[postRight]);
        int leftSize = inMap.get(root.key) - inLeft;
        //root.left = construct(inMap, in, inLeft, inLeft + leftSize - 1, post, postLeft, postLeft + leftSize - 1);
        root.right = construct(inMap, in, inLeft + leftSize + 1, inRight, post, postLeft + leftSize, postRight - 1);
        return root;
    }


    public TreeNode reconstruct2(int[] post) {
        int[] index = new int[] {post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    //用index[0] 维护一个pointer
    private TreeNode helper(int[] postOrder, int[] index, int min) {
        if(index[0] < 0 || postOrder[index[0]] <= min){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[index[0]--]);
        root.right = helper(postOrder, index, root.key);
        root.left = helper(postOrder, index, min);
        return root;
    }
}
