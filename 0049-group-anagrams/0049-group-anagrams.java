import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to character array, sort it, and convert back to string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            
            // If the key doesn't exist, initialize a new list
            map.putIfAbsent(sortedKey, new ArrayList<>());
            
            // Add the original string to its corresponding anagram group
            map.get(sortedKey).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}