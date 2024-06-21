import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int[] memo = new int[m];

        StringBuilder pn = new StringBuilder();
        for(int i=0; i<n*2+1; i++) {
            pn.append(i%2 == 0 ? 'I' : 'O');
        }

        int result = 0;
        for(int i=1; i<m-1; i++) {
            if(s[i] == 'O' && s[i+1] == 'I') {
                memo[i+1] = memo[i-1] + 1;
                if(memo[i+1] >= n && s[i-2*n+1] == 'I') {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
