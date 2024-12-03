package edu.ucam.sockets.eco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEco {	
	public static final int PORT = 5000;

	public void ejecutar() {
		try {
			ServerSocket serverSocket = new ServerSocket(ServidorEco.PORT);
			Socket socket = serverSocket.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String lineaLeida = "";
			
			while (true) {				
				//Leemos linea recibida desde el cliente
				lineaLeida = br.readLine();
				
				System.out.println("Soy el servidor, linea recibida: " + lineaLeida);
				
				//Enviamos de vuelta la linea recibida
				pw.println(lineaLeida);pw.flush();
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ServidorEco servidor = new ServidorEco();
		servidor.ejecutar();
	}
}
