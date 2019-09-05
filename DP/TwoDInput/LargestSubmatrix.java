package DP.TwoDInput;

public class LargestSubmatrix {

    //整合一维 ----- 预处理行内加和，之后按行加 O(n^5)
    public int largest1(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1 && cols == 1){
            return matrix[0][0];
        }

        int[][] record = prefixSum1D(matrix, rows, cols);
        int globalMax = Integer.MIN_VALUE;
        //upper-left
        for(int k = 0; k < rows; k++){
            for(int t = 0; t < cols; t++){
                //lower-right
                for(int i = k; i < rows; i++){
                    for(int j = t; j < cols; j++){
                        int sum = 0;
                        //每行每行加
                        for(int row = k; row <= i; row++){
                            //matrix[row][t] + matrix[row][t+1] + .... matrix[row][j]
                            if(t == 0){
                                sum += record[row][j];
                            }else{
                                sum += record[row][j] - record[row][t-1];
                            }
                        }
                        globalMax = Math.max(globalMax, sum);
                    }
                }
            }
        }
        return globalMax;
    }

    //在行的维度里整合
    private int[][] prefixSum1D(int[][] matrix, int rows, int cols){
        int[][] record = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            record[i][0] = matrix[i][0];
            for(int j = 1; j < cols; j++){
                record[i][j] = record[i][j-1] + matrix[i][j];
            }
        }
        return record;
    }


    //整合两维 ----- 预处理左顶点到右底点内加和，之后按块处理 O(n^4)
    public int largest2(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1 && cols == 1){
            return matrix[0][0];
        }

        int[][] record = prefixSum2D(matrix, rows, cols);
        int globalMax = Integer.MIN_VALUE;
        //upper-left
        for(int k = 0; k < rows; k++){
            for(int t = 0; t < cols; t++){
                //lower-right
                for(int i = k; i < rows; i++){
                    for(int j = t; j < cols; j++){
                        int sum = 0;
                        if(k == 0 && t == 0){
                            sum = record[i][j];
                        }else if(k == 0 && t != 0){
                            sum = record[i][j] - record[i][t-1];
                        }else if(k != 0 && t == 0){
                            sum = record[i][j] - record[k-1][j];
                        }else{
                            sum = record[i][j] - record[i][t-1] - record[k-1][j] + record[k-1][t-1];
                        }
                        globalMax = Math.max(globalMax, sum);
                    }
                }
            }
        }
        return globalMax;
    }

    //整合(0,0)到(i,j)的submatrix sum
    public int[][] prefixSum2D(int[][] matrix, int rows, int cols){
        int[][] record = new int[rows][cols];
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            record[i][0] = matrix[i][0];
            for(int j = 1; j < cols; j++){
                record[i][j] = record[i][j-1] + matrix[i][j];
            }
        }

        for(int i = 0; i < rows; i++){
            int sum = 0;
            for(int j = 0; j < cols; j++){
                for(int row = 0; row <= i; row++){
                    sum += matrix[row][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }


    //纵向拍扁，整合top line到bottom line之间的sum ----- O(n^3)
    public int largest3(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1 && cols == 1){
            return matrix[0][0];
        }

        int[][] record = prefixSum3D(matrix, rows, cols);
        int globalMax = Integer.MIN_VALUE;
        //upper-left
        for(int k = 0; k < rows; k++){
            for(int t = 0; t < cols; t++){
                //lower-right
                for(int i = k; i < rows; i++){
                    for(int j = t; j < cols; j++){
                        int sum = 0;
                        if(k == 0 && t == 0){
                            sum = record[i][j];
                        }else if(k == 0 && t != 0){
                            sum = record[i][j] - record[i][t-1];
                        }else if(k != 0 && t == 0){
                            sum = record[i][j] - record[k-1][j];
                        }else{
                            sum = record[i][j] - record[i][t-1] - record[k-1][j] + record[k-1][t-1];
                        }
                        globalMax = Math.max(globalMax, sum);
                    }
                }
            }
        }
        return globalMax;
    }

    //整合(top,0)到(bottom,cols - 1)的submatrix sum
    public int[][] prefixSum3D(int[][] matrix, int rows, int cols){
        int[][] record = new int[rows][cols];
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            record[i][0] = matrix[i][0];
            for(int j = 1; j < cols; j++){
                record[i][j] = record[i][j-1] + matrix[i][j];
            }
        }

        for(int i = 0; i < rows; i++){
            int sum = 0;
            for(int j = 0; j < cols; j++){
                for(int row = 0; row <= i; row++){
                    sum += matrix[row][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
