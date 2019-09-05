package DP.TwoDInput;

public class LargestSquaresOf1s {
    /*
    Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1),
    return the length of the largest square.
    {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}} the largest square of 1s has length of 2

    DP --- 2D Input(matrix)
    data structure:
        M[i][j] -- represents using (i,j) as the bottom-right corner, the largest edge length
    algorithm:
        size = 1  1
        size = 2  1 1
                  1 1
        size = 3  1 1 1
                  1 1 1
                  1 1 1
        2 cases:
            if matrix[i][j] == 0, M[i][j] = 0
            else,  M[i][j] = min(M[i-1][j], M[i][j-1], M[i-1][j-1]) + 1
     Time = O(n^2)
     Space = O(n^2)
     */

    public int largest(int[][] matrix) {
        // Write your solution here
        if(matrix == null || matrix.length == 0) return 0;
        int[][] record = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    record[i][j] = matrix[i][j] == 0 ? 0 : 1;
                }else if(matrix[i][j] == 1){
                    int min = Math.min(record[i-1][j], record[i][j-1]);
                    record[i][j] = Math.min(min, record[i-1][j-1]) + 1;
                }
                globalMax = Math.max(globalMax, record[i][j]);
            }
        }
        return globalMax;
    }
}
