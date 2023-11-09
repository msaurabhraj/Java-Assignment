import java.util.*;

class Area {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int ch = 0;
        do {
            System.out.println("Area Calculation");
            System.out.println("1.Area of Triangle");
            System.out.println("2.Volume of Cornetto");
            System.out.println("3.Shortest Distance");
            System.out.println(("0.Exit"));

            ch = sa.nextInt();
            switch (ch) {
                //Area of Park 
                case 1:
                    System.out.println("Enter the sides: ");
                    float a = sa.nextFloat();
                    float b = sa.nextFloat();
                    float c = sa.nextFloat();
                    System.out.println("Area of Triangular Park: " + areacalc(a, b, c));
                    break;
                    //Volume Of Cornetto
                case 2:
                    System.out.println("Enter the Radius: ");
                    float r = sa.nextFloat();
                    System.out.println("Enter the Height: ");
                    float h = sa.nextFloat();
                    System.out.println("Volume of Cornetto: " + areacalc(r, h));
                    break;
                    //Shortest Distance
                case 3:
                    System.out.println("Enter the X cordinates: ");
                    float x1 = sa.nextFloat();
                    float x2 = sa.nextFloat();
                    System.out.println("Enter the Y Cordinates: ");
                    float y1 = sa.nextFloat();
                    float y2 = sa.nextFloat();
                    System.out.println("Shortest Distance: " + areacalc(x1, x2, y1, y2));
                    break;
                case 0:
                    System.out.println("Exiting the program.!!");
                    break;
                default:
                    System.out.println("Invalid input ");
                    break;
            }

        } while (ch !=0);
        sa.close();
    } 

    static double areacalc(float a, float b, float c) {
        double s = (a + b + c) / 2;
        double res = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return res;
    }

    static float areacalc(float r, float h) {
        float res = (22 / 7 * r * r * h) / 3;
        return res;
    }

    static double areacalc(float x1, float x2, float y1, float y2) {

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;

    }

}
