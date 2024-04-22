import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int p, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l, n);

            boolean isNotExistRoom = true;
            for (Room room : rooms) {
                if(!room.isFull() && room.isEnterValid(player)) {
                    room.addPlayer(player);
                    isNotExistRoom = false;
                    break;
                }
            }
            if(isNotExistRoom) {
                Room room = new Room(new ArrayList<>(), player.level);
                room.addPlayer(player);
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            Collections.sort(room.players);
            if(room.isFull())
                sb.append("Started!").append('\n');
            else
                sb.append("Waiting!").append('\n');
            for (Player player : room.players) {
                sb.append(player.level).append(' ').append(player.nickname).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    static class Room {
        List<Player> players;
        int limitLevel;

        public Room(List<Player> players, int limitLevel) {
            this.players = players;
            this.limitLevel = limitLevel;
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public boolean isEnterValid(Player player) {
            return limitLevel - 10 <= player.level && player.level <= limitLevel + 10;
        }

        public boolean isFull() {
            return players.size() >= m;
        }
    }
}
