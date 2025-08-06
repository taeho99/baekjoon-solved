import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());

		int[] freq = new int[10001];

		for(int idx=0; idx<size; idx++) {
			freq[Integer.parseInt(br.readLine())]++;
		}

		for(int idx=1; idx<10001; idx++) {
			for(int j=0; j<freq[idx]; j++) {
				sb.append(idx).append('\n');
			}
		}
		System.out.print(sb);
	}
}
