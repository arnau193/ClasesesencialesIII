package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Cliente_Servidor;


import java.net.*;
import java.io.*;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer_format {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(50002);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 50002.");
            System.exit(-1);
        }

        while (listening)
	    new MultiServer_thread_format(serverSocket.accept()).start();

        serverSocket.close();
		
	}
	
	
}