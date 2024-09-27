import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[26];
		String str = input.next();
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
