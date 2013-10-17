package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Hora_client_udp {

	public static void main(String args[]) {
		byte[] buf = new byte[256];
		DatagramSocket socket;
		try {
			socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(buf, buf.length,
					address, 50001);
			socket.send(packet);
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}