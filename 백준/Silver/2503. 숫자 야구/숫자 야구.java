import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[988];
        int n = Integer.parseInt(br.readLine());

        for(int i=123; i<=987; i++ ) {
            String s = String.valueOf(i);
            if(s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0')
                continue;
            if(s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2))
                continue;
            check[i] = true;
        }

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            HashMap<Character, Integer> map = new HashMap<>();
            for(int one = 0; one < 3; one++) {
                map.put(num.charAt(one), one);
            }

            for(int j=123; j<=987; j++) {
                if(check[j]) {
                    int ns = 0, nb = 0;
                    String compare = String.valueOf(j);
                    for(int one = 0; one < 3; one++) {
                        char key = compare.charAt(one);
                        if(map.containsKey(key)) {
                            if(map.get(key) == one)
                                ns++;
                            else
                                nb++;
                        }
                    }
                    if(ns == strike && nb == ball) check[j] = true;
                    else check[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean b : check) {
            if(b) count++;
        }
        System.out.println(count);
    }
}
