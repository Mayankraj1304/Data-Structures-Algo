class Solution {
    public java.util.List<String> fizzBuzz(int n) {
        java.util.List<String> answer = new java.util.ArrayList<>(n);
        
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        
        return answer;
    }
}