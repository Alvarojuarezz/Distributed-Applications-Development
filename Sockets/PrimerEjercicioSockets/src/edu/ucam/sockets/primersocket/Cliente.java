package edu.ucam.sockets.primersocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	
	public void ejecutar() {
		try {
			
			Socket socket = new Socket("localhost",Servidor.PORT);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			System.out.println(br.readLine());	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {
		Cliente cliente = new Cliente();
		cliente.ejecutar();
	}


}
