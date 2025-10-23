import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] word = br.readLine().toCharArray();

		int cnt = 0;
		for(int i=0; i<=text.length - word.length; i++) {
			boolean flag = true;
			for(int j=0; j<word.length; j++) {
				if(text[i+j] != word[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
				i += word.length-1;
			}
		}
		System.out.println(cnt);
	}
}
