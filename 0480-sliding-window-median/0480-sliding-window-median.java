import java.util.Comparator;
import java.util.TreeSet;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Custom comparator sorts by value, using index as a tie-breaker for duplicates
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        };

        TreeSet<Integer> small = new TreeSet<>(comparator);
        TreeSet<Integer> large = new TreeSet<>(comparator);

        for (int i = 0; i < n; i++) {
            // 1. Insert current element index
            if (small.isEmpty() || nums[i] <= nums[small.last()]) {
                small.add(i);
            } else {
                large.add(i);
            }
            
            // 2. Rebalance sets
            balance(small, large);

            // 3. Remove element exiting the window
            if (i >= k) {
                int outIndex = i - k;
                if (!small.remove(outIndex)) {
                    large.remove(outIndex);
                }
                balance(small, large);
            }

            // 4. Calculate median for current window
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = (double) nums[small.last()];
                } else {
                    result[i - k + 1] = ((double) nums[small.last()] + (double) nums[large.first()]) / 2.0;
                }
            }
        }

        return result;
    }

    private void balance(TreeSet<Integer> small, TreeSet<Integer> large) {
        while (small.size() > large.size() + 1) {
            large.add(small.pollLast());
        }
        while (small.size() < large.size()) {
            small.add(large.pollFirst());
        }
    }
}