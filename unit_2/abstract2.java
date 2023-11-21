abstract class  c1{  //we can not intensiate abstract class
    int a ;
    void set(int a){
        this.a = a;

    }
    void disp(){
        System.out.println("A :" +this.a);
    }
    abstract void abst(); 
    // //this  will throw an error  until class in  not abstract
    //if we have made the abstract clas then if we want to use abstract method then we have to override this methord
}
interface c2{
     abstract  void disp1();

}
class child1 extends c1{
    child1(int a){
        super();
        super.set(a);
    }
    void display(){
        super.disp();;
    }
    void abst(){
        System.out.println("overridden");
    }
    void disp1(){
        System.out.println("interface function");
    }

}
class child2 implements c2{
    public void disp1(){
        System.out.println("interface function");
    }

}
class abstract2
{
    public static void main(String[] args) {
        child1 c = new child1(10);
        c.disp();
        c.abst();
        child2 c1 = new child2();
        c1.disp1();
    }
}