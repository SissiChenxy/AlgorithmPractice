package DP.OneDInput.SubArraySequence;

public class LongestAscendingSubSequence {
    /*
    DP: input is 1D array, similar smallest element --- linear scan and look back
    data structure:
        M[i] -- represents from the 0-th element to the i-th element, the value of the longest ascending subsequence(including i-th element)
        globalMax
    algorithm:
        base case: M[0] = 1
        induction rule:
            M[i] = max{M[j]} + 1  if a[j] < a[i] && 0 <= j < i
                   1              if there is no such j
            每轮更新globalMax
     Time = O(n^2)
     Space = O(n)
     */
    public int longest(int[] array) {
        if(array.length == 0){
            return 0;
        }

        int globalMax = 1;
        int[] record = new int[array.length];
        for(int i = 0; i < array.length; i++){
            record[i] = 1;
            for(int j = i; j >= 0; j--){
                if(array[j] < array[i]){
                    record[i] = Math.max(record[j] + 1, record[i]);
                }
            }
            globalMax = Math.max(record[i], globalMax);
        }
        return globalMax;
    }

    /*
    Binary Search: decrease the range of searching
    data structure:
        int[i] candidates ---- candidates set(M值一定是连续的，index是1234...)
            the smallest ending value of all the ascending subsequences with length i
            candidates[Mi] = Ai(smallest)
        int currentLength -- the length of longest ascending subsequence we currently have
    algorithm
        initialize:
            candidates[1] = array[0]
            current
        when a new element comes:
            find the closest element in refine of the new element --- meaning that the new element can be concatenate to form a new one
                binary search -- to find the "largest smaller element"
                return the index of result
            if index == currentLength
                    candidates[++currentLength] = array[i];
               index != currentLength
                    candidates[index + 1] = array[i]
    Time = O(nlogn)
    Space = O(1)
     */
    public int longest2(int[] array) {
        if(array.length == 0){
            return 0;
        }
        int[] candidates = new int[array.length + 1];
        candidates[1] = array[0];
        int currentLength = 1;
        for(int i = 1; i < array.length; i++){
            int index = findLargestSmaller(candidates, 1, currentLength, array[i]);
            if(index == currentLength){
                candidates[++currentLength] = array[i];
            }else{
                candidates[index + 1] = array[i];
            }
        }
        return currentLength;
    }

    private int findLargestSmaller(int[] candidates, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(candidates[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public void test1(){
        int[] array = new int[]{7,2,3,1,5,8,9,6};
        System.out.println(longest2(array));
    }
}
