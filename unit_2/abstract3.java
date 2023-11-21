

abstract class A{
    abstract void disp1();
}
abstract class B {
    abstract void foo();    
}

class C extends A implements B{
   void foo(){
        System.out.println("fooo");
    }
void disp1(){
    System.out.println("Dipp1111");
}

}
class Main{
    public static void main(String[] args) {
        C ob = new C();
        ob.foo();
        ob.disp1();
    }
}