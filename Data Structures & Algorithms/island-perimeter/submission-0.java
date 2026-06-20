class Solution {
    class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int peri =0;
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    return bfs(i, j, grid, vis, n, m);
                }
            }
        }
        return peri;
    }

    public int bfs(int row, int col, int[][] grid, int[][] vis, int n, int m) {
        int perimeter = 0;
        vis[row][col] = 1;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(row, col));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!que.isEmpty()) {
            Pair pair = que.poll();
            for(int i =0;i<4;i++) {
                int nrow = pair.row + delrow[i];
                int ncol = pair.col + delcol[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol <m) {
                    if(grid[nrow][ncol] == 1 && vis[nrow][ncol]==0) {
                        vis[nrow][ncol] = 1;
                        que.offer(new Pair(nrow, ncol));
                    } else if(grid[nrow][ncol] != 1){
                        perimeter++;
                    }
                } else {
                    perimeter++;
                }
            }
        }
        return perimeter;
    }
}