
import java.util.*;
import java.io.*;
/**
 * Write a description of class Extra here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Extra
{
   private HashMap<String, Data> hashList;
   /**
     * Constructor for objects of class Extra
     */
    public Extra()
    {
    hashList = new HashMap<String, Data>();
   
    }
   public void put()
   {
      Data data = new Data();
      hashList.put("AA123", data);
   }
}
