package recursion;

import java.io.IOException;
import java.util.Scanner;

public class Boj1629 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int a=sc.nextInt();
    int b=sc.nextInt();
    int c=sc.nextInt();
    System.out.println(division(a,b,c));
  }

  public static long division(long a, long b, long c) {
    if (b == 0) return 1;
    long half = division(a, b / 2, c);
    long result = (half * half) % c;
    if (b % 2 == 1) result = (result * a) % c;
    return result;
  }

}
