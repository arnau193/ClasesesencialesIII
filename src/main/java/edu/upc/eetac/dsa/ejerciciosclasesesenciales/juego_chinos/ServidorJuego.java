package edu.upc.eetac.dsa.ejerciciosclasesesenciales.juego_chinos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJuego {
	static int cont = 0;

	public static void main(String args[]) {

		// Establecemos el número de puerto a utilizar.
		int serverPort = 1024;

		// Creamos una instancia para esperar las peticiones de los
		// clientes.
		ServerSocket listenSocket;

		// Socket para conexión.
		Socket clientSocket;

		// Usamos la clase conection.
		Conexion c;

		try {

			// Creamos el objeto para esperar peticiones de los clientes.
			listenSocket = new ServerSocket(serverPort);

			while (true) {

				// Dejamos invocado el servidor esperando haste que un
				// cliente
				// se conecte. clientSocket = Socket nuevo para
				// comunicaciones
				System.out.println("Esperando nueva conexión");
				clientSocket = listenSocket.accept();
				// Se establece la conexión, y se vuelve a esperar un nuevo
				// cliente.
				c = new Conexion(clientSocket);
				cont++;

			}

			// Control de excepciones.
		} catch (IOException e) {
			System.out.println("Error en socket: " + e.getMessage());
		}
	}
}
