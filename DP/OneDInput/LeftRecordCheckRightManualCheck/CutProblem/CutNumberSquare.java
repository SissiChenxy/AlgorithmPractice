package DP.OneDInput.LeftRecordCheckRightManualCheck.CutProblem;

public class CutNumberSquare {
    /*
    How to cut/split the number into a minimum number of items such that
    each item is equal to an integer's square value. 每一段都是平方值
    4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
        Return 1
    10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
        Return 2

    DP --- build result from small to big, linear scan and look back(all the squared number before )
    data structure:
        minCut[i] -- represents the min cuts of number i that each item is square value
            == min(minCut[i - j*j] + 1)
    algorithm:
        base case:
            minCut[0] = 0
        induction rule: -- control the most right cut
            minCut[1] 1(1)
            minCut[2] 1(valid) | 1 minCut[1] + 1
                      1 1(invalid) |
            minCut[3] 1(valid) | 1 1  minCut[2] + 1
                      1 1(invalid) | 1
                      1 1 1(invalid) |
            minCut[4] 1(valid) | 1 1 1 minCut[3] + 1
                      1 1(invalid) | 1 1
                      1 1 1(invalid) | 1
                      1 1 1 1(valid)| minCut[0] + 1
    Time = O(n^1.5)
    Space = O(n)
     */
    public int minCut(int num){
        if(num <= 1){
            return num;
        }

        int[] minCuts = new int[num + 1];
        minCuts[0] = 0;
        for(int right = 1; right <= num; right++){
            minCuts[right] = right;
            for(int left = 1; left * left <= right; left++){
                minCuts[right] = Math.min(minCuts[right - left * left] + 1, minCuts[right]);
            }
        }
        return minCuts[num];
    }

    public void test1(){
        System.out.println(minCut(10));
    }
}
