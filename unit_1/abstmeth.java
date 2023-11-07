class A{
    void foo(){
        System.out.println();

    };
}

class B extends A{
    // B(){
    //     super();

    // }

}
class main{
    public static void main(String[] args) {
        B b = new B();
        b.foo();
    }
}