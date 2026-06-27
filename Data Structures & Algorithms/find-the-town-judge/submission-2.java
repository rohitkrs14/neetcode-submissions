class Solution {
    public int findJudge(int n, int[][] trust) {
        int score[] = new int[n+1];
        int outScore[] = new int[n+1];
        
        for(int[] node:trust) {
            score[node[1]]++;
            outScore[node[0]]++;
        }

        for(int i =0;i<score.length;i++) {
            if(score[i] == n-1 && outScore[i] == 0) return i;
        }
        return -1;
    }
}