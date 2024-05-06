import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    int t = input.nextInt();
    for(int i=0; i<t; i++) {
      int h = input.nextInt();
      int w = input.nextInt();
      int n = input.nextInt();
      
      int y = n % h;
      int x = ((n-1) / h) + 1;
      if(y == 0) y = h;
      System.out.println("" + y + (x < 10 ? "0" + x : x));
    }
  }

}
