class Solution {
    public int singleNumber(int[] nums) {
        HashMap <Integer,Integer> map=new HashMap <>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=0;
        for(int num:nums){
            if (map.containsKey(num)) {
                count = map.get(num);
            }
            if (count==1){
                return num;
            }
        }
    return -1;
    }
}