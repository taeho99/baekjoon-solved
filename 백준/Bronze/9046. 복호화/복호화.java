import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String str = br.readLine();
            int[] arr = new int[26];
            for (char c : str.toCharArray()) {
                if(Character.isLetter(c)) {
                    arr[c - 'a']++;
                }
            }

            int idx = 0;
            for (int i=1; i<26; i++) {
                if(arr[i] > arr[idx])
                    idx = i;
            }

            int count = 0;
            for (int i : arr) {
                if(i == arr[idx]) count++;
            }

            sb.append(count == 1 ? (char)('a' + idx) : '?').append('\n');
        }
        System.out.print(sb);
    }
}
