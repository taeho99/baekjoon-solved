import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        int[][] a = new int[100][100];
        int result = 0;
        for(int i=0; i<T; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            for(int j=0; j<10; j++) {
                for(int k=0; k<10; k++) {
                    if (a[x+j][y+k] == 0) {
                       result++;
                       a[x+j][y+k] = 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
