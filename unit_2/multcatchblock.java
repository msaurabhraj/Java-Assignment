import java.math.BigDecimal;
import java.math.RoundingMode;

class multcatchblock {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(11);
        BigDecimal b = new BigDecimal(17);
        BigDecimal result = a.divide(b, 8, RoundingMode.FLOOR);   // Round to nearest integer
        System.out.println(result);
    }

    //  try
    //  {    
    //    BigDecimal result = a.divide(b);
    //  }
    //  catch(ArithmeticException e)
    //  {
    //      System.out.println("Arithmetic Error");
    //  }  
    
    //  System.out.println("Program execution continues....");  
}

    

      