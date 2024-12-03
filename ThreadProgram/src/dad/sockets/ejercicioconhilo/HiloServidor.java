package dad.sockets.ejercicioconhilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{
	
	private Socket socket;

	public HiloServidor(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			Servidor s = new Servidor();
			String lineaLeida = "";
			while (true) 
			{
				//Leemos linea recibida desde el cliente
				lineaLeida = br.readLine();
				
				System.out.println("Soy el servidor, linea recibida: " + lineaLeida);
				
				//Enviamos de vuelta la linea recibida
				pw.println(lineaLeida);pw.flush();		
				
			}
		} catch (IOException e) {
			
		}
	}
	

}
