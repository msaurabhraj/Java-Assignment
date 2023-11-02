import java.util.*;

public class jaggedarray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = s.nextInt();
        int i, j;
        int a[][] = new int[n][];
        int ncol;
        
        for (i = 0; i < n; i++) {
            System.out.println("Enter number of columns for row " + (i + 1) + ": ");
            ncol = s.nextInt();
            a[i] = new int[ncol];
            
            for (j = 0; j < ncol; j++) {
                System.out.println("Enter number for row " + (i + 1) + ", column " + (j + 1) + ": ");
                a[i][j] = s.nextInt();
            }
        }
        
        System.out.println("Jagged Array:");
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}
