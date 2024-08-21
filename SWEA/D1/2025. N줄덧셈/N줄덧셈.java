public class Solution {
    public static void main(String[] args) {
        int num = new java.util.Scanner(System.in).nextInt();
        int sum = num;
        while(num-- > 0) sum += num;
        System.out.println(sum);
    }
}
