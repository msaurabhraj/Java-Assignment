interface il {
    int a = 10 ;
    //int a; throws an error , variable must be assigned
    public void disp();
    // public void disp1(); every method shoud be override 

}
class C1 implements il{
   public void disp(){
        System.out.println("class c1");

    }

}
class C2 implements il {
    public void disp(){
        System.out.println("class C2");
    }
}
class InterFaceDemo{
    public static void main(String[] args) {
        C1 c = new C1();
        c.disp();
         C2 c2 = new C2();
        c.disp();
        
    }

}