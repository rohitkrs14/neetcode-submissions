class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Arrays.sort(bills);
        int c5 = 0;
        int c10 = 0;
        int n = bills.length;

        for(int i =0;i<n;i++) {
            if(bills[i] == 5) {
                c5++;
            } else if(bills[i] == 10) {
                if(c5 == 0) return false;
                else {
                    c10++;
                    c5--;
                } 
            } else {
                if(c5 > 0 && c10 > 0) {
                    c5--;
                    c10--;
                } else if (c10 == 0 && c5 >= 3) {
                    c5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}