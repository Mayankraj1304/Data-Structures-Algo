import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int row = 0; row < n; row++) {
            minHeap.offer(new int[]{matrix[row][0], row, 0});
        }

        int answer = 0;

        while (k > 0) {
            int[] current = minHeap.poll();

            answer = current[0];
            int row = current[1];
            int col = current[2];

            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }

            k--;
        }

        return answer;
    }
}