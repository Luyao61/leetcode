
//remove connections less than K
/*
0 0 0 1 0        0 0 0 1 0
1 0 0 1 0        0 0 0 1 0
0 0 1 1 1 =====> 0 0 1 1 1
0 1 0 0 0        0 1 0 0 0
0 0 0 0 1        0 0 0 0 0
*/
public class removeConnections{
    public static int height;
    public static int width;
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

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(map[i][j] == 1){
                    boolean[][] marker = new boolean[height][width];
                    if(DFS(map, i, j, marker) < K){
                        map[i][j] = 0;
                    }
                }
            }
        }
        return map;
    }
    public static int DFS(int[][] map, int i, int j, boolean[][] marker){

        int ans = 0;
        if(i<0 || j<0 || i>=height || j>=width || marker[i][j] == true || map[i][j] == 0) return ans;
        ans++;
        marker[i][j] = true;

        ans += DFS(map, i-1, j-1, marker);
        ans += DFS(map, i-1, j, marker);
        ans += DFS(map, i-1, j+1, marker);
        ans += DFS(map, i, j-1, marker);
        ans += DFS(map, i, j+1, marker);
        ans += DFS(map, i+1, j-1, marker);
        ans += DFS(map, i+1, j, marker);
        ans += DFS(map, i+1, j+1, marker);
        return ans;
    }
}
