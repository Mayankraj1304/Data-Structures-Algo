class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularCount = 0; // Preference 0
        int squareCount = 0;   // Preference 1

        // Count student preferences
        for (int student : students) {
            if (student == 0) {
                circularCount++;
            } else {
                squareCount++;
            }
        }

        // Process sandwiches from top to bottom
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                // If no remaining student wants a circular sandwich, stop
                if (circularCount == 0) {
                    return squareCount;
                }
                circularCount--;
            } else {
                // If no remaining student wants a square sandwich, stop
                if (squareCount == 0) {
                    return circularCount;
                }
                squareCount--;
            }
        }

        // All students were fed
        return 0;
    }
}