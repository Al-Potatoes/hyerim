package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj20006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Object[]> list = new ArrayList<>();
        int roomCnt = 0;
        int[] criteria = new int[p];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            boolean joined = false;
            for (int j = 0; j < roomCnt; j++) {
                int targetIndex = j;
                int count = (int) list.stream()
                        .filter(a -> (int) a[0] == targetIndex)
                        .count();
                if (criteria[j] >= l - 10 && criteria[j] <= l + 10 && count < m) {
                    list.add(new Object[]{j, l, n});
                    //System.out.println(j+" "+l+" "+n+" ");
                    joined = true;
                    break;
                }
            }
            if (!joined) {
                criteria[roomCnt] = l;
                //System.out.println(roomCnt+" "+l+" "+n+" ");
                list.add(new Object[]{roomCnt++, l, n});
            }
        }

        for (int i = 0; i < roomCnt; i++) {
            ArrayList<Object[]> current = new ArrayList<>();
            int currentIdx = i;
            for (Object[] player : list) {
                if ((int) player[0] == currentIdx) {
                    current.add(player);
                }
            }

            if (current.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            current.sort(Comparator.comparing(a -> (String) a[2]));
            for (Object[] row : current) {
                System.out.println(row[1] + " " + row[2]);
            }
        }
    }
}

//TODO: (실버2) p만큼의 플에이어가 존재하며 한 방의 최대 인원은 m명이다. +-10까지만 입장 가능하고 아니라면 새로운 방을 생성하자
// 첫 시도 메모리 21288KB / 시간 248ms

