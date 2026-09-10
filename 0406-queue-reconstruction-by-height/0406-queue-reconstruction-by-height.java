import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        // 1. Sort descending by height (a[0]).
        //    If heights are equal, sort ascending by k-value (a[1]).
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        // 2. Insert each person into the list at index equal to their k-value.
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        // 3. Convert back to 2D array.
        return queue.toArray(new int[people.length][]);
    }
}
