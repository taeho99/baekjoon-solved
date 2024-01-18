import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        char[][] castle = new char[n][m];

        int row = 0;
        int col = 0;

        for(int i=0; i<n; i++) {
            String in = input.next();
            for(int j=0; j<m; j++) {
                castle[i][j] = in.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            boolean flag = true; //경비원 필요 여부

            for(int j=0; j<m; j++) {
                if (castle[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }

            if (flag) row++;
        }

        for(int i=0; i<m; i++) {
            boolean flag = true; //경비원 필요 여부

            for(int j=0; j<n; j++) {
                if (castle[j][i] == 'X') {
                    flag = false;
                    break;
                }
            }

            if (flag) col++;
        }

        System.out.println(Math.max(row, col));
    }

}
