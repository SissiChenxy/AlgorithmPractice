package BasicDataStructure.Array.FindRange;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    /* https://leetcode.com/problems/summary-ranges/
    Given a sorted integer array with duplicates, return the summary of its ranges.
    [0,2,3,4,6,8,9] ----- ["0","2->4","6","8->9"]
    [0,1,2,4,5,7] ---- ["0->2","4->5","7"]

    clarification: int, sorted, duplicates
    assumption: duplicates count once
    cases analysis: [], [1], [0,1,2] [1,2,6,7,8] [1,1,2,6,6,7]
    data structure:
        left = 0, right = 1...input.length
        [L, R) --- result is range of [L, R-1]
        R points to the element which is going to be checked
    algorithm:
        for array[right] in input:
            case 1: array[right - 1] + 1 == array[right]
                right++;
            case 2: array[right - 1] + 1 != array[right]
                case 2.1: array[left] == array[right-1] --- duplicates && one element
                    result.add(array[left])
                    right++
                case 2.2: else
                    result.add(array[left] + "->" + array[right-1])
                left = right
      Time = O(n)
      Space = O(1)
*/

    public List<String> mergeRange(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int left = 0;
        for (int right = 1; right <= nums.length; right++) {
            if (right == nums.length || nums[right - 1] + 1 != nums[right]) {
                if (nums[left] == nums[right - 1]) {
                    res.add("" + nums[left]);
                    //duplicates only show once
                    right++;
                } else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }

                left = right;
            }
        }

        return res;
    }

    public void test1() {
        int[] array = new int[]{-2147483648,-2147483647,2147483647};
        System.out.println(mergeRange(array));
    }

    public void test2() {
        int[] array = new int[]{0,1,2,4,5,5,7,7};
        System.out.println(mergeRange(array));
    }
}
