package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<int[]> nqueens(int n) {
        // Write your solution here

        int[] A = new int[n];
        List<int[]> result = new ArrayList<int[]>();
        nqueens(result, A, 0, n);
        return result;
    }

    private void nqueens(List<int[]> result, int[] A, int current_row, int n){
        //base case
        if(current_row == n){
            result.add(Arrays.copyOf(A, A.length));
            return;
        }

        for(int i = 0; i < n; i++){
            A[current_row] = i;
            if(passCheck(A, current_row, i)){
                nqueens(result, A, current_row + 1, n);
            }
        }

    }

    private boolean passCheck(int[] A, int current_row, int column){

        for(int index = 0; index < current_row; index++){
            //在同一列 || 在同一对角线
            if(A[index] == column || Math.abs(A[index] - column) == current_row - index){
                return false;
            }
        }
        return true;
    }
}
