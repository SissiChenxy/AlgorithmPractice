package BasicDataStructure.Array.Voting;

public class MajorityNumberTwo {
    /*
    voting algorithm
    data structre:
        int majority
        int count
    algorithm:
        for each element in array:
            if count == 0;
                majority = array[i];
            else if majority == array[i]:
                count++;
            else if count > 0:
                count--;
     */
    public int majority(int[] array) {
        // Write your solution here
        int[] counter = new int[2];
        for(Integer i : array){
            if(counter[1] == 0){
                counter[0] = i;
                counter[1] = 1;
            }else if(i == counter[0]){
                counter[1]++;
            }else{
                counter[1]--;
            }
        }
        return counter[0];
    }

    public int majority1(int[] array) {
        int majority = array[0];
        int count = 0;
        for(int i = 1; i < array.length ; i++){
            if(count == 0){
                majority = i;
                count++;
            }else if(array[i] == majority){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }

    public void test1(){
        int[] a = new int[]{1,2,1,2,2,2,1,1,1,1};
        System.out.println(majority(a));
    }
}
