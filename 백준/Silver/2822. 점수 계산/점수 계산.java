import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int[] score = new int[8];
        int[] result = new int[5];
        for(int i=0; i<score.length; i++) {
            score[i] = input.nextInt();
        }

        for(int i=0; i<5; i++) {
            int max = Arrays.stream(score).max().getAsInt();
            List<Integer> list = Arrays.stream(score).boxed().collect(Collectors.toList());
            int idx = list.indexOf(max);
            score[idx] = 0;
            result[i] = idx;
            sum += max;
        }

        System.out.println(sum);
        Arrays.sort(result);
        for (int i : result) {
            System.out.print((i+1) + " ");
        }
    }
}
