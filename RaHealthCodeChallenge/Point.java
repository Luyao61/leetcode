package CodeChallenge;

/**
 *  Point class 
 *	@author Luyao Zhou
 *	Date: 02/13/2017
 */
public class Point{
	//Point has 2 attributes: x and y.
	//x - row in grid
	//y - col in grid
    public int x;
    public int y;

    /**  
     * Default constructor for Object Point
     */
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    
    /**  
     * Constructor for Object Point
     * @param x: row number
     * @param y: col number
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**  
     * Comparator check if 2 point has the same value
     * Compare this and Point o
     * @param o: second Point
     * @return true if 2 points are the same, otherwise return false
     */   
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