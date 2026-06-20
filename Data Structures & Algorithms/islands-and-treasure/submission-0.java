class Solution {
    class Node {
        int row;
        int col;
        int dist;
        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> qu = new LinkedList<>();

        for(int i=0; i<n;i++) {
            for(int j =0;j<m;j++) {
                if(grid[i][j] == 0) {
                    qu.offer(new Node(i, j, 0));
                } 
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        while(!qu.isEmpty()) {
            Node temp = qu.peek();
            int r = temp.row;
            int c = temp.col;
            int dist = temp.dist;

            qu.poll();

            for(int i =0;i<4;i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >=0 && nrow <n && ncol >= 0 && ncol <m) {
                    if(grid[nrow][ncol] == 2147483647) {
                        grid[nrow][ncol] = dist+1;
                        qu.offer(new Node(nrow, ncol, dist+1));
                    }
                }
            }
        }
    }
}
