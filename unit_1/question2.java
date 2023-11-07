import java.util.*;
class Pattern{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch = 0 ;
        int n ,r;
        do{
            System.out.println("0.Exit");
            System.out.println("1. Permutation");
            System.out.println("2. Combination");
            System.out.println("3. Pattern");
            System.out.println("Enter your Choice: ");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the value of N: ");
                    n = s.nextInt();
                    System.out.println("Enter the value of R: ");
                    r = s.nextInt();
                    if (n == r){
                        System.out.println("Permutation: "+fact(n));
                    }
                    else{
                        int top = fact(n);
                        int bottom = fact(n-r);
                        int res = top/bottom;
                        System.out.println("Permutaion: "+ res);
                    }
                    break;
                case 2:
                    System.out.println("Enter the value of N: ");
                    n = s.nextInt();
                    System.out.println("Enter the value of R: ");
                    r = s.nextInt();
                    if (n == r){
                        System.out.println("Combination: "+fact(n)/fact(r));
                    }
                    else{
                        int top = fact(n);
                        int bottom = fact(r)*fact(n-r);
                        int res = top/bottom;
                        System.out.println("Permutaion: "+ res);
                    }
                    break;
                    case 3:
                        System.out.print("Enter the value of N: ");
                        n = s.nextInt();
                        pattern(n);
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
            }

        }while(ch!=0);

    }

    static int fact(int n){
        if (n<=1){
            return n ;
        }
        else{
            return (n* fact(n-1));
        }
    }
    static void pattern(int n){
        int val = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(val+" ");
                val +=1;
            }
            System.out.println();
        }
    }
    
    
}
