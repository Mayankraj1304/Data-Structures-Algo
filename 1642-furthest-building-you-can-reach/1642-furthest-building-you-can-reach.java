import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Min-heap to store the largest jumps allocated to ladders
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                minHeap.offer(diff);

                // If ladder capacity is exceeded, convert the smallest climb to bricks
                if (minHeap.size() > ladders) {
                    bricks -= minHeap.poll();
                }

                // If out of bricks, we cannot move past building i
                if (bricks < 0) {
                    return i;
                }
            }
        }

        // Successfully traversed all buildings
        return heights.length - 1;
    }
}