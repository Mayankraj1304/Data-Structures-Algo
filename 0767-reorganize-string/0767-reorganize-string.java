import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );

        maxHeap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            sb.append(first);
            sb.append(second);

            freq.put(first, freq.get(first) - 1);
            freq.put(second, freq.get(second) - 1);

            if (freq.get(first) > 0) {
                maxHeap.offer(first);
            }

            if (freq.get(second) > 0) {
                maxHeap.offer(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();

            if (freq.get(last) > 1) {
                return "";
            }

            sb.append(last);
        }

        return sb.toString();
    }
}