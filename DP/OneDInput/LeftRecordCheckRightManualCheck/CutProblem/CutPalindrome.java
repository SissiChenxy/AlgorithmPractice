package DP.OneDInput.LeftRecordCheckRightManualCheck.CutProblem;

public class CutPalindrome {
    /*
    Determine the fewest cuts needed for palindrome partitioning of a given string.
    3 cuts -- “a | babbbab | b | ababa”.
    If a string is palindrome, then minimum 0 cuts are needed.

    DP --- linear scan the given string
    data structure:
        minCut[i] -- represents the minimum cuts made on size i substring to be palindrome
        j -- [0, i) j==0 represents no cut
    algorithm:
        base case:
            minCut[0] = 0
            minCut[1] = 0  a
        induction rule:
            minCut[2] = 1
                      | a b   (invalid)
                      a | b  = minCut[1] + 1 = 1
                    min(1) = 1
            minCut[3] = 0
                      | a b a   = 0
                      a | b a (invalid)
                      a b | a = minCut[2] + 1 = 2
                    min(0, 2) = 0
            minCut[4] = 1
                      | a b a b (invalid)
                      a | b a b = minCut[1] + 1 = 1
                      a b | a b (invalid)
                      a b a | b = minCut[3] + 1 = 1
                    min(1, 1) = 1
            minCut[5] = 1
                      | a b a b b
                      a | b a b b (invalid)
                      a b | a b b (invalid)
                      a b a | b b = minCut[3] + 1 = 1
                      a b a b | b = minCut[4] + 1 = 2
                    min(1, 2) = 1
            minCut[6] = 1
                      | a b a b b b (invalid)
                      a | b a b b b (invalid)
                      a b | a b b b (invalid)
                      a b a | b b b = minCut[3] + 1 = 1
                      a b a b | b b = minCut[4] + 1 = 2
                      a b a b b | b = minCut[5] + 1 = 2
                    min(1, 2, 2) = 1
            minCut[7] = 2
                      | a b a b b b a (invalid)
                      a | b a b b b a (invalid)
                      a b | a b b b a = minCut[2] + 1 = 2
                      a b a | b b b a (invalid)
                      a b a b | b b a (invalid)
                      a b a b b | b a (invalid)
                      a b a b b b | a = minCut[6] + 1 = 2
                    min(2, 2) = 2
            minCut[8] = 1
                      | a b a b b b a b (invalid)
                      a | b a b b b a b = minCut[1] + 1 = 1
                      a b | a b b b a b (invalid)
                      a b a | b b b a b (invalid)
                      a b a b | b b a b (invalid)
                      a b a b b | b a b = minCut[5] + 1 = 2
                      a b a b b b | a b (invalid)
                      a b a b b b a | b = minCut[7] + 1 = 3
                    min(1, 2, 3)
            minCut[9] = 2
                      | a b a b b b a b b (invalid)
                      a | b a b b b a b b (invalid)
                      a b | a b b b a b b (invalid)
                      a b a | b b b a b b (invalid)
                      a b a b | b b a b b = minCut[4] + 1 = 2
                      a b a b b | b a b b (invalid)
                      a b a b b b | a b b (invalid)
                      a b a b b b a | b b = minCut[7] + 1 = 3
                      a b a b b b a b | b = minCut[8] + 1 = 2
                    min(2, 3, 2)

     Time = O(n^3)
     Space = O(n)
     */
    public int minCutsPalindrome(String input){
        if(input == null || input.length() <= 1){
            return 0;
        }

        int[] minCut = new int[input.length() + 1];
        minCut[0] = 0;
        minCut[1] = 0;
        for(int i = 2; i <= input.length(); i++){
            int currentMin = minCut[i-1] + 1;
            //j == 0 represents no cut
            for(int j = 0; j < i; j++){
                if(isPalindrome(input, j, i)){
                    int right = j == 0? 0 : minCut[j] + 1;
                    currentMin = Math.min(currentMin, right);
                }
            }
            minCut[i] = currentMin;
        }
        return minCut[input.length()];
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end-1)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void test1(){
        String s = "ababbbabbababa";
        System.out.println(minCutsPalindrome(s));
    }
}
