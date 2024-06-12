import java.util.*;
class Main{
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<6;i++)
            list.add(sc.nextInt());
        int t=sc.nextInt(),p=sc.nextInt();
        System.out.println(list.stream().mapToInt(i -> (i+t-1)/t).sum());
        System.out.println(n/p+" "+n%p);
    }
}