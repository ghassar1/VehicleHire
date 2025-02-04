
import java.util.*;
import java.io.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
   private String customerID, surename, firstName, otherInitials, title;
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surename,String firstName, String otherInitials, String title )
    {
     customerID = "unkown";
     this.surename = surename;
     this.firstName = firstName;
     this.otherInitials = otherInitials;
     this.title = title;
    }
    public Customer()
    {
        
    }
    public void setCustomerId(String customerID)
    {
        this.customerID = customerID;
    }
    public void setSurename(String surename)
    {
        this.surename = surename;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setOtherInitials(String otherInitials)
    {
        this.otherInitials = otherInitials;
    }
     public void setTitle(String title)
    {
        this.title = title;
    }
    public String getCustomerId()
    {
     return customerID;   
    }
    public void printDetails ()
    {
     System.out.println("Customer ID: " + customerID + "Surename: " + surename + "FirstName: " + firstName + "OtherInitials: " + otherInitials + "Title: " + title);   
    }
    public String getDetails()
    {
        return "Customer ID: " + customerID + "Surename: " + surename + "FirstName: " + firstName + "OtherInitials: " + otherInitials + "Title: " + title;
    }
    public void readData(Scanner scanner){
     this.customerID = scanner.next();
     this.surename = scanner.next();
     this.firstName = scanner.next();
     this.otherInitials = scanner.next();
     this.title = scanner.next();
    }
    public void writeData(PrintWriter pWriter)
    {
         String lineOfText = getDetails();    
         pWriter.println(lineOfText + "\n");
    }

}
