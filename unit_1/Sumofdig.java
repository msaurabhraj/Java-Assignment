import java.util.*;
class Sumofdig{
    static int sum(int n){
       int s = 0 ;
        while(n!=0){
            s = s+ n%10;
            n= n/10;

        }
        return s;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch = 0 ;
        System.out.println("Enter the number: ");
        int a = s.nextInt();
        System.out.println("Sum of Digit: "+sum(a));
        
    }
}