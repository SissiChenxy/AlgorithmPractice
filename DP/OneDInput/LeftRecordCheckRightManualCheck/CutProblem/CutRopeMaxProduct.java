package DP.OneDInput.LeftRecordCheckRightManualCheck.CutProblem;

public class CutRopeMaxProduct {
    /*
    Given a rope with positive length n, cut the rope into m integer-length parts in order to
    get the maximum product of p[0] * p[1] * ... * p[m-1], at least one cut

    DP --- build a 1D record array, use the smaller result to build the larger result
    data structure:
        minCut[i] -- represents the largest product of length i rope whose has at least one cut
    algorithm: 左大段，右大段
        base case: invalid
            minCut[0] = 0
            minCut[1] = 0
        induction rule: -- control the most right cut
            minCut[2] _ | _  minCut[2] = max{1, minCut[1]} * 1
            minCut[3] _ _ | _ minCut[3]' = max{2, minCut[2]} * 1
                      _ | _ _ minCut[3]'' = max{1, minCut[1]} * 2
                    minCut[3] = max{minCut[3]', minCut[3]''}
    Time = O(n^2)
    Space = O(n)
     */

    public int cutRope(int n){
        int[] M = new int[n + 1];
        M[0] = 0;
        M[1] = 0;
        for(int i = 2; i <= n; i++){
            int curMax = 0;
            for(int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i-j));
            }
            M[i] = curMax;
        }
        return M[n];
    }

    public void test1(){
        System.out.println(cutRope(5));
    }
}
