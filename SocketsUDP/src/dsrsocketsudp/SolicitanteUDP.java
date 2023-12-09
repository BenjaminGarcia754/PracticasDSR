
package dsrsocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;


public class SolicitanteUDP {
    
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        args = new String[]{"hora","localhost"};
        
        DatagramSocket socketUDP = new DatagramSocket();
        byte[] mensaje = args[0].getBytes();
        InetAddress hostservidor = InetAddress.getByName(args[1]);
        
        DatagramPacket peticion = new DatagramPacket(
                mensaje, mensaje.length, hostservidor,6001
        );
        
        socketUDP.send(peticion);
        
        byte[] buffer = new byte[1024];
        DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
        
        socketUDP.receive(respuesta);
        
        String strtimeServer = new String(respuesta.getData());
        Date timeServer = new Date(strtimeServer);
        System.out.println("Hora del servidor es: "+timeServer);
        
        socketUDP.close();
        
    }
    
}
