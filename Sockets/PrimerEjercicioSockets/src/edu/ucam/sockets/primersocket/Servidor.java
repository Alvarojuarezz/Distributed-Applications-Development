package edu.ucam.sockets.primersocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

public class Servidor {

	
	public static final int PORT = 5000;

	public void ejecutar() {
		try {
			ServerSocket serverSocket = new ServerSocket(Servidor.PORT);
			Socket socket = serverSocket.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			pw.println("Hola mundo!");pw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		Servidor servidor = new Servidor();
		servidor.ejecutar();
	}
}
