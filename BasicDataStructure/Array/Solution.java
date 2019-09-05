package BasicDataStructure.Array;

import BasicDataStructure.Array.FindRange.MissingRange;
import BasicDataStructure.Array.FindRange.SummaryRange;
import BasicDataStructure.Array.Voting.MajorityNumberK;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        //MajorityNumberK m = new MajorityNumberK();
        //SummaryRange sr = new SummaryRange();
        //MissingRange mr = new MissingRange();
        //mr.test3();
        //System.out.println("mtv".equals("beijing"));
        test1();

    }

    public static List<String> invalidTransactions(String[] transactions) {
            Set<String> result = new HashSet<>();
            if(transactions == null || transactions.length == 0){
                return new ArrayList<>(result);
            }

            for(int i = 0; i < transactions.length; i++){
                int time = Integer.parseInt(transactions[i].split(",")[1]);
                if(time > 1000){
                    result.add(transactions[i]);
                }else{
                    for(int j = i-1; j >= 0; j--){
                        if(diffCity(transactions[i], transactions[j])){
                            result.add(transactions[i]);
                            result.add(transactions[j]);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }

        private static boolean diffCity(String a, String b){
            String[] as = a.split(",");
            String[] bs = b.split(",");
            if(as[0].equals(bs[0]) && Math.abs(Integer.parseInt(as[1]) - Integer.parseInt(bs[1])) <= 60 && !as[3].equals(bs[3])){
                return true;
            }
            return false;
        }

    public static void test1(){
        String[] a = new String[]{"alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(invalidTransactions(a));
    }
}
