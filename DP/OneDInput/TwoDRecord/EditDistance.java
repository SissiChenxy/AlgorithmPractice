package DP.OneDInput.TwoDRecord;

public class EditDistance {
    /*
    Given two strings of character, determine the minimum number of Replace, Delete, Insert
    operations needed to transform one string into the other.
    "sigh" -> "asith"  2

    DP -- 2 * 1D Input, linear scan and look back
    data structure:
        record[i][j] -- represents the minimum edit distance from first i letters of string1 to first j letters of string2
    algorithm:
        base case:
            size == 0 record[0][0] = 0
            one is empty record[i][0] = i, record[0][j] = j
        induction rule:
            for string1[i], string2[j] record[i][j]
                do nothing -> record[i-1][j-1]
                replace -> 1 + record[i-1][j-1]
                delete -> 1 + record[i-1][j]
                insert -> 1 + record[i][j-1]
            record[i][j] = min(replace, delete, insert)
     */

    public int editDistance(String one, String two) {

        if(one.length() == 0 || two.length() == 0){
            return Math.max(one.length(), two.length());
        }

        int[][] record = new int[one.length() + 1][two.length() + 1];

        //i, j is size
        for(int i = 0; i <= one.length(); i++){
            for(int j = 0; j <= two.length(); j++){
                if(i == 0){
                    record[i][j] = j;
                }else if(j == 0){
                    record[i][j] = i;
                }else if(one.charAt(i-1) == two.charAt(j-1)){
                    record[i][j] = record[i - 1][j - 1];
                }else{
                    int replace = record[i-1][j-1] + 1;
                    int delete = record[i-1][j] + 1;
                    int insert = record[i][j-1] + 1;
                    record[i][j] = Math.min(replace, delete);
                    record[i][j] = Math.min(record[i][j], insert);
                }
            }
        }
        return record[one.length()][two.length()];
    }

    public void test(){
        String s1 = "sigh";
        String s2 = "asith";
        System.out.println(editDistance(s1, s2));
    }
}
