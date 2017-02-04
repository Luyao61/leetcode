import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class numIslands {
    public static void main(String[] args){
        char map[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','1'}
              };
        System.out.println(numIslands(map));
    }

    public static int numIslands(char[][] grid){
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for(int i=0; i < m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void DFS(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if( i<0 || j<0 || i>=m || j>=n || grid[i][j] != '1') return;

        grid[i][j] = '0';
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
        return;
    }
}
