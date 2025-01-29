import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] n = new int[size];
        for(int i=0; i<size; i++) {
            n[i] = input.nextInt();
        }
        quickSort(n, 0, size - 1);
        for(int i=0; i<size; i++) {
            System.out.println(n[i]);
        }
    }
    public static void quickSort(int[] data, int start, int end) {
        if(start >= end) {
            return;
        }
        int key = start;
        int i = start + 1;
        int j = end;
        int temp;

        while(i <= j) {
            while(i <= end && data[i] <= data[key]) {
                i++;
            }
            while(j > start && data[j] >= data[key]) {
                j--;
            }
            if(i > j) {
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else {
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        quickSort(data, start, j-1);
        quickSort(data, j+1, end);
    }
}