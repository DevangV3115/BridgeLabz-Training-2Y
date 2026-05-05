import java.util.*;

public class IslandCounter {

    static int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,1},
            {0,0,1,0,1},
            {0,0,0,1,1}
    };

    static int n = grid.length;
    static int m = grid[0].length;

    static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return;

        grid[i][j] = 0;

        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }

    static int countIslands() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of Islands: " + countIslands());
    }
}