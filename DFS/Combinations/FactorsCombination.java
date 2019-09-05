package DFS.Combinations;

import java.util.ArrayList;
import java.util.List;

public class FactorsCombination {
    public List<List<Integer>> combinations(int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> factors = new ArrayList<>();
        for(int i = 2; i <= target / 2; i++){
            if(target % i == 0){
                factors.add(i);
            }
        }
        int[] sol = new int[factors.size()];
        helper(factors, target, result, sol, 0);
        return result;
    }

    private void helper(List<Integer> factors, double remain, List<List<Integer>> result, int[] sol, int index){
        if(remain == 1){
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < sol.length; i++){
                int temp = sol[i];
                while(temp > 0){
                    cur.add(factors.get(i));
                    temp--;
                }
            }
            result.add(cur);
            return;
        }

        if(index == factors.size()){
            return;
        }

        int curNum = factors.get(index);
        double count = remain / curNum;
        for(int i = 0; i <= count; i++){
            int factor = (int) Math.pow(curNum, i);
            sol[index] = i;
            helper(factors, remain / factor, result, sol, index + 1);
        }
    }
}
