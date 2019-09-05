package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> allAnagrams1(String sh, String lo) {
        // Write your solution here
        List<Integer> result = new ArrayList<Integer>();
        if(lo.length() == 0 || sh.length() > lo.length()){
            return result;
        }

        Map<Character, Integer> targetMap = generateMap(sh);

        char[] loArray = lo.toCharArray();
        int left = 0;
        while(left < loArray.length - sh.length()){
            for(int k = 0; k < sh.length(); k++){
                Integer value = (Integer)targetMap.get(loArray[left + k]);
                if(value == null){
                    left++;
                }else{
                    targetMap.put(loArray[left + k], value - 1);
                }
            }
            boolean complete = true;
            for(Integer value : targetMap.values()){
                if(value != 0){
                    complete = false;
                }
            }
            if(complete){
                result.add(left);
            }
            left++;
        }
        return result;
    }

    public List<Integer> allAnagrams2(String sh, String lo){
        List<Integer> result = new ArrayList<Integer>();
        if(lo.length() == 0 || sh.length() > lo.length()){
            return result;
        }


        Map<Character, Integer> targetMap = generateMap(sh);
        int match = 0;

        for(int i = 0; i < lo.length(); i++){
            Integer count = targetMap.get(lo.charAt(i));
            if(count != null){
                targetMap.put(lo.charAt(i),count - 1);
                if(count == 1){
                    match++;
                }
            }

            if(i > sh.length()){
                char tmp = lo.charAt(i - sh.length());
                count = targetMap.get(tmp);
                if(count != null){
                  targetMap.put(tmp, count + 1);
                  if(count == 0){
                      match--;
                  }
                }
            }

            if(match == targetMap.size()){
                result.add(i - sh.length() + 1);
            }
        }

        return result;
    }

    private Map<Character, Integer> generateMap(String s){
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        char[] shArray = s.toCharArray();
        for(int i = 0; i < shArray.length; i++){
            Integer value = (Integer)targetMap.get(shArray[i]);
            if(value == null){
                targetMap.put(shArray[i], 1);
            }else{
                targetMap.put(shArray[i], value + 1);
            }
        }
        return targetMap;
    }
}
