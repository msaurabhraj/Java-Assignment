import java.math.BigDecimal;

class multcatchblock {
    public static void main(String[] args) {
      BigDecimal a = new BigDecimal(11);  
      BigDecimal b = new BigDecimal(17);

     try
     {    
       BigDecimal result = a.divide(b);
     }
     catch(ArithmeticException e)
     {
         System.out.println("Arithmetic Error");
     }  
    
     System.out.println("Program execution continues....");  
}

    }

      