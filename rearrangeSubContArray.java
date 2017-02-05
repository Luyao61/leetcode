import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class rearrangeSubContArray {
  public static void main(String[] args) {

    int A[] = new int[]{1,2,6,5,5,8,9};
    System.out.println(solution(A));

  }
  public static int solution(int[] A){
    int[] copy = A.clone();

    Arrays.sort(copy);

    int start = 0;
    int end = A.length - 1;

    int ans = A.length;

    while(A[start] == copy[start]){
      start++;
      ans--;
    }

    while(A[end] == copy[end]){
      end--;
      ans--;
    }
    return ans;
  }
}
