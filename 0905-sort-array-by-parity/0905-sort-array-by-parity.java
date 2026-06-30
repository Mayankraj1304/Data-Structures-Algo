class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int []arr=new int[nums.length];
        int left=0,right=arr.length-1;
        for (int i =0;i<nums.length;i++){
            if(nums[i]%2==0){
                arr[left]=nums[i];
                left++;
            }
            else{
                arr[right]=nums[i];
                right--;
            }
        }
        return arr;
    }
}