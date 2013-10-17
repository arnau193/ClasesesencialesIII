package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiServer_thread_format extends Thread {

	private Socket socket=null; //Socket servidor
	
    public MultiServer_thread_format(Socket socket) {
	super("MultiServer_thread_format");
	this.socket = socket;
    }
	
    public void run() {
    	
    	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Socket  sc; //Socket cliente

        PrintStream  p; //Canal de escritura
        BufferedReader  b; //Canal de Lectura
        Date now = new Date();
        String mensaje;
        try {
            
            //Invoco el metodo accept del socket servidor, me devuelve una referencia al socket cliente

            //Obtengo una referencia a los canales de escritura y lectura del socket cliente
            b = new BufferedReader ( new InputStreamReader  ( socket.getInputStream() ) );
            p = new PrintStream  ( socket.getOutputStream() );
            while ( true ) {
            	Integer controlador = null; 
            	try{
            	controlador = Integer.parseInt(b.readLine());
            	System.out.println("El cliente ha mandado un: " + controlador);
            	}
            	
            	catch(IOException  e){
            		System.out.println("Error en los datos introducidos ");
            	}
            	
            	if(controlador==0){
                //Leo lo que escribio el socket cliente en el canal de lectura
            	SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				mensaje = fecha.format(now);

				System.out.println(mensaje);

                //Escribo en canal de escritura el mismo mensaje recibido
                p.println(mensaje);
                break;
            	}
            	
            	if(controlador==1){
            		DateFormat fecha2 = DateFormat.getDateInstance(DateFormat.LONG);
            		mensaje=fecha2.format(now);
            		System.out.println(mensaje);
            		p.println(mensaje);
            		break;
            		
            		
            	}
            	
            	else{
            		mensaje="Formato incorrecto";
            		System.out.println(mensaje);
            		p.println(mensaje);
            		break;
            	}
               
                
                
            }
           
            p.close();
            b.close();
            
        
            socket.close();
        } catch (IOException  e) {
            System .out.println("No puedo crear el socket");
        }
    }

}
