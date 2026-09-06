class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int x = 0;
        long totalRemainingGifts = 0;
        for (int num : gifts) {
            maxHeap.offer(num);
        }
        while (k>0 && !maxHeap.isEmpty()) {
            x = (int) Math.sqrt(maxHeap.poll());
            maxHeap.offer(x);
            k--;
        }
        while (!maxHeap.isEmpty()) {
            totalRemainingGifts += maxHeap.poll();
        }

        return totalRemainingGifts;
    }
}
