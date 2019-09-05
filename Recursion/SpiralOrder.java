package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        helper(matrix, result, 0, rows, cols);
        return result;
    }

    private void helper(int[][] matrix, List<Integer> result, int layer, int rows, int cols){

        if(rows <= 1 || cols <= 1){
            if(rows == 1 && cols == 1){
                result.add(matrix[layer][layer]);
            }else if(rows == 1 && cols > 1){
                for(int i = 0; i < cols; i++){
                    result.add(matrix[layer][i + layer]);
                }
            }else if(rows != 1 && cols > 1){
                for(int i = 0; i < rows; i++){
                    result.add(matrix[i][0]);
                }
            }
            return;
        }

        for(int i = 0; i < cols - 1; i++){
            result.add(matrix[layer][i + layer]);
        }

        for(int i = 0; i < rows - 1; i++){
            result.add(matrix[i + layer][matrix[0].length - 1 - layer]);
        }

        for(int i = cols - 1; i > 0; i--){
            result.add(matrix[matrix.length - 1 - layer][i + layer]);
        }

        for(int i = rows - 1; i > 0; i--){
            result.add(matrix[i + layer][layer]);
        }

        helper(matrix, result, layer + 1, rows - 2, cols - 2);
    }
}
