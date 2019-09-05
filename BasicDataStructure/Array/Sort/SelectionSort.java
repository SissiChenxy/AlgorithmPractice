package BasicDataStructure.Array.Sort;

public class SelectionSort {
    public void selectionSort(int[] nums){
        if(nums != null){
            for(int i = 0; i<nums.length;i++){
                int min = i;
                //find the smallest one
                for(int j = i+1; j<nums.length;j++) {
                    if (nums[j] < nums[min]) {
                        min = j;
                    }
                }
                //exchange the smallest one with i
                swap(nums,i,min);
            }
        }
    }

    private int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
