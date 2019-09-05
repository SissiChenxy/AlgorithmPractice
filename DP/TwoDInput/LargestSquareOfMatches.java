package DP.TwoDInput;

public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows <= 1 || cols <= 1){
            return 0;
        }

        int[][] left = new int[rows+1][cols+1];
        int[][] up = new int[rows+1][cols+1];
        int globalMax = 0;

        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if(matrix[i][j] == 1 || matrix[i][j] == 3){
                    if(j == cols - 1 || left[i][j+1] == 0){
                        left[i][j] = 1;
                    }else{
                        left[i][j] = left[i][j+1] + 1;
                    }
                }

                if(matrix[i][j] == 2 || matrix[i][j] == 3){
                    if(i == rows - 1 || up[i+1][j] == 0){
                        up[i][j] = 1;
                    }else{
                        up[i][j] = up[i+1][j] + 1;
                    }
                }
            }
        }

        for(int i = 0; i <= rows; i++){
            for(int j = 0; j <= cols; j++){
                for(int maxLength = Math.min(left[i][j], up[i][j]); maxLength >= 1; maxLength--){
                    if(left[i + maxLength][j] >= maxLength && up[i][j + maxLength] >= maxLength){
                        globalMax = Math.max(globalMax, maxLength);
                    }
                }
            }
        }
        return globalMax;
    }
}
