import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(new StringBuffer(br.readLine()).reverse().toString());
		System.out.println(Integer.parseInt(new StringBuffer("" + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))).reverse().toString()));
	}
}
