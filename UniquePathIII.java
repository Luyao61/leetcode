import java.io.*;
import java.util.*;

class Point{
    public int x;
    public int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    public boolean equals(Point o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Point)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Point c = (Point) o;

        // Compare the data members and return accordingly
        return Integer.compare(x, c.x) == 0
                && Integer.compare(y, c.y) == 0;
    }
}





class UniquePathIII
{

    public static void main (String[] args) throws java.lang.Exception
    {

        /* Test 1 */
        /*
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(2,1), new Point(0,3));
        Point[] obstacles = new Point[] {
        };
        int result = pathToSuccess(5,5, obstacles, portals);
        if(result != 55) System.out.println("Test1 failed");
        */
        /* Test 2 */
        /*
        HashMap<Point, Point> portals1 = new HashMap<Point, Point>();
        Point[] obstacles1 = new Point[] {
            new Point(2,1)
        };
        result = pathToSuccess(5,5, obstacles1, portals1);
        if(result != 40) System.out.println("Test2 failed");
        */
        /* Test 3 */
        HashMap<Point, Point> portals2 = new HashMap<Point, Point>();
        portals2.put(new Point(4,0), new Point(6,4));
        portals2.put(new Point(2,5), new Point(5,2));
        portals2.put(new Point(1,2), new Point(7,5));
        Point[] obstacles2 = new Point[]{
            new Point(0,3),
            new Point(2,3),
            new Point(3,4),
            new Point(4,6),
            new Point(6,1),
            new Point(6,5)
        };
        int result = pathToSuccess(8,8, obstacles2, portals2);

        System.out.println(result);

        HashMap<Point, Point> portals3 = new HashMap<Point, Point>();
        portals3.put(new Point(1,1), new Point(4,4));
        portals3.put(new Point(2,2), new Point(3,3));
        Point[] obstacles3 = new Point[]{
        };
        result = pathToSuccess(6,6, obstacles3, portals3);
        System.out.println(result);
    }



    public static int pathToSuccess(int m, int n, Point[] obstacles, HashMap<Point, Point> portals){
        if(m == 0 && n == 0){
            return 0;
        }

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


        //perform circle checke
        //cannot jump to point that has coordinate smaller than this point
        for(Point start: portals.keySet()){
            Point dest = portals.get(start);

            if(!start.equals(dest) && dest.x <= start.x && dest.y <= start.y){
                System.out.println("There exists a circle.");
                return -1;
            }
            heap.offer(start);
            heap.offer(dest);

        }


        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        for(Point p: obstacles){
            dp[p.x][p.y] = 0;
        }

        /*
        Point origin = new Point(0,0);
        System.out.println( portals.keySet().contains(origin));

        if(portals.containsKey(origin)){
            System.out.println("ok");
            Point dest_from_origin = portals.get(origin);
            for(int i = 0; i<dest_from_origin.x; i++){
                for(int j = 0; j<n; j++){
                    dp[i][j] = 0;
                }
            }
            for(int i = 0; i<m; i++){
                for(int j = 0; j<dest_from_origin.y; j++){
                    dp[i][j] = 0;
                }
            }
            dp[dest_from_origin.x][dest_from_origin.y] = 1;
        }
        else{
            dp[0][0] = 1;
        }
        */
        dp[0][0] = 1;
        HashMap<Point, Integer> saved_path = new HashMap<>();

        while(!heap.isEmpty()){
            Point p = heap.poll();

            if( portals.get(p) != null){
                Point start = p;
                Point dest = portals.get(start);

                for(int i=0; i<=start.x; i++){
                    for(int j=0; j<=start.y; j++){
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
                int temp = dp[start.x][start.y];
                dp[start.x][start.y] = 0;
                saved_path.put(dest, temp);
            }
            else{
                Point dest = p;
                for(int i=0; i<=dest.x; i++){
                    for(int j=0; j<=dest.y; j++){
                        if(dp[i][j] == -1){

                            int ans = 0;
                            if(i != 0 ){
                                ans += dp[i-1][j];
                            }
                            if(j != 0){
                                ans += dp[i][j-1];
                            }
                            if( i == dest.x && j == dest.y){
                                ans += saved_path.get(dest);
                            }
                            dp[i][j] = ans;
                        }
                    }
                }
            }
        }

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
