# Notes on JAVA

## 25/10/2023

- By default decimal is double in java
- Type conversion can be done by appending .f or .d (10.f, 12.d)
- Everything in lang package can be directly used, we don't need to import it
  - Implicitly imported
  - Wrapper classes (String, Integer, Float)
    ![Alt text](image.png)
  - <b>lang is a package, and it contains classes </b>

- We cannot overload operators in java
- **printf and scanf can accept 'n' no of arguments**

***

## 30/10/23

### Switch Case

- Syntax

- ```bash
    switch(constant){
        case const_1 : { statements; break; }
        case const_2 : { statements; break; }
        case const_3 : { statements; break; }
        default : { statements; break };
    }
    ```

### JAVA Packages

-

![Alt text](image-2.png)

-

![Alt text](image-1.png)

### Class in JAVA

```bash
class JavaClass{
    variable;(local, instance, static-memeory allocation, stack, heap, metaspace(native-heap)

    methods; (instance, static)

    constructors;

    instance blocks;

    static blocks;
}
```

- Default constructor is invoked when it is not defined
- Parameterized constructor is a defined construct

  - ```bash
    Class ABC{
        ABC(String a, int b){

        }
    }

    ABC ob = new ABC("A", 10);
    ```

- So, we need to pass values while creating an object of that class
- Empty constructor

  - ```bash
    Class ABC{
        ABC(){

        }
    }

    ABC ob = new ABC();
    ```

- By default class attributes are initialized to NULL or 0
- Access specifiers  
  - public  
  - private
  - protected
  - default  

- **Default access specifier is 'default'**
- **Default members can only be accessed in the current program**
- **Public members can be accessed throughtout the JRE**


*If class is public, filename is same to the class*

- Hence we cannot have multiple public classes in a Program
- we cannot access private attribute by objects

![Alt text](image-3.png)

# Inheritance & Multi-threading

- Multiple inheritance is not directly supported in java.
- One of the classes has to be an interface

## Types of Inheritance

1. Single
  ![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20220728111827/1-660x329.jpg)

2. Multi-level
  ![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20220728111913/2-660x329.jpg)

3. Heirarchial  
  ![Alt text](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20221025185149/Hierarchical-Inheritance-in-Java.jpg)

4. Multiple
  ![Multiple](https://media.geeksforgeeks.org/wp-content/uploads/20220728112121/3-660x329.jpg)

5. Hybrid
  ![Hybrid](https://media.geeksforgeeks.org/wp-content/uploads/20220728112142/4-660x330.jpg)


## Abstract Method vs Concrete Method

| **Abstract Class** | **Concrete Class** |
| ------------------ | ------------------ |
| An abstract class is declared using abstract modifier. | A concrete class is not declared using the abstract modifier. |
| An abstract class cannot be directly instantiated using the new keyword. | A concrete class can be directly instantiated using the new keyword. |
| An abstract class may or may not contain abstract methods. | A concrete class cannot contain an abstract method. |
| An abstract class cannot be declared as final. | A concrete class can be declared as final. |
| Implementing an interface is possible by not providing implementations of all of the interface's methods. For this, a child class is needed. | Easy implementation of all of the methods in the interface. |


## Interfaces vs Abstract class

| **Abstract class** | **Interface** |
|---|---|
| 1) Abstract class can have abstract and non-abstract methods. | Interface can have only abstract methods. Since Java 8, it can have default and static methods also. |
| 2) Abstract class doesn't support multiple inheritance. | Interface supports multiple inheritance. |
| 3) Abstract class can have final, non-final, static and non-static variables. | Interface has only static and final variables. |
| 4) Abstract class can provide the implementation of an interface. | Interface can't provide the implementation of an abstract class. |
| 5) The abstract keyword is used to declare an abstract class. | The interface keyword is used to declare an interface. |
| 6) An abstract class can extend another Java class and implement multiple Java interfaces. | An interface can extend another Java interface only. |
| 7) An abstract class can be extended using the keyword "extends". | An interface can be implemented using the keyword "implements". |
| 8) A Java abstract class can have class members like private, protected, etc. | Members of a Java interface are public by default. |
| 9) Example: <br> `public abstract class Shape {` <br> `public abstract void draw();` <br> `}` | Example: <br> `public interface Drawable {` <br> `void draw();` <br> `}` |

