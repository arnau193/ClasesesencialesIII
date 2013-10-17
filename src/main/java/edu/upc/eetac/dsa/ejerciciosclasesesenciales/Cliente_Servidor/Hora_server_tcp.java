package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;


import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Hora_server_tcp {


    public static void main(String [] args) {
    	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        ServerSocket  s; //Socket servidor
        Socket  sc; //Socket cliente

        PrintStream  p; //Canal de escritura
        BufferedReader  b; //Canal de Lectura
        Date now = new Date();
        String mensaje;

        try {
            //Creo el socket server
            s = new ServerSocket (60000);

            //Invoco el metodo accept del socket servidor, me devuelve una referencia al socket cliente
            sc = s.accept();

            //Obtengo una referencia a los canales de escritura y lectura del socket cliente
            b = new BufferedReader ( new InputStreamReader  ( sc.getInputStream() ) );
            p = new PrintStream  ( sc.getOutputStream() );

            while ( true ) {
                //Leo lo que escribio el socket cliente en el canal de lectura
            	SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				mensaje = fecha.format(now);

				System.out.println(mensaje);

                //Escribo en canal de escritura el mismo mensaje recibido
                p.println(mensaje);

               
                break;
                
            }

            p.close();
            b.close();

            sc.close();
            s.close();
        } catch (IOException  e) {
            System .out.println("No puedo crear el socket");
        }
    }

}