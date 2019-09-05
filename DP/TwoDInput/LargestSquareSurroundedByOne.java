package DP.TwoDInput;

public class LargestSquareSurroundedByOne {
    public int largestSquareSurroundedByOne1(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 0 || cols == 0){
            return 0;
        }

        int[][] left = new int[rows][cols];
        int[][] top = new int[rows][cols];

        count(matrix, left, top, rows, cols);
        int result = merge(left, top, rows, cols);
        return result;
    }

    private void count(int[][] matrix, int[][] left, int[][] top, int rows, int cols){
        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if(matrix[i][j] == 1){
                    if(j == cols - 1 || left[i][j+1] == 0){
                        left[i][j] = 1;
                    }else{
                        left[i][j] = left[i][j+1] + 1;
                    }
                    if(i == rows - 1 || top[i+1][j] == 0){
                        top[i][j] = 1;
                    }else{
                        top[i][j] = top[i+1][j] + 1;
                    }
                }
            }
        }
    }

    private int merge(int[][] left, int[][] top, int rows, int cols){
        int globalMax = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int min = Math.min(left[i][j], top[i][j]); min >= 1; min--){
                    if(left[i + min - 1][j] >= min && top[i][j - 1 + min] >= min){
                        globalMax = Math.max(globalMax, min);
                        break;
                    }

                }
            }
        }
        return globalMax;
    }


    public int largestSquareSurroundedByOne2(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 0 || cols == 0){
            return 0;
        }

        int[][] left = new int[rows + 1][cols + 1];
        int[][] top = new int[rows + 1][cols + 1];
        int result = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 1){
                    left[i+1][j+1] = left[i+1][j] + 1;
                    top[i+1][j+1] = top[i][j+1] + 1;
                }
                for(int maxLength = Math.min(left[i+1][j+1], top[i+1][j+1]); maxLength >= 1; maxLength--){
                    if(left[i + 2 - maxLength][j + 1] >= maxLength && top[i + 1][j + 2 - maxLength] >= maxLength){
                        result = Math.max(result, maxLength);
                        break;
                    }
                }

            }
        }

        return result;
    }

}
