class Car
{
    String brand,model;
    int year;

    Car(String b,String m, int y ){
        this.brand = b;
        this.model = m ;
        this.year = y;

    }
    Car(){
        System.out.println("hello");
    }
    void display()
    {
        System.out.println("Brand: "+this.brand+"\nModel: "+this.model+"\nYear: "+this.year);
    }

    
}

class Main 
{
    public static void main(String[] args){
        Car c1 = new Car("Tata","nexon",2023);
         Car c2 = new Car("Suxuki","Desire",2021);
         Car c3 = new Car();
        c1.display();
        c2.display();
        System.out.println(c1.brand);
    }


}

class Abc{
    public static void main(String[] args){
        System.out.println("hello");
    }
}
