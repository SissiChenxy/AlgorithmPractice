package String;

import java.util.ArrayList;
import java.util.List;

public class Abbreviation {
    public boolean match(String input, String pattern) {
    // Write your solution here

    if(input.length() == 0 && pattern.length() == 0){
        return true;
    }
    if(input.length() == 0 || pattern.length() == 0){
        return false;
    }
    return abbrevMatch(input, pattern, 0, 0);
}

    private boolean abbrevMatch(String input, String pattern, int patternIndex, int inputIndex){
        if(inputIndex == input.length() && patternIndex == pattern.length()){
            return true;
        }
        if(inputIndex >= input.length() || patternIndex >= pattern.length() - 1){
            return false;
        }

        //is letter
        char patternChar = pattern.charAt(patternIndex);
        if(Character.isLowerCase(patternChar) || Character.isUpperCase(patternChar)){
            if(input.charAt(inputIndex) == patternChar){
                return abbrevMatch(input, pattern, patternIndex + 1, inputIndex + 1);
            }
            return false;
        }
            //is number
            int count = 0;
            while(patternIndex < pattern.length() && Character.isDigit(pattern.charAt(patternIndex))){
                count = count * 10 + pattern.charAt(patternIndex) - '0';
                patternIndex++;
            }
            inputIndex += count;
            return abbrevMatch(input, pattern, patternIndex ,inputIndex);
        }

}
