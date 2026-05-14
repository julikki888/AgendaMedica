package modelo;

import java.util.Calendar;
import java.util.LinkedList;

public class CitaMedica {

	private int[] prioridad = {0,1,2,3};	//de 0 a 3 de tamaño
	private int prioridadCita;
	private String numSeguridad, nombrePaciente, especialista;
	private LinkedList<String> listaMotivos;
	private Calendar fecha;
	
	public CitaMedica(int p, String numSeguridad, String nombrePaciente, String especialista,
			LinkedList<String> listaMotivos, Calendar fecha) {
		this.prioridadCita = p;
		this.numSeguridad = numSeguridad;
		this.nombrePaciente = nombrePaciente;
		this.especialista = especialista;
		this.listaMotivos = listaMotivos;
		this.fecha = fecha;
	}
	public CitaMedica(String s, String p, String e,
			LinkedList<String> l, Calendar f) {
		this(0,s,p,e,l,f);
	}
	
	/*Método que devuelva el precio de la cita, el cual tendrá un precio base de 100€, dicha cantidad
		se verá incrementada en 30€ si es para un especialista (cualquier médico que no sea de
		“Medicina General”). Los precios anteriores además, se verán incrementados cuando se trate de
		citas urgentes (prioridad de 1, 2 ó 3), las de prioridad 1 en 50€, las de prioridad 2 en 100€ y las
		de prioridad 3 en 150€.
			Por ejemplo una cita para Medicina General que no sea urgente, tendrá un coste de 100€, en
				cambio, una urgente de prioridad 3 para Cardiología, tendrá un coste de 280€ (100 + 30 +
				150).*/
	
	public double precioCita () {
		double precio = 100;
		if(!this.especialista.equals("Medicina General")) {
			precio+=30;
		}
		if(prioridadCita != 0) {
			precio+= (prioridadCita * 50);
		}		
		return precio;
	}
	
	/*
		Redefinición de toString, que devuelva la información de una cita, con un formato parecido a los
		dos siguientes ejemplos:
			1 - 12:50:00 - 987655 - Felipe Rodríguez - [Fuerte dolor abdominal] - Aparato digestivo - 180
			0 - 09:12:45 - 32322 - María López - [Dolor cabeza, Mareos] - Cardiología - 130 */
	
	
	
	@Override
	public String toString() {
		return this.prioridadCita+"";
	}
	
}
