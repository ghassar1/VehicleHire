import java.util.*;
/**
 * Write a description of class Commercial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Commercial extends Vehicle
{
 
    private int payLoad;
    /**
     * Constructor for objects of class Commercial
     */
    public Commercial()
    {
     
    }

  public void readData(Scanner scanner)
  {
      super.readData(scanner);
      String temp = scanner.next();
      Integer int1 = Integer.parseInt(temp);
      this.payLoad = int1; 
  }
  public void displayDetails ()
  {
   super.displayDetails (); 
   System.out.println("PayLoad: " + payLoad + "\t");
  }
}
