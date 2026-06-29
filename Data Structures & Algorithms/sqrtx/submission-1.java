class Solution {
    public int mySqrt(int x) {
        long l = 1;
        long r = x;
        while(l <= r) {
            long mid = l + (r-l)/2;
            if(mid * mid == x) return (int)mid;
            if(mid * mid > x) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return (int)r;
    }
}