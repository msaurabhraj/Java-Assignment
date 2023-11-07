import java.util.*;
public class Mdig {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int a = s.nextInt();
        System.out.println("Least significant number: "+sum(n));
        
        
    }

    static int num(int n){
        String str = Integer.toString(n);
        int len = str.length();

        int msd =  n/(int)Math.pow(10,len-1);
        int lsd = n % 10;
        int multiplier = (int)Math.pow(10, len - 1);

        // Swap the MSD and LSD.
        int newNumber = (lsd * multiplier) + (n % (multiplier / 10)) - msd + msd * (int)Math.pow(10, len - 1);

        return newNumber;


    }
}
