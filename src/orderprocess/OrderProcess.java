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
        System.out.println(ReadWrite());
        
        
    }
    private static String ReadWrite()
    {
        StringBuilder fileContent = new StringBuilder();/**used to store the lines read from the file.**/
        
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/Orders.txt"))))/** locate the text file for reading.**/
        {                     
            System.out.println("Start processing orders");/**begin manipulating text**/
                BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/OrdersProcessed.txt")));/**write to specified file.**/
                    String line = myReader.readLine();/**the lines are read and stored into a string**/
                        
            while(line != null)/**until we finish reading the file, do the following.**/ 
            {
                fileContent.append(line);/**puts the line from the file into the StringBuilder**/
                fileContent.append(System.lineSeparator());/**creates a new line in the StringBuilder for the next line to occupy**/
                line = myReader.readLine();/**the file continues to be read.**/
            }
            
        }
        
        catch(IOException e)
        {
            System.out.println(e);
        }
        return fileContent.toString();
    }
   
}

