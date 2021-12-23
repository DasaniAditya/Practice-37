// Maximum Gap (Radix Sort)

class Solution {
    public int maximumGap(int[] nums) {
//         if(nums == null || nums.length <= 1) {
//             return 0;
//         }
        
//         int max = 0;
//         int min = Integer.MAX_VALUE;
        
//         for(int i : nums) {
//             max = Math.max(i , max);
//             min = Math.min(i, min);
//         }
//         // System.out.println(min);
//         // System.out.println(max);
//         int[] arr = new int[max+1];
        
//         for(int i : nums) {
//             arr[i] = 1;
//         }
//         // System.out.println(Arrays.toString(arr));
//         int prev = min;
//         int result = 0;
//         for(int i = 0 ; i < arr.length; i++) {
//             if(arr[i] == 1) {
//                 result = Math.max(result, i - prev);
//                 prev = i;
//             }
//         }
//         return result;
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        
        for(int i : nums) {
            max = Math.max(i , max);
        }
        
        for(int i = 1 ; max / i > 0; i*=10) {
            radixSort(nums, nums.length, i);
        }
        
        int maxDiff = 0;
        
        for(int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i-1]);
        }
        return maxDiff;
        
    }
    
    private void radixSort(int[] nums, int length, int fac) {
        int[] temp = new int[length];
        int[] count = new int[10];
        
        for(int i = 0 ; i < nums.length; i++) {
            count[(nums[i] / fac) % 10]++;
        }
        for(int i = 1; i < count.length ; i++) {
            count[i] += count[i-1]; 
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            temp[count[(nums[i] / fac) % 10] - 1] = nums[i];
            count[(nums[i] / fac) % 10]--;
        }
        for(int i = 0 ; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
  
}