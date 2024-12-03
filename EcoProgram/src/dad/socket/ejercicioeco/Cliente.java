package dad.socket.ejercicioeco;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public void ejecutar() {
        try {
            Socket socket = new Socket("localhost", Servidor.PORT);
            
            // Crear streams para leer y escribir
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // flush automático
            
            Scanner teclado = new Scanner(System.in);
                       
            while (true) {
                System.out.print("Escribe un mensaje para el servidor (o 'salir' para terminar): ");
                String mensaje = teclado.nextLine();


                // Enviar mensaje al servidor
                pw.println(mensaje); // usar println para enviar con nueva línea
                pw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.ejecutar();
    }
}

