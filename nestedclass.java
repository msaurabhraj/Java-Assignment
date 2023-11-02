class outerClass {
    static int  outer_x = 10;
    int outer_y = 20;
    private static int  outer_private = 30;

     static class staticnestedClass{
        void display(){
            System.out.println("outer_x: "+outer_x);

            System.out.println("outer_private:"+outer_private);

            outerClass out = new outerClass();
            System.out.println("outer_y: "+out.outer_y);
        }
     }
    
}
class innerclass{
    public static void main(String[] args) {
        outerClass.staticnestedClass ob = new outerClass.staticnestedClass();
        // if class is not  static we have to create object  to  outerclass to access inner class
        // outerClass outerobject = new outerClass();
        // outerClass.innerclass ob = outerobject.new innerclass();
        ob.display();
    }
}
