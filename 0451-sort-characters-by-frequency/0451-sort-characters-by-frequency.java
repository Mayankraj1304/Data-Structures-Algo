import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );

        maxHeap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = freq.get(ch);

            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}