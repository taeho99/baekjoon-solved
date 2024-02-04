import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] require; //  {‘A’, ‘C’, ‘G’, ‘T’}
    static int[] now;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sLen = Integer.parseInt(st.nextToken());
        int pLen = Integer.parseInt(st.nextToken());

        s = br.readLine();
        int left = 0;
        int right = pLen - 1;
        st = new StringTokenizer(br.readLine());
        require = new int[4];
        now = new int[4];
        for(int i=0; i<4; i++) {
            require[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = left; i <= right; i++) {
            nowPlus(i);
        }
        if (check()) result++;
        for(int i = pLen; i < sLen; i++) {
            nowMinus(i - pLen);
            nowPlus(i);

            if (check()) result++;
        }
        System.out.println(result);
    }

    static void nowMinus(int i) {
        switch (s.charAt(i)) {
            case 'A' -> now[0]--;
            case 'C' -> now[1]--;
            case 'G' -> now[2]--;
            case 'T' -> now[3]--;
        }
    }

    static void nowPlus(int i) {
        switch (s.charAt(i)) {
            case 'A' -> now[0]++;
            case 'C' -> now[1]++;
            case 'G' -> now[2]++;
            case 'T' -> now[3]++;
        }
    }

    static boolean check() {
        for(int i=0; i<4; i++) {
            if (now[i] < require[i]) return false;
        }
        return true;
    }
}