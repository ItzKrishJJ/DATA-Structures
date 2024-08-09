class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0; 
        for(int i = 0; i < m - 2; i++) { 
            for(int j = 0; j < n - 2; j++) { 
                if(isMagicGrid(grid, i, j)) {
                    count++;
                }
            } 
        }
        return count;
    }

    public boolean isMagicGrid(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];
        
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                int num = grid[i + x][j + y];
                if(num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        for(int x = 0; x < 3; x++) {
            if(sum != grid[i + x][j] + grid[i + x][j+1] + grid[i + x][j+2]) {
                return false;
            }
        }
        for(int y = 0; y < 3; y++) {
            if(sum != grid[i][j + y] + grid[i+1][j + y] + grid[i+2][j + y]) {
                return false;
            }
        }
        // Check diagonals
        if(sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;
        if(sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false; 
        return true;
    }
}
