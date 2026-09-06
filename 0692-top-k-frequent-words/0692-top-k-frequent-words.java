import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count word frequencies
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 2. Min-Heap ordered by:
        //    - Lower frequency first (so lowest frequency gets evicted)
        //    - Higher lexicographical order first when frequencies match (so reverse alphabetical gets evicted)
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqA = countMap.get(a);
            int freqB = countMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            }
            return b.compareTo(a);
        });

        // 3. Maintain only the top k elements in the heap
        for (String word : countMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract elements and reverse to get descending order
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }
}