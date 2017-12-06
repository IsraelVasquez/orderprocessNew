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
        ArrayList orderList = new ArrayList();
        String props = "";
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/Orders.txt"))))
        {                     
            System.out.println("Start processing orders");
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File("/Users/ivasquez/NetBeansProjects/Filereader/OrderProcess/src/orderprocess/OrdersProcessed.txt")));
            StringBuilder fileContent = new StringBuilder();
            String line = myReader.readLine();
            while(line != null) 
            {
                
                props += line;
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
                line = myReader.readLine();
            }
            System.out.println(props);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}

