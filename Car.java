
import java.util.*;
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle 
{
    private String bodyType;
    private int numberOfDoors;
    private int numberOfSeats;
    
    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
     super();
    }
    public void displayDetails ()
    {
        super.displayDetails ();
        System.out.println("Body Type: " + bodyType + "\t" + "Number Of doors: " + numberOfDoors + "\t" + "Number of seats: " + numberOfSeats );
    }
    public String getVehicleDetails()
    {
        super.getVehicleDetails();
     return "Body Type: " + bodyType + "\t" + "Number Of doors: " + numberOfDoors + "\t" + "Number of seats: " + numberOfSeats ;
    }
      public void readData(Scanner scanner)
    {
     super.readData(scanner);
     this.bodyType = scanner.next();
     String temp = scanner.next();
     Integer int1 = Integer.parseInt(temp);
     this.numberOfDoors = int1;
     String temp2 = scanner.next();
     Integer int2 = Integer.parseInt(temp2);
     this.numberOfSeats = int2;   
    }
}
