import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		
		int zeroCnt = 0, oneCnt = 0;
		for (char ch : str) {
			if(ch == '0') zeroCnt++;
			else oneCnt++;
		}
		
		boolean[] check = new boolean[str.length];
		
		int nowZero = 0, nowOne = 0;
		
		for(int idx=0; idx<str.length; idx++) {
			if(nowZero == zeroCnt/2) break;
			if(str[idx] == '1') continue;
			nowZero++;
			check[idx] = true;
		}
		
		for(int idx=str.length-1; idx>=0; idx--) {
			if(nowOne == oneCnt/2) break;
			if(str[idx] == '0') continue;
			nowOne++;
			check[idx] = true;
		}

		StringBuilder sb = new StringBuilder();
		for(int idx=0; idx<str.length; idx++) {
			if(check[idx]) sb.append(str[idx]);
		}
		System.out.print(sb);
	}
}