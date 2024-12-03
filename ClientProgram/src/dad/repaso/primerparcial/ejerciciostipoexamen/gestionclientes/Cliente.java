package dad.repaso.primerparcial.ejerciciostipoexamen.gestionclientes;

import java.io.*;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private int cli_num = -5;
	protected static int numero = -1;
	
	public int getCli_num() {
		return cli_num;
	}
	
	public void setCli_num(int cli_num) {
		this.cli_num = cli_num;
	}
	
	public void ejecutar() {
		try {
			Socket s = new Socket("127.0.0.1",Servidor.PUERTO);
			System.out.println(Material.contador);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String cadena = "";
			String opt="";
			
			Scanner sc = new Scanner(System.in);
			
			while(numero!=cli_num)
			{
				System.out.println("///MENU///");
				System.out.println("1. ADD");
				System.out.println("2. GET");
				System.out.println("3. REMOVE");
				System.out.println("4. SETCANTIDAD");
				System.out.println("5. ADDRESERVA");
				System.out.println("6. EXIT");
				opt = sc.nextLine();
				
				switch(opt)
				{
				case "1":
					cadena = "ADD-";
					
					System.out.println("Introduce el id del material: ");
					cadena+=sc.nextLine();
					cadena+="-";
					
					System.out.println("Introduce la cantidad del material: ");
					cadena+=sc.nextLine();
					cadena+="-";
					
					System.out.println("Introduce la descripción del material: ");
					cadena+=sc.nextLine();
					
					pw.println(cadena);
					pw.flush();
					
					System.out.println(br.readLine());
					break;
					
				case "2":
					cadena="GET-";
					
					System.out.println("Introduce el id del material:");
					cadena+=sc.nextLine();
					
					pw.println(cadena);
					pw.flush();
					
					System.out.println(br.readLine());
					break;
					
				case "3":
					cadena="REMOVE-";
					System.out.println("Introduce el id del material:");
					cadena+=sc.nextLine();
					
					pw.println(cadena);
					pw.flush();
					System.out.println(br.readLine());
					break;
					
				case "4":
						cadena="SETCANTIDAD-";
						
						System.out.println("Introduce el id del material:");
						cadena+=sc.nextLine();
						cadena+="-";
						
						System.out.println("Introduce la cantidad del material:");
						cadena+=sc.nextLine();
						
						pw.println(cadena);
						pw.flush();
						System.out.println(br.readLine());
						break;
				case "5":
						cadena="ADDRESERVA-";
						
						System.out.println("Introduce el id del material:");
						cadena+=sc.nextLine();
						cadena+="-";
						
						System.out.println("Introduce la cantidad del material:");
						cadena+=sc.nextLine();
						
						pw.println(cadena);
						pw.flush();
						System.out.println(br.readLine());
						break;
				case "6":
						cadena="EXIT-";
					
						System.out.println("Introduce el número del cliente que desea expulsar del sistema:");
						cadena+=sc.nextLine();
						
						pw.println(cadena);
						pw.flush();
						
						System.out.println(br.readLine());
						break;
				default: 
					System.out.println("No existe este comando");
					break;
				}
			}
		} catch (java.net.UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Cliente cl = new Cliente();
		cl.ejecutar();
	}

}
