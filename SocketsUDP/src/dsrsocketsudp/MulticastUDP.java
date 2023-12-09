
package dsrsocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;


public class MulticastUDP {
    
     public static void main(String args[]) {
        try {
            InetAddress grupo = InetAddress.getByName("224.0.0.0");
            MulticastSocket socket = new MulticastSocket(6789);

            // Se une al grupo
            socket.joinGroup(grupo);
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Envíe un mensaje al grupo: ");
            String msj = scan.nextLine();
            

            // Envia el mensaje
            byte[] m = msj.getBytes();
            DatagramPacket mensajeSalida
                    = new DatagramPacket(m, m.length, grupo, 6789);
            socket.send(mensajeSalida);

            byte[] bufer = new byte[1024];
            String linea;

            // Se queda a la espera de mensajes al grupo, hasta recibir "Adios"
            while (true) {
                DatagramPacket mensajeEntrada
                        = new DatagramPacket(bufer, bufer.length);
                socket.receive(mensajeEntrada);
                linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
                System.out.println("Recibido:" + linea);
                if (linea.equalsIgnoreCase("Adios")) {
                    break;
                }
            }

            // Si recibe "Adios" abandona el grupo
            socket.leaveGroup(grupo);
        } catch (SocketException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        }
    }
    
}
