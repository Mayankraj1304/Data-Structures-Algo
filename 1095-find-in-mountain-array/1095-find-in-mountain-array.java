/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        
        // Step 1: Find the peak index of the mountain array
        int peakIndex = findPeak(mountainArr, length);
        
        // Step 2: Search in the strictly increasing left half
        int leftResult = binarySearchAscending(mountainArr, target, 0, peakIndex);
        if (leftResult != -1) {
            return leftResult; // Return immediately if found in the left half (gives minimum index)
        }
        
        // Step 3: Search in the strictly decreasing right half
        return binarySearchDescending(mountainArr, target, peakIndex + 1, length - 1);
    }
    
    // Helper method to find the peak index using binary search
    private int findPeak(MountainArray mountainArr, int length) {
        int left = 0;
        int right = length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1; // Peak is on the right
            } else {
                right = mid;    // Peak is at mid or on the left
            }
        }
        return left;
    }
    
    // Helper method for binary search in the ascending part
    private int binarySearchAscending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) {
                return mid;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // Helper method for binary search in the descending part
    private int binarySearchDescending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) {
                return mid;
            } else if (val < target) {
                right = mid - 1; // For a descending array, smaller values are to the right
            } else {
                left = mid + 1;  // Larger values are to the left
            }
        }
        return -1;
    }
}