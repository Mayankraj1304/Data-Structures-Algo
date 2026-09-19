import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }
        int numbersNeeded = k - path.size();
        for (int value = start; value <= n - numbersNeeded + 1; value++) {
            path.add(value);
            backtrack(value + 1, n, k, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
