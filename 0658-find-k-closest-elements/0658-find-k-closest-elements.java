import java.util.*;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // [0] = distance (|num - x|), [1] = actual num
        // Max-Heap: Bada distance pehle aayega (b[0], a[0])
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (b[0] != a[0]) {
                    return Integer.compare(b[0], a[0]); // Bada distance root par
                }
                return Integer.compare(b[1], a[1]); // Equal distance pe bada number root par
            }
        );

        for (int num : arr) {
            int dist = Math.abs(num - x);
            maxHeap.offer(new int[] { dist, num }); // int[] pass karna zaroori hai

            // Jaise hi size K se bada ho, worst candidate ko nikaal do
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]); // index 1 par actual number tha
        }

        // LeetCode ko result sorted ascending order mein chahiye
        Collections.sort(result);
        return result;
    }
}
