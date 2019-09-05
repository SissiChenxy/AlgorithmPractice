package NestedDataStrucuture.HashMapArrayList;

import java.util.*;

public class GetRandomO1 {
    /*
    no duplicates

     */
    private List<Integer> arrayList;
    private int size;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public GetRandomO1() {
        arrayList = new ArrayList<>();
        size = 0;
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            arrayList.add(size, val);
            map.put(val, size);
            size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int last = arrayList.get(size - 1);
        int index = map.get(val);
        arrayList.set(index, last);
        map.put(last, index);
        map.remove(val);
        size--;

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return arrayList.get(r.nextInt(size));
    }

    public static void test(){
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"][[],[0],[1],[0],[2],[1],[]]

        //[null,true,true,true,true,true,2]

        GetRandomO1 g = new GetRandomO1();
        System.out.println(g.insert(0));//T
        System.out.println(g.insert(1));//T
        System.out.println(g.remove(0));//F
        System.out.println(g.insert(2));//T
        System.out.println(g.remove(1));
        System.out.println("random: " + g.getRandom());
    }
}
