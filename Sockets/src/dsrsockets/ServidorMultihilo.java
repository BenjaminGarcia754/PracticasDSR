package dsrsockets;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMultihilo {
    
    public static void main(String[] args) {
        try {
            int puerto = 6001;
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servidor escuchando...");
            while(true){
                //hacer proceso concurrente
                ManejadorCliente manejador = new ManejadorCliente(ss.accept());
                Thread h1 = new Thread(manejador);
                h1.start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
