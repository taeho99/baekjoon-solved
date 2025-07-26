import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		System.out.println(a[0] + " " + a[a.length - 1]);
	}
}
