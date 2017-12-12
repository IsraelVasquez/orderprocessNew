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
        System.out.println(ReadWrite(tax(),shipping()));
        
        
    }
    private static String ReadWrite(double tax, double shipping)
    {
        String read = "Orders.txt";
        String write = "OrdersProcessed.txt";
        StringBuilder fileContent = new StringBuilder();/**used to store the lines read from the file.**/
        
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/"+ read))))/** locate the text file for reading.**/
        {                
            try(BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/" + write))))/**write to specified file.**/
            {

                myReader.readLine();/**reads the first line of the list**/
                System.out.println("Start processing orders");/**tells the user that we have begun the process.**/
                    String line = myReader.readLine();/**one line is read and stored into this string**/
                
                while(line != null)/**until we finish reading the file, do the following.**/ 
                {
                    
                    
                    String[] products = line.split("\\|");
                    
                    products[0] = "Order ID: "+" ";
                    products[1] = "Order ID: " +" ";
                    products[2] = "Order ID: " +" ";
                    products[3] = "Order ID: " +" ";
                    products[4] = "Order ID: " +" ";
                    
                 
                    //fileContent.append();/**puts the line from the file into the StringBuilder**/
                    fileContent.append(System.lineSeparator());/**creates a new line in the StringBuilder for the next string to occupy**/
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
        return fileContent.toString();
    }
    
    private static double tax(){
       final double tax = .02;
       return tax;
   }
    
    private static double shipping(){
       final double shipping = .05;
       return shipping;
   }
}

