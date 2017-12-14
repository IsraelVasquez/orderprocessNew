/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocess;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** 
 *
 * @author ivasquez
 */
public class OrderProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadWrite(tax(),shipping());
        
        
    }
    private static void ReadWrite(double tax, double shipping)
    {
        //processed text files.
        String read = "Orders.txt";
        String write = "OrdersProcessed.txt";
        //initialize the tax and the shipping.
        Double Ntax = tax;
        Double Nshipping = shipping;
        
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/"+ read))))/** locate the text file for reading.**/
        {                
            try(BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/" + write))))/**write to specified file.**/
            {

                myReader.readLine();/**reads the first line of the list**/
                System.out.println("~Starting to process orders~");/**tells the user that we have begun the process.**/
                    String line = myReader.readLine();/**one line is read and stored into this string**/
                
                while(line != null)/**until we finish reading the file, do the following.**/ 
                {
                    
                    
                    String[] products = line.split("\\|");//divide the data for each product into the array.
                    //calculates the tax, total, and shipping of each item.
                    Double mnt = Double.parseDouble(products[2]) * Double.parseDouble(products[3]);
                    Double shipTtl = Nshipping * mnt;
                    Double taxTtl = Ntax * mnt;
                    Double total = taxTtl + shipTtl + mnt;
                    //print the properties of the items in the list.
                    System.out.println("order ID: "+ products[0]);
                    System.out.println("Part Number: "+ products[1]);
                    System.out.println("Price: "+ products[2]);
                    System.out.println("Quantity: "+ products[3]);
                    System.out.println("Tax: "+ taxTtl);
                    System.out.println("Shipping: "+ shipTtl.floatValue());//had to use float to remove unnecessary zeros.
                    System.out.println("Total:" + total.floatValue());//had to use float to remove unnecessary zeros.
                    System.out.println(System.lineSeparator());//seperate the properties of each items by groups by seperating them by a blank line.
                    //print the properties of the items in the list.
                    myWriter.write("order ID: "+ products[0] + System.lineSeparator() );
                    myWriter.write("Part Number: "+ products[1] + System.lineSeparator());
                    myWriter.write("Price: "+ products[2] + System.lineSeparator());
                    myWriter.write("Quantity: "+ products[3] + System.lineSeparator());
                    myWriter.write("Tax: "+ taxTtl + System.lineSeparator());
                    myWriter.write("Shipping: "+ shipTtl.floatValue() + System.lineSeparator());
                    myWriter.write("Total:" + total.floatValue() + System.lineSeparator());
                    myWriter.write(System.lineSeparator());
                    
                    line = myReader.readLine();/**the file continues to be read.**/
                }
            }
            catch(IOException e)/**displays file not found for writing error **/
            {
                System.out.println(e);
                System.out.println("could not write to file "+ write);
            }
            
        }
        
        catch(IOException e)/**displays file not read error **/
        {
            System.out.println(e);
            System.out.println("could not read file " + read);
        }
    }    
    
    //hard code the tax rate.
    private static double tax(){
       final double tax = .02;
       return tax;
   }
    //hard code the shipping rate.
    private static double shipping(){
       final double shipping = .05;
       return shipping;
   }
}



