package dad.sockets.ejercicioconhilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {

	public void ejecutar() {
		try {
			
			Socket socket = new Socket("localhost",Servidor.PORT);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			Scanner teclado = new Scanner(System.in);
			
			String lineaLeida = "";
			while(true) {
				
				//Leemos de teclado
				System.out.print("Introduce texto: "); 
				lineaLeida = teclado.nextLine();
				
				//Escribimos la línea en el socket para enviar al servidor
				pw.println(lineaLeida); pw.flush();
				
				
				//Mostramos por pantalla lo que nos envía el servidor a través del socket y del correspondiente BufferedReader
				System.out.println("\tMensaje del servidor: " +  br.readLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {
		Cliente cliente = new Cliente();
		cliente.ejecutar();
	}

}
