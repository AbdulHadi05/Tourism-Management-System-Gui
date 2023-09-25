/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Vehicle {
    public void addVehicle(String regno,String name,String category){
        try {
            // TODO add your handling code here:
            File f = new File("Vehicle.txt");
            f.createNewFile();
            FileWriter filew = new FileWriter(f, true);
            BufferedWriter writer = new BufferedWriter(filew);
          
            writer.write(regno + "\n" + name + "\n" + category + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String viewVehicle() throws IOException{
        try {
            String allVehicle = "";
            File f = new File("Vehicle.txt");
            f.createNewFile();
            Scanner reader = new Scanner(f);
            
            int i = 0;
            
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                allVehicle += (++i)+" "+text+"\n";
            }
            return allVehicle;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Destination.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
    public boolean deleteVehicle(String id) throws IOException{
        //Scanner input = new Scanner(System.in);
        File f = new File("Vehicle.txt");
        f.createNewFile();
        Scanner reader = new Scanner(f);
        
        ArrayList<String> veh = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String text = reader.nextLine();   
            veh.add(text); 
        }
        Boolean found = false;
        Boolean inValid = true;         
        while(inValid){
            inValid = false;
            if(Integer.parseInt(id)<=veh.size()&&Integer.parseInt(id)>0){
                veh.remove(Integer.parseInt(id)-1);

                BufferedWriter writer = null;
                FileWriter filew = new FileWriter(f, false);
                writer = new BufferedWriter(filew);

                for (int i=0;i< veh.size();i++){
                    writer.write(veh.get(i));
                    writer.write("\n");
                    found = true;
                }
                writer.close();
            }
        }
       if(!found){
            inValid=true;
            return true;
        }
        else
            return false;
    } 
}    
