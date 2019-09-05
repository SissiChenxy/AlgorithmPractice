package String;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        if(input.length() == 0){
            return input;
        }

        char[] inputArray = input.toCharArray();
        char[] targetArray = target.toCharArray();

        if(source.length() >= target.length()){
            return replaceShorter(inputArray, source, targetArray);
        }
        return replaceLonger(inputArray, source, targetArray);
    }

    private String replaceShorter(char[] inputArray, String source, char[] targetArray){
        int slow = 0;
        int fast = 0;
        while(fast < inputArray.length){
            if(fast <= inputArray.length - source.length() && match(inputArray, fast, source)){
                copySubstring(inputArray, slow, targetArray);
                slow += targetArray.length;
                fast = fast + source.length();
            }else{
                inputArray[slow++] = inputArray[fast++];
            }
        }
        return new String(inputArray, 0, slow);
    }

    private String replaceLonger(char[] inputArray, String source, char[] targetArray){
        List<Integer> matches = getAllMatches(inputArray, source);
        int newSize = inputArray.length + matches.size() * (targetArray.length - source.length());
        char[] result = new char[newSize];

        int lastIndex = matches.size() - 1;
        int fast = inputArray.length - 1;
        int slow = result.length - 1;

        while(fast >= 0){
            if(lastIndex >= 0 && fast == matches.get(lastIndex)){
                copySubstring(result, slow - targetArray.length + 1, targetArray);
                slow -= targetArray.length;
                fast -= source.length();
                lastIndex--;
            }else{
                result[slow--] = inputArray[fast--];
            }
        }
        return new String(result);
    }

    private List<Integer> getAllMatches(char[] input, String source){
        List<Integer> matches = new ArrayList<Integer>();
        int pointer = 0;
        while(pointer <= input.length - source.length()){
            if(match(input, pointer, source)){
                matches.add(pointer + source.length() - 1);
                pointer += source.length();
            }else{
                pointer++;
            }
        }
        return matches;
    }

    private void copySubstring(char[] result, int fromIndex, char[] targetArray){
        for(int i = 0; i < targetArray.length; i++){
            result[fromIndex + i] = targetArray[i];
        }
    }

    private boolean match(char[] input, int start, String source){
        for(int i = start; i <= start + source.length() - 1; i++){
            if(input[i] != source.charAt(i - start)){
                return false;
            }
        }
        return true;
    }
}
