public class Main {
    public static void main(String[] args) {
        var s = new java.util.Scanner(System.in);
        int[] a = new int[4];
        for(int i=0; i<4; i++) a[i] = s.nextInt();
        System.out.print(Math.min(a[0]+a[3], a[1]+a[2]));
    }
}
