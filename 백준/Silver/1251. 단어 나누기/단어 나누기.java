import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		
		List<String> result = new ArrayList<>();
		
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				StringBuilder sb = new StringBuilder();
				String s1 = sb.append(s.substring(0, i)).reverse().toString();
				sb = new StringBuilder();
				String s2 = sb.append(s.substring(i, j)).reverse().toString();
				sb = new StringBuilder();
				String s3 = sb.append(s.substring(j, n)).reverse().toString();
				result.add(s1 + s2 + s3);
				
			}
		}
		
		Collections.sort(result);
		System.out.println(result.get(0));
	}

}
