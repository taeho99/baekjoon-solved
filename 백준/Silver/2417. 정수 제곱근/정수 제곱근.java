import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		
		long lo = 0, hi = num;
		long result = 0;
		
		while(lo <= hi) {
			long mid = (lo+hi)/2;
			if(Math.pow(mid, 2) >= num) {
				result = mid;
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		System.out.println(result);
	}

}