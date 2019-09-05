package DP.OneDInput.TwoDRecord;

public class LongestCommonSubsequence {
    /*
    Find the length of longest common subsequence of two given strings.
    S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.

    data structure:
        common[i][j] -- represents the longest common subsequence between the first i characters in source and
        the first j characters in target, i, j is length
    algorithm:
        base case:
            common[0][0], common[0][j], common[i][0] = 0
        induction rule:
            2 cases:
                if s1[i] == s2[j]
                    common[i][j] = common[i-1][j-1] + 1
                otherwise
                    common[i][j] = Math.max(common[i-1][j], common[i][j-1])
     */
    public int longest(String source, String target) {
        // Write your solution here
        int[][] common = new int[source.length() + 1][target.length() + 1];
        for(int i = 0; i <= source.length(); i++){
            for(int j = 0; j <= target.length();j++){
                if(i == 0 || j == 0) common[i][j] = 0;
                else if(source.charAt(i-1) == target.charAt(j-1)){
                    common[i][j] = common[i-1][j-1] + 1;
                }else{
                    common[i][j] = Math.max(common[i-1][j], common[i][j-1]);
                }
            }
        }
        return common[source.length()][target.length()];
    }

    public void test(){
        System.out.println(longest("abcde","cbabdfe"));
    }
}
