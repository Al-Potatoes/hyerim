package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11582 {

  static int N;
  static int[] A;
  static int k;
  static int[] B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    B = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    k = Integer.parseInt(br.readLine());

    int size = N / k;

    for (int i = 0; i < N; i += size) {
      rMergeSort(A, i, i + size - 1);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(A[i]).append(" ");
    }
    System.out.println(sb);
  }

  public static void rMergeSort(int[] A, int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      rMergeSort(A, l, m);
      rMergeSort(A, m + 1, r);
      merge(A, l, m, r);
    }
  }

  public static void merge(int[] A, int l, int m, int r) {
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
