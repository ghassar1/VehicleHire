import java.util.*;
/**
 * Write a description of class Van here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Van extends Commercial
{
    // instance variables - replace the example below with your own
 
    private double loadCompartmentVolume;
    private boolean slidingSideDoor;
   
    /**
     * Constructor for objects of class Van
     */
    public Van()
    {
        // initialise instance variables
      super();
    }
    public void displayDetails ()
    {
     super.displayDetails ();
     System.out.println( "loadCompartmentVolume: " +
     loadCompartmentVolume + "\t" + "slidingSideDoor: " + slidingSideDoor);
    }
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
     
        String temp1 = scanner.next();
        Double d1 = Double.parseDouble(temp1);
        this.loadCompartmentVolume = d1;
        String temp2 = scanner.next();
        Boolean b1 = Boolean.parseBoolean(temp2);
        this.slidingSideDoor = b1;
    }
}
