package BasicDataStructure.Array.Voting;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberThree {

    /*
    voting algorithm: 三帮火拼
    data structure:
        <number1, counter1> / int number1, int count1
        <number2, counter2> / int number2, int count2
    algorithm:
        step1:
        for each element in array
            if x == number1:
                counter1++;
            else if x == number2:
                counter2++;
            else if counter1 == 0:
                number1 = x;
                counter1 = 1;
            else if counter2 == 0:
                number2 = x;
                counter2 = 1;
            else if x != number1 && x != number2
                counter1--;
                counter2--;
        step2:
        iterate the array and time, count the number of occurrences of the two possible candidates
     */
    public List<Integer> majority(int[] array) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();

        int[] majority1 = new int[2];
        int[] majority2 = new int[2];

        for(Integer i : array){
            if(majority1[1] == 0){
                majority1[0] = i;
                majority1[1]++;
            }else if(majority2[1] == 0){
                majority2[0] = i;
                majority2[1]++;
            }else if(i == majority1[0]){
                majority1[1]++;
            }else if(i == majority2[0]){
                majority2[1]++;
            }else{
                majority1[1]--;
                majority2[1]--;
            }
        }

        if(majority1[1] == 0 && majority2[1] == 0){
            return result;
        }

        int count1 = 0, count2 = 0;
        for(Integer i : array){
            if(i == majority1[0]){
                count1++;
            }else if(i == majority2[0]){
                count2++;
            }
        }

        if(count1 > count2){
            result.add(majority1[0]);
        }else if(count2 > count1){
            result.add(majority2[0]);
        }else{
            result.add(majority1[0]);
            result.add(majority2[0]);
        }
        return result;
    }

    public void test1(){
        int[] a = new int[]{1,2,2,3,2,1,3,3,1};
        System.out.println(majority(a));
    }

    public void test2(){
        int[] a = new int[]{1};
        System.out.println(majority(a));
    }

}
