class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengerChanges = new int[1001];
        int maxLocation = 0;
        
        for (int[] trip : trips) {
            // Optimization 1: Immediate exit if any single trip exceeds capacity
            if (trip[0] > capacity) {
                return false;
            }
            
            passengerChanges[trip[1]] += trip[0];
            passengerChanges[trip[2]] -= trip[0];
            
            // Optimization 2: Track the highest location used across all trips
            if (trip[2] > maxLocation) {
                maxLocation = trip[2];
            }
        }
        
        int currentPassengers = 0;
        // Optimization 3: Only loop up to maxLocation instead of hardcoded 1000
        for (int i = 0; i <= maxLocation; i++) {
            currentPassengers += passengerChanges[i];
            if (currentPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}