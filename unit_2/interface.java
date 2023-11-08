interface il {
    int a = 10 ;
    public void disp();

}
class C1 implements il{
   public void disp(){
        System.out.println("class c1");

    }

}

class InterFaceDemo{
    public static void main(String[] args) {
        C1 c = new C1();
        c.disp();
        
    }

}