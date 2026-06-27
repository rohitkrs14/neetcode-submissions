class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return check(l+1, r, s) || check(l, r-1, s);
            }
            l++;
            r--;
        }
        return true;
    }
    boolean check(int l, int r, String s) {
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}