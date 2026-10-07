class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the width of the container
            int width = right - left;
            
            // Find the limiting height
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current area and update maximum water found so far
            int currentWater = width * currentHeight;
            if (currentWater > maxWater) {
                maxWater = currentWater;
            }

            // Greedy step: Move the pointer pointing to the shorter line inward.
            // Additionally, skip any lines that are shorter than or equal to the 
            // current limiting height to avoid redundant calculations.
            if (height[left] < height[right]) {
                while (left < right && height[left] <= currentHeight) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= currentHeight) {
                    right--;
                }
            }
        }

        return maxWater;
    }
}
