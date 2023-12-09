
package dsrsockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    
    public static void main(String[] args) {
        try{
            Socket cs = new Socket("localhost",6001);
            
            PrintWriter out = 
                    new PrintWriter(cs.getOutputStream(),true);
            
            BufferedReader in = 
                    new BufferedReader(
                            new InputStreamReader(
                                    cs.getInputStream()));
            
            String linearecibida;
            int c = 0;
            while(!(linearecibida = in.readLine()).equalsIgnoreCase("end")){
                if(c == 0){
                    System.out.println("N, "+linearecibida);
                }else{
                    System.out.println(c+", "+linearecibida);
                }
                c++;
            }
            
            
            
            out.println("Recepción de datos correcta...");
            
            out.close();
            in.close();
            cs.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
}
