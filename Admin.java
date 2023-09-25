/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Hamza
 */
public class Admin {
    boolean validateLogin(String userName, String password) throws IOException
    {
    String x = userName.trim() + " " + password.trim();

        try {
            File f = new File("credentials.txt");
            f.createNewFile();
            PrintWriter output = new PrintWriter(f); // writing admin username & pass in Credentials file
            output.println("admin 0123");
            output.close();
            Scanner in = new Scanner(f);            
            while (in.hasNextLine()) {             //Reading admin username & pass from Credentials file
                String data = in.nextLine();
                if (data.equals(x))               //verifying admin username & pass 
                    return true;
                else
                    return false;
            }
        } 
        catch (IOException e) {
            System.out.println(e);
        }
        return false;
//if (x.equals("admin 0123"))               //verifying admin username & pass 
//                    return true;
//                else
//                    return false;
    }
            

}
