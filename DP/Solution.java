package DP;

import DP.OneDInput.JumpGame.CanGetToEnd;
import DP.OneDInput.JumpGame.MinStep;
import DP.OneDInput.LeftRecordCheckRightManualCheck.CutProblem.CutPalindrome;
import DP.OneDInput.LeftRecordCheckRightManualCheck.CutProblem.CutRopeMaxProduct;
import DP.OneDInput.LeftRecordCheckRightManualCheck.DictionaryWordMatch;
import DP.OneDInput.Fibonacci;
import DP.OneDInput.SubArraySequence.LargestSubArraySum;
import DP.OneDInput.SubArraySequence.LongestAscendingSubArray;
import DP.OneDInput.SubArraySequence.LongestAscendingSubSequence;
import DP.OneDInput.TwoDRecord.CuttingWood;
import DP.OneDInput.TwoDRecord.EditDistance;
import DP.OneDInput.TwoDRecord.LongestCommonSubstring;

public class Solution {
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        LongestAscendingSubArray la = new LongestAscendingSubArray();
        LongestAscendingSubSequence las = new LongestAscendingSubSequence();
        CutPalindrome cp = new CutPalindrome();
        CutRopeMaxProduct crmp = new CutRopeMaxProduct();
        DictionaryWordMatch dwm = new DictionaryWordMatch();
        CanGetToEnd cgtw = new CanGetToEnd();
        MinStep ms = new MinStep();
        CuttingWood cw = new CuttingWood();
        LargestSubArraySum lsas = new LargestSubArraySum();
        EditDistance ed = new EditDistance();
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.test();
    }
}
