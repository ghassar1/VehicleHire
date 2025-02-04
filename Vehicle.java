

import java.util.*;

/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    private String group; 
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon;
    private double engineSize;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;
   
     public Vehicle()
     {
         
     }
    public void setGroup(String group)
    {
        this.group = group;
    }
    public void setVehID(String vehID)
    {
        this.vehID = vehID;
    }
    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }
     public void setMake(String make)
    {
        this.make = make;
    }
    public String getVehicleId()
    {
        return vehID;
    }
    public String getVehicleDetails()
    {
        return "Group: " + group + "\t" + "VehID: " + vehID + "\t" + "RegN: " + regNo + "\t" + "Make: " + make + "Model: " + model + "\t" + "airCon: " + airCon + "\t" + "engineSize: " +
        + engineSize + "\t" + "fuelType: " + fuelType + "\t" + "gearbox: " + gearbox + "\t" + "transmission: " + transmission + "\t" + "mileage: " + mileage + "\t" + "dateFirstRegistered: " 
        + dateFirstRegistered;
    }
    public void displayDetails ()
    {
        System.out.println("Group: " + group + "\t" + "VehID: " + vehID + "\t" + "RegN: " + regNo + "\t" + "Make: " + make + "Model: " + model + "\t" + "airCon: " + airCon + "\t" + "engineSize: " +
        + engineSize + "\t" + "fuelType: " + fuelType + "\t" + "gearbox: " + gearbox + "\t" + "transmission: " + transmission + "\t" + "mileage: " + mileage + "\t" + "dateFirstRegistered: " 
        + dateFirstRegistered);
        
    }
    public void readData(Scanner scanner)
    {
        this.group = scanner.next();
        this.vehID = scanner.next();
        this.regNo = scanner.next();
        this.make = scanner.next();
        this.model = scanner.next();
        //
        String temp = scanner.next();
        boolean d = Boolean.parseBoolean(temp);
        this.airCon = d;
        //
        String temp2 = scanner.next();
        double d1 = Double.parseDouble(temp2);
        this.engineSize = d1;
        this.fuelType = scanner.next();
        this.gearbox = scanner.next();
        this.transmission = scanner.next();
        String temp3 = scanner.next();
        Integer d3 = Integer.parseInt(temp3);
        this.mileage = d3;
        this.dateFirstRegistered = scanner.next();
    }
  
}
