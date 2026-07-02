class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int nu : nums) {
            map.put(nu, map.getOrDefault(nu, 0) + 1);
        }
        int flag = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) > 1) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 1) {
            return true;
        }
        return false;
    }
}
