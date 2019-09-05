package BasicDataStructure.Array.Sort;

public class InsertionSort {
    //in-place
    public void insertionSort(int[] nums) {
        if(nums != null){
            for(int i = 0; i<nums.length -1 ;i++){
                for(int j = i + 1; j>0;j--){
                    if(nums[j] < nums[j-1]){
                        swap(nums,j,j-1);
                    }
                }
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
