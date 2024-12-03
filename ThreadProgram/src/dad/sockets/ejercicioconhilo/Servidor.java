package dad.sockets.ejercicioconhilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

	public static final int PORT = 5000;

	public void ejecutar() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
							
			while (true) {				
				Socket socket = ss.accept();
				HiloServidor hilo = new HiloServidor(socket);
				hilo.start();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		Servidor servidor = new Servidor();
		servidor.ejecutar();
	}
}
