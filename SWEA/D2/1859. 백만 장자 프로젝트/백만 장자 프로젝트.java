import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N일간 가격 주어지고 하루에 하나씩 구매 가능
 * 2. 구매한걸 높은 가격에 판매 가능
 * 3. 최대 이익은?
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCase = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=totalCase; testCase++) {
			int size = Integer.parseInt(br.readLine());
			int[] price = new int[size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<size; idx++) {
				price[idx] = Integer.parseInt(st.nextToken());
			}
			
			//거꾸로 탐색하면서 maxPrice가 현재 값보다 높으면 그 차익을 sum에 추가
			//maxPrice보다 높은 가격을 만나면 maxPrice 업데이트
			int maxPrice = price[size-1];
			long sum = 0;
			for(int idx=size-2; idx>=0; idx--) {
				if(price[idx] > maxPrice) {
					maxPrice = price[idx];
				} else {
					sum += maxPrice - price[idx];
				}
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}

}
