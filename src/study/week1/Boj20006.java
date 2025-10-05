package study.week1;

import java.io.*;
import java.util.*;

public class Boj20006 {
    static class Player {
        int level;
        String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();
            players.add(new Player(level, nick));
        }

        ArrayList<Integer> firstLevels = new ArrayList<>();
        ArrayList<ArrayList<Player>> rooms = new ArrayList<>();

        for (Player player : players) {
            boolean joined = false;
            for (int i = 0; i < rooms.size(); i++) {
                int firstLevel = firstLevels.get(i);
                if (rooms.get(i).size() < m &&
                    player.level >= firstLevel - 10 &&
                    player.level <= firstLevel + 10) {
                    rooms.get(i).add(player);
                    joined = true;
                    break;
                }
            }

            if (!joined) {
                firstLevels.add(player.level);
                ArrayList<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                rooms.add(newRoom);
            }
        }

        for (ArrayList<Player> room : rooms) {
            if (room.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            room.sort(Comparator.comparing(p1 -> p1.nickname));

            for (Player p1 : room) {
                sb.append(p1.level).append(" ").append(p1.nickname).append("\n");
            }
        }

        System.out.print(sb);
    }
}

//TODO: (실버2) p만큼의 플에이어가 존재하며 한 방의 최대 인원은 m명이다. +-10까지만 입장 가능하고 아니라면 새로운 방을 생성하자
// 첫 시도 메모리 21288KB / 시간 248ms
// 리팩토링 후(sb 추가, player 클래스 생성) 메모리 14484KB / 시간 124ms
