/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementnahom;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Logger {
    public static final String path="log.txt";
    public static void addLog(String data){
        
        
        try{
            PrintWriter wr=new PrintWriter(new FileWriter(path,true));
          
            Calendar c=Calendar.getInstance();
            String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(c.getTime());
            wr.append(time+"--> "+data);
            wr.close();
            
        }catch(Exception e){
            
        }
    }
    public static String getLog(){
         String output="";
        try{
            File f=new File(path);
            FileReader reader=new FileReader(f);
            BufferedReader br=new BufferedReader(reader);
           String line;
            while((line=br.readLine())!=null){
               System.out.println(output);
               output=output+line+"\n";
            }
        }catch(Exception e){
            
        }
        return output;
    }
}
