class Solution {
    public List<List<Integer>> permute(int[] nums) {
        calculatePermutations(Arrays.copyOf(nums, nums.length), 0);
        
        return permutations;
    }
    
    private List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    
    private void calculatePermutations(int[] nums, int left) {
        List<List<Integer>> permutations = this.permutations;
        if (left == nums.length - 1) {
            permutations.add(populatePermutation(nums));
            return;
        }
        
        for (int i = left ; i < nums.length ; i++) {
            swap(nums, left, i);
            calculatePermutations(nums, left + 1);
            swap(nums, i, left);
        }
    }
    
    private List<Integer> populatePermutation(int[] nums) {
        List<Integer> singlePermutation = new ArrayList<Integer>();
        for (int n: nums) {
            singlePermutation.add(n);
        }
        return singlePermutation;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}