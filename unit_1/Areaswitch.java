import java.util.*;
class Areaswitch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch = 0 ;
        do{
          System.out.println("Area Calculation");
          System.out.println("1.Area of Triangle");
          System.out.println("Volume of");

        }
        ch = s.nextInt();
        switch(ch){
            case 1:
            System.out.println("Enter radius");
            float r =  s.nextFloat();
            System.out.println("Area oof circle"+areacalc(r));
            break;
            case 2:
            System.out.println("Enter length of side ");
            int sd = s.nextInt();
            System.out.println("Area of square: "+areacalc(sd));
            break;
            case 3:
            System.out.println("Enter length: ");
            float l = s.nextFloat();
            System.out.println("Enter Breadth : ");
            float b = s.nextFloat();
            System.out.println("Area of rectancle: "+areacalc(l,b));
            break;
            case 4:
            System.out.println("Enter the sides: ");
            double s = 
            default:
            System.out.println("Invalid input ");
            break;


    }
} 
      static  float areacalc(float r){
        return 22*r*r/7f;
      }
      static float  areacalc(int a){
        return a*a;
        
      }
      static float areacalc(float a, float b ){
        return a*b;
      }
      static double  areacalc(double a,double b ,double c){
        double s =  a + b + c/2;
        double res = Math.sqrt(s(s-q)*(s-b)*(s-c));
        return res;
      }

      static double

    
    }

