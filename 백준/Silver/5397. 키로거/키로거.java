import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
        	List<Character> result = new LinkedList<>();
            String in = br.readLine();
            int idx = 0;

            for (char c : in.toCharArray()) {
                if(c != '<' && c != '>' && c != '-') {
                    result.add(idx++, c);
                } else {
                    if(c == '<') {
                        idx--;
                        if(idx == -1) idx = 0;
                    } else if (c == '>') {
                        idx++;
                        if(idx == result.size() + 1) idx--;
                    } else {
                        if(idx != 0) {
                            result.remove(--idx);
                        }
                    }
                }
            }
            for(char c : result) {
            	sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
