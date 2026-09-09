class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Track passenger changes at each location (0 to 1000 based on constraints)
        int[] passengerChanges = new int[1001];
        
        // Record pickup and drop-off changes
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            passengerChanges[from] += numPassengers;
            passengerChanges[to] -= numPassengers;
        }
        
        // Accumulate passenger count along the route
        int currentPassengers = 0;
        for (int change : passengerChanges) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false; // Exceeded vehicle capacity
            }
        }
        
        return true;
    }
}