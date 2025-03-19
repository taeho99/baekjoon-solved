import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];
        for(int i=0; i<y; i++) {
            map[i] = br.readLine().toCharArray();
            boolean isCloud = false;
            int block = 0;
            for(int j=0; j<x; j++) {
                if(map[i][j] == 'c') {
                    isCloud = true;
                    block = 0;
                    sb.append(0).append(' ');
                } else {
                    if(isCloud) {
                        block++;
                        sb.append(block).append(' ');
                    } else {
                        sb.append(-1).append(' ');
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
