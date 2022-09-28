class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int maxSum = -1;
        
        Arrays.sort(nums);
        
        int i = 0;
        int j = i + 1;
        while (i < nums.length - 1) {
            if (nums[i] + nums[j] < k) {
                if (nums[i] + nums[j] > maxSum) {
                    maxSum = nums[i] + nums[j];
                }
                j++;
            } else {
                i++;
                j = i + 1;
            }
            
            if (j == nums.length) {
                i++;
                j = i + 1;
            }
        }
        
        return maxSum;
    }
}