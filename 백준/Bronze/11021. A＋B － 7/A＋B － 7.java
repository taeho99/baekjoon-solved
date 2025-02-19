import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int c = s.nextInt();
		for(int i=0; i<c; i++)
			System.out.printf("Case #%d: %d\n", i+1, s.nextInt() + s.nextInt());
	}
}
