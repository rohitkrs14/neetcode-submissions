class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int total = 0;
        while(l<r) {
            int width = r-l;

            int length = Math.min(heights[l], heights[r]);

            total = Math.max(total, width * length);

            if(heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return total;
    }
}
