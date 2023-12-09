package dsrsockets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ManejadorCliente implements Runnable {
    
    private final Socket ch;
    PrintWriter out;
    BufferedReader in;
    
    public ManejadorCliente(Socket ch) throws IOException{
        this.ch = ch;
        out = new PrintWriter(ch.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(ch.getInputStream()));
        
        System.out.println("\nConexión recibida de: "+
        ch.getInetAddress().getHostAddress());
    }

    @Override
    public void run() {
        try {
            
            //Abrir un flujo a un archivo
            File file_in = new File("C:/workspace/datos/power_plant.csv");
            
            //Pasar las lineas del archivo al cliente
            FileReader fr;
            fr = new FileReader(file_in);
            BufferedReader br = new BufferedReader(fr);
            
            String linealeida;
            int c = 0;
            while((linealeida = br.readLine())!=null){
                c++;
                out.println(linealeida);
            }
            out.println("end");
            br.close();
            fr.close();
            
            System.out.println(in.readLine());
            out.close();
            in.close();
            ch.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
