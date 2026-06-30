class Solution {
    public boolean check(int num){
        int ctr=0;
        while(num!=0){
            ctr++;
            num/=10;
        }
        if (ctr%2==0){
            return true;
        }
        else{
            return false;
        }
    }
    public int findNumbers(int[] nums) {
        int n=0;
        for (int i=0;i<nums.length;i++){
            if(check(nums[i])){
                n++;
            }
        }
        return n;
    }
}