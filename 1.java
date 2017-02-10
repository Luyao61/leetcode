/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;




//remove connections less than K
/*
0 0 0 1 0        0 0 0 1 0
1 0 0 1 0        0 0 0 1 0
0 0 1 1 1 =====> 0 0 1 1 1
0 1 0 0 0        0 1 0 0 0
0 0 0 0 1        0 0 0 0 0
*/
class Solution{
    public static int height;
    public static int width;
    
    public static int[][] marker;
    
    
    public static void main(String[] args){
        int[][] map = {
            {0,0,0,1,0},
            {1,0,0,1,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {0,0,0,0,1},
        };
        int k = 5;

        for (int[] row : map){
            for (int i : row){
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

        int[][] new_map = start(map, k);

        for (int[] row : new_map){
            for (int i : row){
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

    }

    public static int[][] start(int[][] map, int K){
        if(map.length == 0){
            return map;
        }
        height = map.length;
        width = map[0].length;
        
        marker = new int[height][width];
        
        for(int[] row: marker){
            Arrays.fill(row, -1);
        }
        

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(map[i][j] == 1){
                    //booean[][] marker = new boolean[height][width];
                    
                    if(marker[i][j] == -1){
                        if( DFS(map, i, j) < K){
                            map[i][j] = 0;
                        }
                    }
                    else if(marker[i][j] < K){
                        map[i][j] = 0;
                    }
                    
                }
            }
        }
        return map;
    }
    public static int DFS(int[][] map, int i, int j){

        int ans = 0;
        if(i<0 || j<0 || i>=height || j>=width){
            return ans;
        }
        else if (marker[i][j] != -1 || map[i][j] == 0){
            marker[i][j] = ans;
            return ans;
        }
        else{
            ans++;

            ans += DFS(map, i-1, j-1);
            ans += DFS(map, i-1, j);
            ans += DFS(map, i-1, j+1);
            ans += DFS(map, i, j-1);
            ans += DFS(map, i, j+1);
            ans += DFS(map, i+1, j-1);
            ans += DFS(map, i+1, j);
            ans += DFS(map, i+1, j+1); 

            marker[i][j] = ans;
            return ans;

        }
    }
}
