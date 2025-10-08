import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int elementSize = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] elementList = new int[elementSize];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<elementSize; idx++) {
			elementList[idx] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for(int i=0; i<elementSize; i++) {
			for(int j=i+1; j<elementSize; j++) {
				for(int k=j+1; k<elementSize; k++) {
					int sum = elementList[i] + elementList[j] + elementList[k];
					if(sum <= target) {
						result = Math.max(result, sum);
					}
				}
			}
		}
		System.out.println(result);
	}
}
