package DP.OneDInput.TwoDRecord;

public class LongestCommonSubstring {
    /*
    Find the longest common substring of two given strings.
    S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”

    DP - 2 X 1D Input
    data structure:
        common[i][j] -- represents the longest common substring between the first i+1 characters of source and the first j+1
        characters of target, i, j is index
        globalMax
        globalLeft
    algorithm:
        base case:
            common[0][0] = 0 -- first i in s1 and first j in s2
        induction rule:
            2 cases:
                if s1[i] == s2[j], common[i][j] = common[i-1][j-1] + 1; update globalMax, globalLeft
                otherwise, common[i][j] = 0

       Time = O(mn)
       Space = O(mn)
     */

    public String longestCommon(String source, String target) {
        // Write your solution here
        int[][] record = new int[source.length()][target.length()];
        int globalMax = 0;
        int globalLeft = 0;
        for(int i = 0; i < source.length(); i++){
            for(int j = 0; j < target.length(); j++){
                if(source.charAt(i) == target.charAt(j)){
                    if(i == 0 || j == 0){
                        record[i][j] = 1;
                    }else{
                        record[i][j] = record[i-1][j-1] + 1;
                    }
                    if(globalMax < record[i][j]){
                        globalMax = record[i][j];
                        globalLeft = i - globalMax + 1;
                    }
                }else{
                    record[i][j] = 0;
                }
            }
        }
        return source.substring(globalLeft, globalLeft + globalMax);
    }

    public void test(){
        String s1 = "abcdef";
        String s2 = "cdf";
        System.out.println(longestCommon(s1, s2));
    }
}
