class Solution {
    public int sums(int cur_sum,int next){
            return cur_sum+next;
        }
    public int[] runningSum(int[] nums) {
        int cur_sum=0;
        for (int i=0;i<nums.length;i++){
            cur_sum= sums(cur_sum,nums[i]);
            nums[i]=cur_sum;

        }
        return nums;
    }
}