class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int nu : nums) {
            map.put(nu, map.getOrDefault(nu, 0) + 1);
        }
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                count = map.get(num);
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
