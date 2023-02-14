package Cuenta_Bancaria;

import java.util.ArrayList;

public class Cuenta {

	private int numCuenta;
	private double saldo;
	private ArrayList<String> historialMovimientos = new ArrayList<>();
	
	
	public Cuenta(int numCuenta, double saldo) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}
	

	public int getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	public ArrayList<String> getHistorialMovimientos() {
		return historialMovimientos;
	}


	public void setHistorialMovimientos(ArrayList<String> historialMovimientos) {
		this.historialMovimientos = historialMovimientos;
	}


	public void depositarDinero(double cantidad) {
		saldo += cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		saldo -= cantidad;
	}
	
	public void registrarMoviemiento(String movimiento) {
		historialMovimientos.add(movimiento);
	}
	
	public void mostrarHistoricos(ArrayList <String>historialMovimientos) {
		for(int i = 0; i > historialMovimientos.size(); i++) {
			System.out.println(historialMovimientos.get(i)); 
		}
	}

	
	
	

}
