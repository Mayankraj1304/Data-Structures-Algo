import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 1. Sort trips by start location (from) ascending
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 2. Min-Heap storing pairs of [toLocation, numPassengers], sorted by drop-off location
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int currentPassengers = 0;
        
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            // Drop off all passengers whose destination is <= current trip's start location
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= from) {
                currentPassengers -= minHeap.poll()[1];
            }
            
            // Pick up current passengers
            currentPassengers += numPassengers;
            if (currentPassengers > capacity) {
                return false;
            }
            
            // Add current trip's drop-off point and passenger count to the heap
            minHeap.offer(new int[]{to, numPassengers});
        }
        
        return true;
    }
}