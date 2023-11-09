abstract class C1{
    int a;
    abstract void setA(int a);
    void disp()
    {
        System.out.println("A: "+this.a);
    }
}

class Child1 extends C1{
    int aa;
    Child1(int a){
        this.setA(a);
    }
    void setA(int a){
        this.aa = a;
        super.a = a;
    }
    void disp(){
        System.out.println("AA" + this.aa);
        super.disp();
    }
}
class abstract1{
    public static void main(String[] args) {
        Child1 ch1 = new Child1(5);
        ch1.disp();

    }
}