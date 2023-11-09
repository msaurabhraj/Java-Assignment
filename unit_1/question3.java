import java.util.*;

class ChangeMSB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        // Ensure n is positive
        if (n < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            String nStr = Integer.toString(n);

            if (nStr.length() > 1) {
                String msb = nStr.substring(0, 1);
                String lsb = nStr.substring(1);
                String result = lsb + msb;
                System.out.println("MSB to LSB: " + result);
            } else {
                System.out.println("The number has only one digit, so no change needed.");
            }
        }

        scanner.close();
    }
}
