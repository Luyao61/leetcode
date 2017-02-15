package CodeChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
/**
 *  grid class 
 *	@author Luyao Zhou
 *	Date: 02/13/2017
 */
public class Grid
{
	
	public int m;	//size of the grid; number of rows
	public int n;	//size of the grid; number of cols
	public Point[] obstacles;	//List of Points; List of states that can't get to on the grid
	public HashMap<Point, Point> portals;	//Store jump point pairs in HashMap

	/**
	 *  Grid Constructor 
	 *	@param int m: first dimension of the grid
	 *	@param int n: second dimension of the grid
	 *	@param obstacles: List of states that can't get to on the grid
	 *	@param portals: List of states that will jump to another point, stored in a hash map; 
	 *	Key is jump start, Value is jump destination.
	 */	
	public Grid(int m, int n, Point[] obstacles, HashMap<Point, Point> portals){
		this.m = m;
		this.n = n;
		this.obstacles = obstacles;
		this.portals = portals;
		//Note: cannot perform continuous jump, i.e. jump from p1 to p2 to p3
	}
	
	/**
	 *  Solve the grid problem 
	 *  @return the number of unique pathes from 00, to m,n
	 */	
	public int solve(){
		//base case, return 0 if grid has size 0,0
        if(m == 0 && n == 0){
            return 0;
        }
        
        /* create a priority to store the jump points
         * smaller points are placed at top
         * point a is smaller than b if a.x <= b.x && a.y<=b.y
         * for example (2,2), (2,3) are smaller than (3,3)
         */
        PriorityQueue<Point> heap = new PriorityQueue<Point>(portals.size()+1, new Comparator<Point>(){

            public int compare(Point a, Point b){
                if( b.x <= a.x && b.y <= a.y ){
                    return 1;
                }
                else if( b.x >= a.x && b.y >= a.y ){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });



        for(Point start: portals.keySet()){
            Point dest = portals.get(start);

            /*perform circle check
             * cannot jump to point that has coordinate smaller than this point
             */
            if(!start.equals(dest) && dest.x <= start.x && dest.y <= start.y){
                System.out.println("There exists a circle.");
                return -1;
            }
            /*
             * push all jump point pairs into the heap
             */
            heap.offer(start);
            heap.offer(dest);
        }
        // create a lookup table
        int[][] dp = new int[m][n];

        //set all value to -1 for all unvisited point
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }


        //base case
        dp[0][0] = 1;
        
        //mark obstacle points 0
        for(Point p: obstacles){
            dp[p.x][p.y] = 0;
        }


        
        /* create a hashmap to save dp[i][j] if (i,j) is jump start
         * key is the dest of jump point pairs, value is dp[i][j] where (i,j) is jump start
         */
        HashMap<Point, Integer> saved_path = new HashMap<>();

        //calculate the dp[][] for all jump points in the order of samll point ot big point
        while(!heap.isEmpty()){
            Point p = heap.poll();

            
            if( portals.get(p) != null){	//this point is a jump start
                Point start = p;
                Point dest = portals.get(start);

                for(int i=0; i<=start.x; i++){
                    for(int j=0; j<=start.y; j++){
                        if(dp[i][j] == -1){
                            int ans = 0;
                            if(i != 0 ){	//boundary check
                                ans += dp[i-1][j];
                            }
                            if(j != 0){		//boundary check
                                ans += dp[i][j-1];
                            }
                            dp[i][j] = ans;
                        }
                    }
                }
                
                /* save dp[i][j]; 
                 * dp[][] will be marked as 0 because no point can be reached from this point
                 * except for jump dest.
                 */
                int temp = dp[start.x][start.y];
                saved_path.put(dest, temp);	
                dp[start.x][start.y] = 0;
            }
            else{ //this point is jump dest
                Point dest = p;
                for(int i=0; i<=dest.x; i++){
                    for(int j=0; j<=dest.y; j++){
                        if(dp[i][j] == -1){

                            int ans = 0;
                            if(i != 0 ){	//boundary check
                                ans += dp[i-1][j];
                            }
                            if(j != 0){		//boundary check
                                ans += dp[i][j-1];
                            }
                            //this is a jumo dest point; add the path from jump start
                            if( i == dest.x && j == dest.y){
                                ans += saved_path.get(dest);
                            }
                            dp[i][j] = ans;
                        }
                    }
                }
            }
        }

        //finish the rest of grid if unfinished.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] == -1){
                    int ans = 0;
                    if(i != 0 ){
                        ans += dp[i-1][j];
                    }
                    if(j != 0){
                        ans += dp[i][j-1];
                    }
                    dp[i][j] = ans;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

