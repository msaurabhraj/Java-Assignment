import java.util.*;

class Carr {
    private String brand, model;
    private int year;
    private double price;
    private int totalUnits, unitsSold;

    Carr(String brand, String model, int year, double price, int totalUnits) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.totalUnits = totalUnits;
        this.unitsSold = 0;
    }

    void update(double newPrice) {
        this.price = newPrice;
        System.out.println("Price updated successfully!");
    }

    void sell() {
        if (unitsSold < totalUnits) {
            unitsSold += 1;
            System.out.println("Car sold successfully!");
        } else {
            System.out.println("No more units available for sale.");
        }
    }

    int totSales() {
        return unitsSold;
    }

    void display() {
        System.out.println("\n\t\t\tCar Details:");
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Price: " + this.price);
        System.out.println("Units available: " + (totalUnits - unitsSold));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter total units: ");
        int totalUnits = scanner.nextInt();
        Carr car = new Carr(brand, model, year, price, totalUnits);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Car Details");
            System.out.println("2. Update Price");
            System.out.println("3. Sell a Car");
            System.out.println("4. Display Total Sales");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    car.display();
                    break;
                case 2:
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    car.update(newPrice);
                    break;
                case 3:
                    car.sell();
                    break;
                case 4:
                    System.out.println("Total Sales: " + car.totSales());
                    break;
                case 0:
                    System.out.println("Exiting the program.!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close(); // Close the scanner when done.
    }
}
