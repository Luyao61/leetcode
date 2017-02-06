import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class RandomPlaceMine {
  public static void main(String[] args){
    int[][] map = new int[5][6];
    //map.fill(0);

    int num_Mines = 5;
    play(map, num_Mines);
  }
  public static int[][] play(int[][] map, int m){
    //create a array to track location for each mine;
    int[] mine = new int[m];
    //height and weidth of map;
    int h = map.length;
    int w = map[0].length;

    //initialize mine location;
    //place all mine at the begining of map;
    for(int i=0; i<m; i++){
      mine[i] = i;
      map[(int)i/w][(int)i%w] = -1;
    }
    /* Helper code to print map;
    for(int[] a : map){
      for(int b : a){
        System.out.print(" " + b + " ");
      }
      System.out.println("\n");
    }*/

    //create a Random gegrator;
    Random rand = new Random();
    //
    for(int i =m; i< map.length * map[0].length; i++){
      int n = rand.nextInt(i);
      if(n<m){
        //swap mine; move mine from previous place to the new place;
        map[(int)mine[n]/w][(int)mine[n]%w] = 0;
        map[(int)i/w][(int)i%w] = -1;
        //record mine current place;
        mine[n] = i;
      }
    }
    /* Helper code to print map;
    for(int[] a : map){
      for(int b : a){
        System.out.print(" " + b + " ");
      }
      System.out.println("\n");
    }
    */
    return map;
  }
}
