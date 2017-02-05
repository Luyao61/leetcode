import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class maxTime {
  public static void main(String[] args) {

    System.out.println(maxTime(0,3,7,0));

  }

  public static String maxTime(int a, int b, int c, int d){

    PriorityQueue<String> q = new PriorityQueue<>(1*2*3*4, new Comparator<String>(){
      public int compare(String a, String b){
        for(int i =0; i<4 ;i++){
          if( a.charAt(i)-'0' > b.charAt(i)-'0' ){
            return -1;
          }
          else if(a.charAt(i)-'0' < b.charAt(i)-'0'){
            return 1;
          }
        }
        return 0;
      }
    });


    int[] time = {a, b, c, d};
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        if(j == i) continue;
        for(int k=0; k<4; k++){
          if(k==j || k == i) continue;
          for(int l=0; l<4; l++){
            if(l==i || l==j || l==k) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(time[i]);
            sb.append(time[j]);
            sb.append(time[k]);
            sb.append(time[l]);
            q.offer(sb.toString());
          }
        }
      }
    }
    while(!q.isEmpty()){
      String s = q.poll();
      String hour = s.substring(0,2);
      String minute = s.substring(2,4);
      if(isValidTime(hour, minute)){
        return hour + ":" + minute;
      }
    }

    return "NOT POSSIBLE";
  }
  public static boolean isValidTime(String h, String m){
      int hour = Integer.parseInt(h);
      int minute = Integer.parseInt(m);

      if(hour>23 || minute>59){
        return false;
      }
    return true;
  }
}
