import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        boolean[] arr=new boolean[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt()==1;
        while(m-->0) {
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
            if (a==1)
                arr[b-1]=c==1;
            else if (a==2)
                for(int i=b-1;i<c;i++) arr[i]=!arr[i];
            else Arrays.fill(arr,b-1,c,a != 3);
        }
        for(boolean b:arr) System.out.print((b?"1":"0")+" ");
    }
}
