
package dsrArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Flujo {
    
    public static void main(String[] args) {
        File file_in = new File("C:/workspace/datos/power_plant.csv");
        File file_out = new File("C:/workspace/datos/power_plant_counter.csv");
        try{
            FileReader fr;
            fr = new FileReader(file_in);
            BufferedReader br = new BufferedReader(fr);
            
            FileWriter fw;
            fw = new FileWriter(file_out);
            PrintWriter pw = new PrintWriter(fw);
            
            String linealeida;
            int c = 0;
            while((linealeida = br.readLine())!=null){
                c++;
                //System.out.println(c+": "+linealeida);
                pw.println(c+", "+linealeida);
            }
            br.close();
            fr.close();
            
            pw.close();
            fw.close();
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
    
}
