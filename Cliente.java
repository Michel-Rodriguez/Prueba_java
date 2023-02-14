package Cuenta_Bancaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {

		
		private String nombre;
		private String apellidos;
		private String DNI;
		private LocalDate fechaAlta;
		Cuenta cuentas [];
		
		
		public Cliente(String nombre, String apellidos, String dNI, LocalDate fechaAlta, Cuenta[] cuenta) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			DNI = dNI;
			this.fechaAlta = fechaAlta;
			this.cuentas = cuenta;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public String getDNI() {
			return DNI;
		}


		public void setDNI(String dNI) {
			DNI = dNI;
		}


		public LocalDate getFechaAlta() {
			return fechaAlta;
		}


		public void setFechaAlta(LocalDate fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
		
		public double consultarSaldo(int i) {
			return cuentas[i].getSaldo();
		
		}
		
		public void depositarDinero(int i, double cantidad) {
			cuentas[i].depositarDinero(cantidad);
		}
		
		public void retirarDinero(int i, double cantidad) {
			cuentas[i].retirarDinero(cantidad);
		}
		
		public void registrarMoviemiento(int i, String movimiento) {
			cuentas[i].registrarMoviemiento(movimiento);
		}
		
		public ArrayList<String> consultarHistorico(int i){
			return cuentas[i].getHistorialMovimientos();
		}
		
		
		
		

	

}
