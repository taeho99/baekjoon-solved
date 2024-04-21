import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] bnp = new int[2], timing = new int[2];
        bnp[0] = timing[0] = input.nextInt();
        int[] price = new int[14];
        for(int i=0; i<14; i++) {
            price[i] = input.nextInt();
            bnp[1] += bnp[0]/price[i];
            bnp[0] -= (bnp[0]/price[i])*price[i];

            if(i >= 3 && price[i] > price[i-1] && price[i-1] > price[i-2] && price[i-2] > price[i-3]) {
                timing[0] += timing[1]*price[i];
                timing[1] = 0;
            } else if (i >= 3 && price[i] < price[i-1] && price[i-1] < price[i-2] && price[i-2] < price[i-3]) {
                timing[1] += timing[0]/price[i];
                timing[0] -= (timing[0]/price[i])*price[i];
            }
        }
        int t = timing[0] + timing[1] * price[13];
        int b = bnp[0] + bnp[1] * price[13];
        if(t > b) System.out.println("TIMING");
        else if(t < b) System.out.println("BNP");
        else System.out.println("SAMESAME");
    }
}
