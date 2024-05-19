import java.util.Date;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class VehicleReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VehicleReservation
{
    private String reservationNo;
    private String vehID;
    private String customerID;
    private Date startDate;
    private int noOfDays;
    /**
     * Constructor for objects of class VehicleReservation
     */
    public VehicleReservation(String reservationNo, String vehID, String customerID,
    String startDate, int noOfDays)
    {
       this.reservationNo = reservationNo;
       this.vehID = vehID;
       this.customerID = customerID;
       this.startDate = DateUtil.convertStringToDate(startDate);
       this.noOfDays = noOfDays;
    }
    public int getNoOfDays()
    {
        return noOfDays;
    }
    public Date getStartDate()
    {
     return  startDate;
    }
    public String getVehID()
    {
     return vehID;
    }
    public VehicleReservation( )
    {
        
    }
    public String toString()
    {
        return reservationNo + customerID + vehID;
    }
    public void printDeatils()
    {
        System.out.println("ReservationNo: " + reservationNo + "\t" + "VehID: " + vehID + "\t" + "CustomerID: " + customerID + "\t"  + "StartDate:" + startDate + "\t" + "NoOfDays" + noOfDays);
    }
    public String getDeatils()
    {
        return "ReservationNo: " + reservationNo + "\t" + "VehID: " + vehID + "\t" + "CustomerID: " + customerID + "\t"  + "StartDate:" + startDate + "\t" + "NoOfDays" + noOfDays;
    }
    public void writeData(PrintWriter pW )
    {
        String details = getDeatils();
        pW.println(details + "\n");
    }
    public void readData(Scanner scanner)
    {
     this.reservationNo = scanner.next();
     this.vehID = scanner.next();
     this.customerID = scanner.next();
     String temp = scanner.next();
     this.startDate = DateUtil.convertStringToDate(temp);
     String temp1 = scanner.next();
     Integer int1 = Integer.parseInt(temp1);
     this.noOfDays = int1;
    }
}
