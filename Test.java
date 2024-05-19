
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
   
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
      ReservationSystem res = new ReservationSystem("System1");
      Customer customer = new Customer("Roberts" , "John", "T" , "Mr");
      customer.printDetails();
      res.readCustomerData();
    }


}
