package DP.TwoDInput;

public class LongestCrossOf1s {

    //四个方向分开写, 也可以写两个函数，left down一起写，right up一起写
    public int largest(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 1 || cols == 1){
            return 0;
        }

        int[][] lTor = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    if(j == 0 || lTor[i][j-1] == 0){
                        lTor[i][j] = 1;
                    }else{
                        lTor[i][j] = lTor[i][j-1] + 1;
                    }
                }
            }
        }

        int[][] rTol = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = cols - 1; j >= 0; j--){
                if(matrix[i][j] == 1) {
                    if (j == cols - 1 || rTol[i][j + 1] == 0) {
                        rTol[i][j] = 1 ;
                    } else {
                        rTol[i][j] = rTol[i][j + 1] + 1;
                    }
                }
            }
        }

        int[][] tTob = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1) {
                    if (i == 0 || tTob[i - 1][j] == 0) {
                        tTob[i][j] = 1;
                    } else {
                        tTob[i][j] = tTob[i - 1][j] + 1;
                    }
                }
            }
        }

        int[][] bTot = new int[rows][cols];
        for(int i = rows - 1; i >= 0; i--){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1) {
                    if (i == rows - 1 || bTot[i + 1][j] == 0) {
                        bTot[i][j] = 1;
                    } else {
                        bTot[i][j] = bTot[i + 1][j] + 1;
                    }
                }
            }
        }

        int[][] result = new int[rows][cols];
        int globalMax = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result[i][j] = Math.min(Math.min(lTor[i][j], rTol[i][j]), Math.min(tTob[i][j], bTot[i][j]));
                globalMax = Math.max(globalMax, result[i][j]);
            }
        }
        return globalMax;
    }
}
