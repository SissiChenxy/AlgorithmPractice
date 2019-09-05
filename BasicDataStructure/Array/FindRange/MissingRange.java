package BasicDataStructure.Array.FindRange;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    /*
    https://leetcode.com/problems/missing-ranges
    Given a sorted integer array, where the range of elements are in the inclusive range[lower, upper], return the missing ranges.
    [lower,upper]'s range is larger than the range of array
    [0,1,3,50,75] lower = 0, upper = 99
    ["2", "4->49", "51->74","76->99"]

    clarification: int, sorted, duplicates
    assumption: duplicates count once
    cases analysis: [] lower == upper(one element)
                       lower != upper(a range)
                    [1] element == lower == upper(one element)
                        lower <= element <= upper(two ranges) [lower->element] [element->upper]
                    [multiple]
     data structure:
        left = 0, right =
     */
    public List<String> missingRange(int[] inputs, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(inputs == null || inputs.length == 0){
            if(lower == upper){
                result.add(lower + "");
            }else{
                result.add(lower + "->" + upper);
            }
            return result;
        }

        int left = 0;

        while(left < inputs.length -1){
            int start = lower;
            int end = upper;
            if(left == 0){
                start = lower;
                if(lower == inputs[left]){
                    end = inputs[left];
                }else{
                    end = inputs[left] - 1;
                }
            }else{
                while(left < inputs.length - 1 && inputs[left + 1] - 1 <= inputs[left]){
                    left++;
                }
                if(left < inputs.length - 1){
                    start = inputs[left] + 1;
                    end = inputs[left + 1] - 1;
                }
            }
            //post processing for duplicates ending
            if(left == inputs.length - 1){
                start = inputs[left];
                end = upper;
            }

            if(start == end && left != 0 ){
                result.add(start + "");
            }else if(start < end){
                result.add(start + "->" + end);
            }
            left++;
        }
        return result;
    }

    public List<String> findMissingRange(int[] inputs, int lower, int upper){
        List<String> result = new ArrayList<>();
        if(inputs == null || inputs.length == 0){
            if(lower == upper){
                result.add(lower + "");
            }else{
                result.add(lower + "->" + upper);
            }
            return result;
        }


        int start = lower;
        for(int i = 0; i < inputs.length;i++){
            //first element
            if(start == inputs[i]){
                if(inputs[i] == Integer.MAX_VALUE){
                    continue;
                }else{
                    start = inputs[i] + 1;
                }
            }else if (inputs[i] > start){
                if (start + 1 == inputs[i]){
                    result.add(start + "");
                }else{
                    result.add(start + "->" + (inputs[i] - 1));
                    if (inputs[i] == Integer.MAX_VALUE){
                        start = inputs[i];
                    }else{
                        start = inputs[i] + 1;
                    }
                }
            }
        }

        if(start < upper && start != Integer.MAX_VALUE){
            result.add(start + "->" + upper);
        }else if(start == upper && inputs[inputs.length - 1] != upper){
            result.add(start + "");
        }
        return result;
    }

    public void test1(){
        int[] a = new int[]{0,1,3,50,75};
        System.out.println(missingRange(a, 0, 99));
    }

    public void test2(){
        int[] a = new int[]{50,75,75};
        System.out.println(missingRange(a, 0, 99));
    }

    public void test3(){
        int[] a = new int[]{-2147483648, -2147483648, 0,1,2,2, 2147483647, 2147483647};
        System.out.println(findMissingRange(a, -2147483648, 2147483647));
    }
}
