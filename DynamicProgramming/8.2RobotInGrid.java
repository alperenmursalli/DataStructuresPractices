// Problem 8.2: Robot in a Grid
// Difficulty: Medium
// Pattern: Dynamic Programming

// Time Complexity: O(r * c)
// Space Complexity: O(r * c)

// Explanation:
// A robot starts at the top-left corner and wants to reach the bottom-right corner.
// It can only move right or down, and cells with value 1 are blocked.
// dp[i][j] stores whether the robot can reach cell (i, j).
// A cell is reachable if it is not blocked and can be reached from the top or left.

// Key Insight:
// Each cell depends only on the cell above it and the cell to its left.
package DynamicProgramming;

class RobotInGrid {
    public static void main(String[] args) {
        RobotInGrid robotInGrid = new RobotInGrid();

        int[][] gridWithPath = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] blockedGrid = {
            {0, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        System.out.println("Grid with path: " + robotInGrid.hasPath(gridWithPath));
        System.out.println("Blocked grid: " + robotInGrid.hasPath(blockedGrid));
    }

    boolean hasPath(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] dp = new boolean[r][c];

        if (grid[0][0]==1) return false;

        dp[0][0] =true;

        for (int i =0; i<r;i++){
            for (int j=0;j<c;j++){
                if (grid[i][j]==1) {
                    dp[i][j]=false;
                    continue; }
                
                if (i == 0 && j == 0) continue;

                boolean fromTop = i>0 && dp[i-1][j];
                boolean fromLeft = j>0 && dp[i][j-1];

                dp[i][j]= fromTop || fromLeft;
            }
        }
        return dp[r-1][c-1];
    }
}
