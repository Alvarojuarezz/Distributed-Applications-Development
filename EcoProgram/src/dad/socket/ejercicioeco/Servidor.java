package dad.socket.ejercicioeco;

import java.io.*;
import java.net.*;

public class Servidor {
    public static final int PORT = 5000; 

    public void iniciar() {
        try  {
            
        	    ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado.\t ");

                // Crear streams para comunicación
                BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);

                String mensaje;
                // Lee mensajes hasta que se reciba null
                while (true) {
                	mensaje = br.readLine();
                    // Imprimir mensaje recibido del cliente
                	System.out.println("Soy el servidor, linea recibida: "+ mensaje);
                    pw.println(mensaje);
                    pw.flush();
                }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciar();
    }
}

