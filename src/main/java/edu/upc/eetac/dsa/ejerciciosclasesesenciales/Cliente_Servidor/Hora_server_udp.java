package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora_server_udp{
    static DatagramSocket socket ;
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    static Date now = new Date();
    public static void main(String[] args) {
        try {
            socket = new DatagramSocket(50001);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while(true) {
                System.out.println("Listening");
                socket.receive(packet);          

                SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
                String toClient= fecha.format(now);
                buf = toClient.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            }
            
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}