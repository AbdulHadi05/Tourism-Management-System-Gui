/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package project;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class Destination {
    
    public String viewDestination() throws IOException{
        try {
            String allDestination = "";
            File f = new File("destination.txt");
            f.createNewFile();
            Scanner reader = new Scanner(f);
            
            int i = 0;
            
            while (reader.hasNextLine()) {
                String text = reader.nextLine();
                allDestination += (++i)+" "+text+"\n";
            }
            return allDestination;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Destination.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }


public void addDestination(String destination) throws IOException{
        try{
            // TODO add your handling code here:
            File f = new File("destination.txt");
            f.createNewFile();
            FileWriter filew = new FileWriter(f, true);
            BufferedWriter writer = new BufferedWriter(filew);
          
            writer.write(destination + "\n");
            writer.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Destination.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

public boolean deleteDestination(String id) throws IOException{
        //Scanner input = new Scanner(System.in);
        File f = new File("destination.txt");
        f.createNewFile();
        Scanner reader = new Scanner(f);
        
        ArrayList<String> dest = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String text = reader.nextLine();   
            dest.add(text); 
        }
        Boolean found = false;
        Boolean inValid = true;         
        while(inValid){
            inValid = false;
            if(Integer.parseInt(id)<=dest.size()&&Integer.parseInt(id)>0){
                dest.remove(Integer.parseInt(id)-1);

                BufferedWriter writer = null;
                FileWriter filew = new FileWriter(f, false);
                writer = new BufferedWriter(filew);

                for (int i=0;i< dest.size();i++){
                    writer.write(dest.get(i));
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