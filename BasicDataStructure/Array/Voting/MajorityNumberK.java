package BasicDataStructure.Array.Voting;

import java.util.*;

public class MajorityNumberK {

    /*
    遍历统计
    data structure: hashmap --- record the number of all elements in array
    Time = O(n)
    Space = O(n)
     */
    public List<Integer> majority1(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : array){
            Integer value = map.get(i);
            if(value == null){
                map.put(i, 1);
            }else{
                map.put(i, ++value);
                if(value == array.length / k){
                    result.add(i);
                }
            }
        }
        return result;
    }


    /*
    voting algorithm: k帮火拼 --- 有可能成为majority的最多k-1个
    data structure: hashmap1 --- record the potential majority
                    hashmap2 --- count the number of all the candidates in hashmap1
    algorithm:
        1. first loop
            when a new element comes
                if it exists in the hashmap1, count++
                if it doesn't exist in the hashmap1
                    if map.size < k-1, put in map
                    if map.size == k-1, decrease all elements' value in hashmap1
                        if value is decreased to 0, remove the element
        2. second loop
            iterate the input array, count the number of all elements in hashmap1
                if value > input.length / k, result.add()
        Time = O(n)
        Space = O(k)
     */
    public List<Integer> majority2(int[] array, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int number = array.length / k;
        //1st loop: iterate the input to select who belongs to the majority group
        for(Integer i : array){
            Integer count = countMap.get(i);
            if(count != null){
                countMap.put(i, ++count);
            }else if(countMap.size() < k - 1){
                countMap.put(i, 1);
            }else{
                Iterator<Map.Entry<Integer, Integer>> itr = countMap.entrySet().iterator();
                while(itr.hasNext()){
                    Map.Entry<Integer, Integer> entry = itr.next();
                    entry.setValue(entry.getValue() - 1);
                    if(entry.getValue() == 0){
                        itr.remove();
                    }
                }
            }
        }

        //2nd loop: iterate the input again to count the amount and see who is the most majority one in the group
        //时间不会增加，空间还是O(k)
        Map<Integer, Integer> totalMap = new HashMap<>();
        for(Integer i : array){
            if(countMap.containsKey(i)){
                Integer value = totalMap.get(i);
                if(value == null){
                    totalMap.put(i, 1);
                }else{
                    totalMap.put(i, ++value);
                    if(value > number){
                        result.add(totalMap.get(i));
                    }
                }
            }
        }

//        for(Integer key: countMap.keySet()){
//            int count = 0;
//           for(Integer i : array){
//                if(i == key) {
//                    count++;
//                }
//           }
//           if(count > number){
//                result.add(key);
//           }
//        }

        return result;
    }

    public void test1(){
        int[] array1 = new int[]{1,4,3,5,2,2,1,6};
        int[] array2 = new int[]{1};
        System.out.println(majority2(array1, 2));
    }
}
