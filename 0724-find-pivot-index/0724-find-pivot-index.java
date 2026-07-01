class Solution {
    public int sums(int i ,int j,int arr[]){
        int sum=0;
        for(int k =i;k<=j;k++){
            sum+=arr[k];
        }
        return sum;
    }
    public int pivotIndex(int[] nums) {
        for (int i =0;i<nums.length;i++){
            if((sums(0,i-1,nums))==(sums(i+1,nums.length-1,nums))){
                return i;
            }
        }
        return -1;
    }
}