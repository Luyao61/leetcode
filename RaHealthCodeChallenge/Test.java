package CodeChallenge;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
/**
 *  Junit Test class 
 *	@author Luyao Zhou
 *	Date: 02/13/2017
 */
public class Test {

	@Before
	public void setUp() throws Exception {
		
	}

	
	@org.junit.Test
	public void test01() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        Point[] obstacles = new Point[] {
        };
		
		Grid grid = new Grid(2, 2, obstacles, portals);

		int ans = grid.solve();
		assertEquals(2, ans);
	}
	
	@org.junit.Test
	public void test02() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(2,1), new Point(0,3));
        Point[] obstacles = new Point[] {
        };
		
		Grid grid = new Grid(5, 5, obstacles, portals);

		int ans = grid.solve();
		assertEquals(55, ans);
	}
	
	@org.junit.Test
	public void test03() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        Point[] obstacles = new Point[] {
            new Point(2,1)
        };
		
		Grid grid = new Grid(5, 5, obstacles, portals);

		int ans = grid.solve();
		assertEquals(40, ans);
	}	
	
	
	@org.junit.Test
	public void test04() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(1,1), new Point(4,4));
        portals.put(new Point(2,2), new Point(3,3));
        Point[] obstacles = new Point[]{
        };
		
		Grid grid = new Grid(6, 6, obstacles, portals);

		int ans = grid.solve();
		assertEquals(88, ans);
	}	
	
	
	@org.junit.Test
	public void test05() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(4,0), new Point(6,4));
        portals.put(new Point(2,5), new Point(5,2));
        portals.put(new Point(1,2), new Point(7,5));
        Point[] obstacles = new Point[]{
            new Point(0,3),
            new Point(2,3),
            new Point(3,4),
            new Point(4,6),
            new Point(6,1),
            new Point(6,5)
        }; 
        Grid grid = new Grid(8, 8, obstacles, portals);

		int ans = grid.solve();
		assertEquals(373, ans);
	}
	
	@org.junit.Test
	public void test06() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(0,0), new Point(3,3));
        Point[] obstacles = new Point[]{
            new Point(3,2),
            new Point(3,4),
            new Point(2,3),
            new Point(4,3)
        }; 
        Grid grid = new Grid(5, 5, obstacles, portals);

		int ans = grid.solve();
		assertEquals(0, ans);
	}	
	
	@org.junit.Test
	public void test07() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(0,0), new Point(4,4));
        //portals.put(new Point(2,2), new Point(4,4));
        Point[] obstacles = new Point[]{
        }; 
        Grid grid = new Grid(5, 5, obstacles, portals);

		int ans = grid.solve();
		assertEquals(1, ans);
	}

	@org.junit.Test
	public void test08() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        portals.put(new Point(2,2), new Point(0,0));
        Point[] obstacles = new Point[]{
        }; 
        Grid grid = new Grid(5, 5, obstacles, portals);

		int ans = grid.solve();
		assertEquals(-1, ans);
	}
	
	@org.junit.Test
	public void test09() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        Point[] obstacles = new Point[]{
        	new Point(0,0)
        }; 
        Grid grid = new Grid(2, 2, obstacles, portals);

		int ans = grid.solve();
		assertEquals(0, ans);
	}
	
	@org.junit.Test
	public void test10() {
        HashMap<Point, Point> portals = new HashMap<Point, Point>();
        Point[] obstacles = new Point[]{
        	new Point(0,1)
        }; 
        Grid grid = new Grid(3, 3, obstacles, portals);

		int ans = grid.solve();
		assertEquals(3, ans);
	}
	
}
