import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String s;
        while(!((s = br.readLine()).equals("end"))) {
            boolean flag = false;
            boolean flag2 = true;
            int mo = 0, ja = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(set.contains(c)) { //모음이면
                    flag = true;
                    mo++; ja = 0;
                } else { //자음이면
                    ja++; mo = 0;
                }
                if(mo == 3 || ja == 3) {
                    flag = false;
                    break;
                }
                if(i != 0 && c != 'e' && c != 'o' && c == s.charAt(i-1)) {
                    flag = false;
                    break;
                }
            }
            if(!flag || !flag2) {
                sb.append("<").append(s).append("> is not acceptable.").append('\n');
            } else {
                sb.append("<").append(s).append("> is acceptable.").append('\n');
            }
        }
        System.out.print(sb);
    }
}
