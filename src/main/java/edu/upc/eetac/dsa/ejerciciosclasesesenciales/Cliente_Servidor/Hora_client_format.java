package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
public class Hora_client_format {

    public static void main(String [] args) {

        Socket  s;
        PrintStream  p;
        BufferedReader  b;

        String  host = "localhost";
        int port = 50002;
        String  respuesta;

        //Referencia a la entrada por consola (System.in)
        BufferedReader  in = new BufferedReader (new InputStreamReader (System .in));

        try {

            //Creo una conexion al socket servidor
            s = new Socket (host,port);

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream (s.getOutputStream());
            b = new BufferedReader  ( new InputStreamReader  ( s.getInputStream() ) );

            
            	System.out.print("Introduce 0 o 1 para decidir el formato");
            	p.println( in.readLine() );
            	
                //Espero la respuesta por el canal de lectura
                respuesta = b.readLine();
                System .out.println(respuesta);
                
                   
                
            
            
            p.close();
            b.close();
            s.close();

        } catch (UnknownHostException  e) {
            System .out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException  e) {
            System .out.println("Error de E/S en " + host + ":" + port);
        }
    }
}