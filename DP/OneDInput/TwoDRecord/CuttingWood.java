package DP.OneDInput.TwoDRecord;

import java.util.Arrays;

public class CuttingWood {
    /*
    There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A.
    The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut.
    Determine the minimum total cost to cut the stick into the defined pieces.
    L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)

    data structure:
        M[i][j] -- represents the minimum costs for cutting A[i...j]
        helper[i] -- represents the cutting position of the A
            helper = {0, 2, 4, 7, 10}
             index =  0  1  2  3  4
    algorithm:
        base case:
            size == 1  M[0][1] = M[1][2] = M[2][3] = M[3][4] = 0
        induction rule:
            size == 2 [left = i, right = i + 2]
                M[0][2] _ _|_ _  1 method
                    = helper[2] - helper[0] + M[0][1] + M[1][2]
                M[1][3] _ _|_ _ _  1 method
                    = helper[3] - helper[1] + M[1][2] + M[2][3]
                M[2][4] _ _ _|_ _ _  1 method
                    = helper[4] - helper[2] + M[2][3] + M[3][4]
            size == 3 [left = i, right = i + 3]
                M[0][3] _ _|_ _|_ _ _ 2 methods
                min = helper[3] - helper[0] + M[0][1] + M[1][3]
                    = helper[3] - helper[0] + M[0][2] + M[2][3]
                M[1][4]
       Time = O(n^3)
       Space = O(n^2)
     */

    //2D DP：
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        if(cuts == null || cuts.length == 0){
            return 0;
        }

        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        for(int i = 0; i < cuts.length; i++){
            helper[i+1] = cuts[i];
        }
        helper[cuts.length + 1] = length;
        int[][] minCuts = new int[helper.length][helper.length];
        for(int i = 1; i < helper.length; i++){
            for(int j = i - 1; j >=0 ; j--){
                if(j + 1 == i){
                    minCuts[j][i] = 0;
                }else{
                    minCuts[j][i] = Integer.MAX_VALUE;
                    for(int k = j + 1; k <= i - 1; k++){
                        minCuts[j][i] = Math.min(minCuts[j][i], minCuts[j][k] + minCuts[k][i]);
                    }
                    minCuts[j][i] += helper[i] - helper[j];
                }
            }
        }
        return minCuts[0][helper.length - 1];
    }

    //recursion --- O(n*n!)
    public int mCost(int[] cuts, int length) {
        // Write your solution here
        if(cuts == null || cuts.length == 0){
            return 0;
        }

        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        for(int i = 0; i < cuts.length; i++){
            helper[i+1] = cuts[i];
        }
        helper[cuts.length + 1] = length;
        Arrays.sort(helper);

        boolean[] cutted = new boolean[helper.length];
        cutted[0] = true;
        cutted[cutted.length - 1] = true;

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        int[] cost = new int[1];
        cost[0] = 0;

        helper(1, cost, helper, min, cutted);
        return min[0];
    }

    private void helper(int level, int[] cost, int[] helper, int[] min, boolean[] cutted){
        if(level == helper.length - 1){
            min[0] = Math.min(min[0], cost[0]);
        }

        for(int i = 0; i < helper.length; i++){
            int left = 0;
            int right = 0;
            if(cutted[i] == false){
                cutted[i] = true;
                for(int j = i - 1; j >= 0; j--){
                    if(cutted[j]){
                        left = helper[j];
                        break;
                    }
                }
                for(int j = i + 1; j < cutted.length; j++){
                    if(cutted[j]){
                        right = helper[j];
                        break;
                    }
                }
                cost[0] += right - left;
                helper(level + 1, cost, helper, min, cutted);
                cost[0] -= right - left;
                cutted[i] = false;
            }
        }
    }

    public void test1(){
        int[] cuts = new int[]{2,4,7};
        System.out.println(minimumCost(cuts, 10));
    }



    //recursion
    public int minimumCost(int[] pos, int L) {

        return helper1(0, L, pos);

    }

    private int helper1(int lo, int hi, int[] pos) {

        if(lo >= hi) return 0;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < pos.length; i++) {
            if(pos[i] <= lo || pos[i] >= hi) continue;
            min = Math.min(min, hi - lo + helper1(lo, pos[i], pos) + helper1(pos[i], hi, pos));

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
