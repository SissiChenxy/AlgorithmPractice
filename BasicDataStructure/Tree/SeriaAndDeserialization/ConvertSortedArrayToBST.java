package BasicDataStructure.Tree.SeriaAndDeserialization;

import BasicDataStructure.Tree.TreeNode;

public class ConvertSortedArrayToBST {
    /*
    Given an array of sorted ints, convert it into a balanced BST. Return any result
    1,2,3,4,5,6
         3
     1       5
       2   4   6
    sorted array --- inorder traverse
    tree construction process -- decrease the range and findMid

    dfs --- logn levels, 2 branches
    Time = O(n)
    Space = O(logn)
     */
    public TreeNode convertSortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        return findMid(nums, 0, nums.length - 1);
    }

    private TreeNode findMid(int[] nums, int left, int right){
        if(left > right){
            return null;
        }

        if(left == right){
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = findMid(nums, left, mid - 1);
        node.right = findMid(nums, mid + 1, right);
        return node;
    }

    public void test(){
        int[] array = new int[]{1,2,3,4,5,6};
        convertSortedArrayToBST(array);
    }
}
