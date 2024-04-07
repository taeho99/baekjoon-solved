import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] freq = new int[100];
        int sum = 0;
        for(int i=0; i<10; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            freq[n/10]++;
        }
        System.out.println(sum/10);
        int max = 0, idx = -1;
        for(int i=0; i<100; i++) {
            if(freq[i] > max) {
                max = freq[i];
                idx = i;
            }
        }
        System.out.println(idx*10);
    }
}
