import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<9; i++) {
			arr.add(input.nextInt());
			sum += arr.get(i);
		}
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - (arr.get(i) + arr.get(j)) == 100) {
					arr.remove(i);
					arr.remove(j-1);
					i=8;
					break;
				}
			}
		}
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++)
			System.out.println(arr.get(i));
	}
}
