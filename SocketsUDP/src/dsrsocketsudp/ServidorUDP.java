
package dsrsocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class ServidorUDP {

    public static void main(String[] args) throws SocketException, IOException {
        int port = 6001;
        DatagramSocket socketUDP = new DatagramSocket(port);
        byte[] buffer = new byte[1024];
        System.out.println("Servidor UDP escuchando en puerto: "+port);
        while(true){
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            
            socketUDP.receive(peticion);
            
            System.out.println("Datagrama recibido del host: "+peticion.getAddress());
            System.out.println("desde el puerto remoto: "+peticion.getPort());
            
            Date now = new Date();
            String strDate = now.toString();
            
            DatagramPacket respuesta = new DatagramPacket(
                    strDate.getBytes(),
                    strDate.getBytes().length,
                    peticion.getAddress(),
                    peticion.getPort()
            );
            
            socketUDP.send(respuesta);
            
        }
        
    }
    
}
