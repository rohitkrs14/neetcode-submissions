class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int val : piles) {
            high = Math.max(high, val);
        }
        int result = high;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int total = 0;
            for(int i =0;i<piles.length;i++) {
                total += Math.ceil((double)piles[i]/mid);
            }
            if(total <= h) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }
}
