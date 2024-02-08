package testPack;
import java.util.*;

public class Test {
  public static List<Integer> getSeries(int n){
    List<Integer> series = new ArrayList<Integer>();
    int i =-1, j = 1, k;
    while(n>0) {
      series.add(i+j);
      k = i;
      i = j;
      j = k+j;
      n--;
    }
    return series;
  }
    public static void main(String[] args) {
      
       Scanner sc = new Scanner(System.in);
       int count = sc.nextInt();
        System.out.println(Test.getSeries(count));
        sc.close();
    }
}
