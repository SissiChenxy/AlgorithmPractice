package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int longest(String input) {
        // Write your solution here
        if(input.length() <= 1){
            return input.length();
        }

        char[] array = input.toCharArray();
        int left = 0;
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int j = 0;
        while(j < array.length){
            if(!set.contains(array[j])){
                set.add(array[j]);
                j++;
                maxLength = set.size() > maxLength ? set.size() : maxLength;
            }else{
                set.remove(array[left]);
                left++;
            }
        }
        return maxLength;
    }
}
