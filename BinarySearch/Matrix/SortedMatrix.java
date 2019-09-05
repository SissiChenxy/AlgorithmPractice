package BinarySearch.Matrix;

public class SortedMatrix {

    //以右上角为起始点
    public int[] search1(int[][] matrix, int target) {
        // Write your solution here
        int[] result = new int[2];
        if(matrix.length == 0 || matrix[0].length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        search(result, matrix, 0, matrix[0].length - 1, target);
        return result;
    }

    private void search(int[] result, int[][] matrix, int row, int col, int target){
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                result[0] = row;
                result[1] = col;
                return;
            }else if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }
        }
        result[0] = -1;
        result[1] = -1;
    }


    //以左下角为起始点
    public int[] search2(int[][] matrix, int target) {
        // Write your solution here
        int[] result = new int[2];
        if(matrix.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int row = matrix.length - 1;
        int col = 0;

        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target){
                result[0] = row;
                result[1] = col;
                return result;
            }else if(matrix[row][col] < target){
                col++;
            }else if(matrix[row][col] > target){
                row--;
            }
        }
        result[0] = -1;
        result[1] = -1;

        return result;
    }
}
