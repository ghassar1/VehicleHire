
import java.util.*;
import java.util.Random;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;
/**
 * Write a description of class ReservationSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReservationSystem  
{
    // instance variables - replace the example below with your own
    String name;
    private HashMap<String, Vehicle> vehicleMap;
    private HashMap<String, Customer> customerMap;
    private HashMap<String, VehicleReservation> vehicleReservationMap;
    private Random randomGenerator;
    private String vehicleReservationIdNumber;
    private boolean firstCallToGenerateReservationNo;
    private int lastReservationNumber;
    private String lastNumberGeneratedFileName ;
    private Diary dairy;
  //  private VehicleReservation  vehRes;
    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem(String name)
    {
       this.name = name;
       vehicleMap = new HashMap<String, Vehicle>();
       customerMap = new HashMap<String, Customer>();
       vehicleReservationMap = new HashMap<String, VehicleReservation>();
       randomGenerator = new Random();
       vehicleReservationIdNumber = "0";
       readCustomerData("customer.txt");
       firstCallToGenerateReservationNo = true;
       lastReservationNumber = 0;
       lastNumberGeneratedFileName  = "LastNumberGenerated.txt ";
       dairy = new Diary();
    }
    private void generateVehicleReservationIdNumber()
    { 
        int num = Integer.parseInt(vehicleReservationIdNumber);
        num++;
        String str  = num + "";
        int length = str.length();
        switch (length)
        {
            case 1: vehicleReservationIdNumber = "00000" + str;
            break;
            case 2: vehicleReservationIdNumber = "0000" + str;
            break;
            case 3: vehicleReservationIdNumber = "0000" + str;
            break;
            case 4: vehicleReservationIdNumber = "000" + str;
            break;
            case 5: vehicleReservationIdNumber = "00" + str;
            break;
            case 6: vehicleReservationIdNumber = "0" + str;
            break;
            case 7: vehicleReservationIdNumber =  str;
        }
        Integer int1 = Integer.parseInt(vehicleReservationIdNumber);
        lastReservationNumber = int1;
    }
    public void printDiaryEntries(VehicleReservation vehicleReservation)
    {
        dairy.printEntries(vehicleReservation.getStartDate(), vehicleReservation.getStartDate());
    }
    public void storeVehicleReservation(VehicleReservation vehicleReservation)
    {
        dairy.addReservation(vehicleReservation);
        vehicleReservationMap.put(vehicleReservationIdNumber, vehicleReservation);
    }
    public void deleteVehicleReservation(String reservationNumber)
    {
        for(String key : vehicleReservationMap.keySet() )
        {
            if(key.contains(reservationNumber))
            {
                vehicleReservationMap.remove(key);
            }
        }   
    }
     private String generateCustomerId(String prefix, int numberOfDigits)
     {
     int num =  randomGenerator.nextInt();
     String str = String.valueOf(num);
      while(str.length() != numberOfDigits || str.charAt(0) == '-'){
      num =  randomGenerator.nextInt();
      str = String.valueOf(num);
     }
     return prefix + "-" + str;
    }
    public void storeCustomer(Customer customer)
    {
    String str = customer.getCustomerId();
     if(str.equalsIgnoreCase("unknown"))
    {
    setCustomerId(customer);
     while(checkCustomerId(customer))
    {
        setCustomerId(customer);
    }
     customerMap.put(customer.getCustomerId(),customer);   
    }
    }
    private void setCustomerId(Customer customer)
    {
     String generatedCustomerId =  generateCustomerId("AA",6); 
     customer.setCustomerId(generatedCustomerId);
   
    }
    private boolean checkCustomerId(Customer customer)
    {
        boolean status = false;
        for(Customer customers: customerMap.values()){
            if(customers.getCustomerId() == customer.getCustomerId())
            {
                status = true;
            }
        }
        return status;
    }
    public void printAllCustomers()
    {
     for (Customer customer: customerMap.values())
     {
         System.out.println(customer.getDetails());
     }
    }
    public void storeVehicle(Vehicle vehicle){
       vehicleMap.put(vehicle.getVehicleId(), vehicle);
    }
    public void displayAllVehicles ()
    {
        for(Vehicle vehicle : vehicleMap.values()){
            System.out.println(vehicle.getVehicleDetails());
        }
    }
    public void readVehicleData()  
    {
        try{
         Frame owner = null;
         FileDialog fileBox = new FileDialog(owner, "OPEN", FileDialog.LOAD);
         fileBox.setVisible(true);
         String fileName = fileBox.getFile();
         File file = new File(fileName);
         Scanner scanner = new Scanner(file);
         String typeOfData = "unkown";
         while(scanner.hasNext()){
             String lineOfText = scanner.nextLine();
             Scanner scanner2 = new Scanner(lineOfText);
             scanner2.useDelimiter("[ ]*,[ ]*");
             if(lineOfText.startsWith("["))
             {
              typeOfData = lineOfText;
              System.out.println(typeOfData);  
             }else if(lineOfText.startsWith("//"))
             {
                 
             }else if(lineOfText.length() == 0)
             {
                 
             }else if (typeOfData.equalsIgnoreCase("[Car data]")){
             Vehicle veh1 = new Car();
             veh1.readData(scanner2);
             storeVehicle(veh1);
             veh1.displayDetails();
             } else if(typeOfData.equalsIgnoreCase("[van data]"))
             {
              Vehicle veh = new Van();
              veh.readData(scanner2);
              storeVehicle(veh);
              veh.displayDetails();
             }
             else if (typeOfData.equalsIgnoreCase("[Truck data]"))
             {
             Vehicle veh = new Truck();
             veh.readData(scanner2);
             storeVehicle(veh);
             veh.displayDetails();   
             scanner2.close(); 
            }
         }
          scanner.close();
        }catch(Exception e){
            System.out.println("Errors!");
        }
       
       //  displayAllVehicles ();
    }
    public void printAllVehicleReservationNo()
    {
        for(VehicleReservation vr : vehicleReservationMap.values()){
            System.out.println(vr.getDeatils());
        }
    }
    public void readCustomerData(String fileName)
    {
        try{
         File file = new File(fileName);
         Scanner scanner = new Scanner(file);
         while(scanner.hasNext())
         {
             String lineOfText = scanner.nextLine();
             Scanner scanner2 = new Scanner(lineOfText).useDelimiter(",[ ]*");
             System.out.println(lineOfText);
             if(lineOfText.startsWith("//"))
             {
                 
             }else if(lineOfText.length() == 0)
             {
                 
             }else{
             Customer customer = new Customer();
             customer.readData(scanner2);
             storeCustomer(customer);
             customer.printDetails();
             }
         }
         scanner.close();
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }
    public void readVehicleReservationData()
    {
        try{
        Frame owner = null;   
        FileDialog filebox = new FileDialog(owner, "OPEN", FileDialog.LOAD);
        filebox.setVisible(true);
        String fileName = filebox.getName();
        Scanner scanner = new Scanner(fileName);
        while(scanner.hasNext())
        {
            String lineOfText = scanner.nextLine();
            Scanner scanner2 = new Scanner(lineOfText);
            VehicleReservation vr = new VehicleReservation();
            vr.readData(scanner2);
            storeVehicleReservation(vr);
            System.out.println(vr.getDeatils());
        }
        }catch (Exception e){
            
            
        }
    }
    public void readCustomerData()
    {
        try{
         Frame owner = null;
         FileDialog fileBox = new FileDialog(owner, "OPEN", FileDialog.LOAD);
         fileBox.setVisible(true);
         String fileName = fileBox.getFile();
         File file = new File(fileName);
         Scanner scanner = new Scanner(file);
         while(scanner.hasNext())
         {
             String lineOfText = scanner.nextLine();
             Scanner scanner2 = new Scanner(lineOfText).useDelimiter(",[ ]*");
             System.out.println(lineOfText);
             if(lineOfText.startsWith("//"))
             {
                 
             }else if(lineOfText.length() == 0)
             {
                 
             }else{
             Customer customer = new Customer();
             customer.readData(scanner2);
             storeCustomer(customer);
             customer.printDetails();
             
             }
         }
         scanner.close();
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }
    public void writeCustomerData()
    {
        try
        {
        Frame owner = null;
        FileDialog filebox = new FileDialog(owner, "SAVE", FileDialog.SAVE);
        filebox.setVisible(true);
        String fileName = filebox.getFile(); 
        PrintWriter pWriter = new PrintWriter(fileName);
        for (Customer customer : customerMap.values())
        {
            customer.writeData(pWriter);
        }
        pWriter.close();
        }catch(Exception e){
          System.out.println("Error!");
        }
    }
    public void writeVehicleReservationData()
    {
        try
        {
        Frame owner = null;   
        FileDialog filebox = new FileDialog(owner, "SAVE", FileDialog.SAVE);  
        filebox.setVisible(true);
        String fileName = filebox.getName();
        PrintWriter pWriter = new PrintWriter(fileName);
        for(VehicleReservation vr : vehicleReservationMap.values())
        {
            vr.writeData(pWriter);
        }
        pWriter.close();
        }catch(Exception e){
            
        }
        
    }
    public boolean makeVehicleReservation(String customerID, String vehID, 
                            String startDate, int noOfDays)  
    {
       VehicleReservation res = getVehicleReservation (vehID);
     if(getVechile(vehID) == null)
     {
       System.out.println("VehId is not existed");   
     }else if(getCustomer(customerID)== null)
     {
       System.out.println("CustomerId not existed");   
     }else if(getVehicleReservation (vehID) != null)
     {    
              System.out.println("Vehicle is reserved");
     }else{
      generateVehicleReservationIdNumber();
      VehicleReservation vehicleReservation = new VehicleReservation(vehicleReservationIdNumber,vehID, customerID, startDate,  noOfDays);
      storeVehicleReservation(vehicleReservation);
      return true;
     }
     return false;
    }
   
    public VehicleReservation  getVehicleReservation (String id)
    {
             
     return vehicleReservationMap.get(id);
    }
    public Vehicle getVechile(String id)
    {
        Vehicle vec = null;
       for (String key : vehicleMap.keySet()) {
       if(key.equalsIgnoreCase(id))
       {
         vec = vehicleMap.get(id);
       }
       }
      return vec;
    }
       public Customer getCustomer(String id)
    {
        Customer customer = null;
       for (String key : customerMap.keySet()) {
       if(key.equalsIgnoreCase(id))
       {
         customer = customerMap.get(id);
       }
       }
      return customer;
    }
}
