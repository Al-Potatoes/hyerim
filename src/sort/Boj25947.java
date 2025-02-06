package sort;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj25947 {
  int n, b, a;
  int[] prices;

  public static void main(String[] args) throws IOException {
    new Boj25947().solve();
  }

  public void solve() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    b = Integer.parseInt(input[1]);
    a = Integer.parseInt(input[2]);

    prices = new int[n];
    input = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(prices);
    System.out.println(getMaxGifts());
  }

  public int getMaxGifts() {
    int left = 0, right = 0;
    boolean valid = true;

    for (int i = 0; i < a; i++) {
      b -= prices[i] / 2;
      right = i + 1;
      if (b < 0) {
        valid = false;
        return i;
      }
    }

    if (valid) {
      while (right < n) {
        if (right - left < a) {
          b -= prices[right] / 2;
          if (b < 0) break;
          right++;
        } else {
          if (a > 0) b -= prices[left++] / 2;
          else {
            b -= prices[right];
            if (b < 0) break;
            right++;
          }
        }
      }
      return right;
    }
    return right;
  }
}

