import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ.2839 설탕배달
 * 
 * 1. 
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 1 || num == 2 || num == 4 || num == 7) {
			System.out.print("-1");
			return;
		} 
		if(num%5 == 0) {
			System.out.print(num/5);
			return;
		}
		
		System.out.print(num/5 + ((num%5)%2 == 1 ? 1 : 2));
	}
}
