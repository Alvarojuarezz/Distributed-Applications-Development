package dad.repaso.primerparcial.ejerciciostipoexamen.gestionclientes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

public class Servidor {
	protected static int PUERTO = 5000;
	protected static Hashtable<String, Material> materiales = new Hashtable<String, Material>();
	protected static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	
	public static void main(String[] args) 
	{
		try {
			ServerSocket ss = new ServerSocket(PUERTO);
			while(true)
			{
				Socket s = ss.accept();
				HiloServidor hilo = new HiloServidor();
				hilo.start();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String addMaterial(String id, String cantidad, String descripcion)
	{
		if(! materiales.containsKey(id))
		{
			Material mat = new Material(id, Integer.parseInt(cantidad), descripcion);
			materiales.put(id, mat);
			return "Se ha creado el material con id "+id+" , cantidad "+ cantidad+" y descripcion: "+descripcion;
		}
		else 
		{
			return "Este material ya existe";
		}
	}
	
	public String getMaterial(String id)
	{
		if(!materiales.containsKey(id))
		{
			Servidor s = new Servidor();
			return "ID: "+s.materiales.get(id).getId()+" Cantidad: "+s.materiales.get(id).getCantidad()+" Descripción: "+s.materiales.get(id).getDescripcion();
		}
		else
		{
			return "No existe este material.";
		}
	}
	
	public String setCantidad(String id , String cantidad)
	{
		if(materiales.containsKey(id))
		{
			Servidor s = new Servidor();
			s.materiales.get(id).setCantidad(Integer.parseInt(cantidad));
			return " La cantidad del material con id "+ id+" es "+cantidad;
		}
		else 
		{
			return "No existe el material.";
		}
	}
	
	public String removeMaterial(String id)
	{
		if(materiales.containsKey(id))
		{
			materiales.remove(id);
			return "Se ha borrado el material con id "+ id+" con exito.\n";
		}
		else
		{
			return "Este material no existe.";
		}
	}
	
	public String addReserva(String id, String cantidad)
	{
		if(materiales.containsKey(id))
		{
			if(Integer.parseInt(cantidad)<= materiales.get(id).getCantidad())
			{
				Reserva res = new Reserva(id, Integer.parseInt(cantidad));
				reservas.add(res);
				materiales.get(id).setCantidad(materiales.get(id).getCantidad()-Integer.parseInt(cantidad));
				return "Se ha realizado una reserva del material con id "+id+" con una cantidad "+ cantidad+" unidades.";
			}
			else
			{
				return "No hay suficiente cantidad disponible de este material para realizar esta reserva.";
			}
		}
		else 
		{
			return "No existe este material.";
		}
	}
	
	public String exit(String num)
	{
		Cliente.numero = Integer.parseInt(num);
		return "Cliente con número "+num+" expulsado con exito.";
	}
}
