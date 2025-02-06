package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11004 {
  private static int[]A,B;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    A = new int[N];
    B= new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    rMergeSort(0,N-1);
    System.out.println(A[K-1]);
  }

  public static void rMergeSort(int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      rMergeSort(l, m);
      rMergeSort(m + 1, r);
      merge(l, m, r);
    }
  }

  public static void merge(int l, int m, int r) {
    int i = l;
    int j = m + 1;
    int k = l;

    while (i <= m && j <= r) {
      if (A[i] <= A[j]) {
        B[k++] = A[i++];
      } else {
        B[k++] = A[j++];
      }
    }

    while (i <= m) {
      B[k++] = A[i++];
    }

    while (j <= r) {
      B[k++] = A[j++];
    }

    for (k = l; k <= r; k++) {
      A[k] = B[k];
    }
  }
}
