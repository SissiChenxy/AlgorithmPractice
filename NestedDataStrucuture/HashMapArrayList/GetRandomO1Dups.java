package NestedDataStrucuture.HashMapArrayList;

import java.util.*;

public class GetRandomO1Dups {
    /*
    https://leetcode.com/problems/insert-delete-getrandom-o1/description/
    duplicates
    arraylist + hashmap<value, set(index)>
     */
    private static List<Integer> arrayList;
    private static int size;
    private static Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public GetRandomO1Dups() {
        arrayList = new ArrayList<>();
        size = 0;
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(size == arrayList.size()){
            arrayList.add(val);
        }else{
            arrayList.add(size, val);
        }

        if(!map.containsKey(val)){
            Set<Integer> set = new HashSet<>();
            set.add(size);
            map.put(val, set);
            size++;
            return true;
        }
        Set<Integer> set = map.get(val);
        set.add(size);
        size++;
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        if(size > 0){
            int last = arrayList.get(size - 1);
            Set<Integer> set = map.get(val);
            //val's stack, remove index
            int index = set.iterator().next();
            set.remove(index);
            //arraylist update, set index as last
            arrayList.set(index, last);
            //last's stack, add new index, remove last index
            map.get(last).add(index);
            map.get(last).remove(size - 1);

            //update map when there is no indexes of the val
            if(set.isEmpty()){
                map.remove(val);
            }
            size--;
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        if(size > 0){
            return arrayList.get(r.nextInt(size));
        }
        return -1;
    }

    public static void test(){
        //["RandomizedCollection","insert","insert","insert","insert","insert","insert","remove","remove","remove","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
        //[[],[1],[1],[2],[1],[2],[2],   [1],[2],[2],[2],[],[],[],[],[],[],[],[],[],[]]
        //[null,true,true,true,true,true,true,true,true,true,true,2,2,1,2,1,1,1,1,2,1]
        //[null,true,false,true,false,false,false,   true,true,true,true,1,1,1,1,1,1,1,1,1,1]

        GetRandomO1Dups g = new GetRandomO1Dups();
        System.out.println(g.insert(1));//T
        System.out.println(g.insert(1));//T
        System.out.println(g.insert(2));//T
        System.out.println(g.insert(1));//T
        System.out.println(g.insert(2));//T
        System.out.println(g.insert(2));//T

        System.out.println(g.remove(1));//F
        System.out.println(g.remove(2));//F
        System.out.println(g.remove(2));//F
        System.out.println(g.remove(2));//F
        System.out.println("random: " + g.getRandom());
        System.out.println("random: " + g.getRandom());
        System.out.println("random: " + g.getRandom());
        System.out.println("random: " + g.getRandom());
        System.out.println("random: " + g.getRandom());
        System.out.println("random: " + g.getRandom());
    }
}
