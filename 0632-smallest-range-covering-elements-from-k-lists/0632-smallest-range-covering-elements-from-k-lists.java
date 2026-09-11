import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap stores triplet: [element_value, list_index, element_index]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int currentMax = Integer.MIN_VALUE;
        int k = nums.size();
        
        // Push the first element of each list into the heap
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }
        
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        // Maintain a window of size k containing 1 element from each list
        while (minHeap.size() == k) {
            int[] minElem = minHeap.poll();
            int val = minElem[0];
            int listIdx = minElem[1];
            int elemIdx = minElem[2];
            
            // Check if current [val, currentMax] range is smaller than best range so far
            if (currentMax - val < rangeEnd - rangeStart) {
                rangeStart = val;
                rangeEnd = currentMax;
            }
            
            // Advance pointer in the list that contained the minimum value
            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                currentMax = Math.max(currentMax, nextVal);
            }
        }
        
        return new int[]{rangeStart, rangeEnd};
    }
}