import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), r = input.nextInt(), c = input.nextInt();
        recur((int)Math.pow(2, n), r, c);
        System.out.println(count);
    }
    private static void recur(int size, int row, int col) {
        if(size == 1)
            return;
        if (row < size/2 && col < size/2) {
            recur(size/2, row, col);
        } else if (row < size/2 && col >= size/2) {
            count += size*size/4;
            recur(size/2, row, col-size/2);
        } else if (row >= size/2 && col <size/2) {
            count += size*size/4*2;
            recur(size/2, row-size/2, col);
        } else {
            count += size*size/4*3;
            recur(size/2, row-size/2, col-size/2);
        }
    }
}
