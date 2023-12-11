class person {
    String name;
    int Age;
    String email;

    person(String name,int Age,String email){
        this.name = name;
        this.Age = Age;
        this.email = email;
    }
    public void  displayinfo(){
        System.out.println(name);
        System.out.println(Age);
        System.out.println(email);
    }
    
}
class student extends person{
    int  studentid;
    student(String name,int Age,String email,int studentid){
        super(name, Age, email);
        this.studentid =studentid;
    }
    public void displayinfo(){
        super.displayinfo();
        System.out.println(studentid);
    }
}
class demo{
    public static void main(String args[]){
        student s = new student("saurabh", 12, "rajsaurabh351@gmail.com", 182);
        s.displayinfo();

    }
}