import java.util.*;
/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck extends Commercial
{
    private String feature1;
    private String feature2;
    /**
     * Constructor for objects of class Truck
     */
    public Truck()
    {
    super();
    }
    public void displayDetails ()
    {
     super.displayDetails ();
     System.out.println( "feature1: " +
     feature1 + "\t" + "feature2: " + feature2);
    }
    public void readData(Scanner scanner)
    {
      super.readData(scanner);
      this.feature1 = scanner.next(); 
    if(scanner.hasNext() == true)
    {
      this.feature2 = scanner.next();
    }
    }
}
