package Cuenta_Bancaria;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Movimientos_bancarios {
	
	public static int buscarNroCuenta(Cuenta cuentas[], int nroCuentaBuscar) {
		int i = 0;
		int j = 0;
		boolean nroCuentaEncontrada = false;
		
		while((j < cuentas.length) && (nroCuentaEncontrada == false)) {
			if(cuentas[j].getNumCuenta() == nroCuentaBuscar) {
				nroCuentaEncontrada = true;
				i = j;
			}
			j++;
		}
		
		if(nroCuentaEncontrada == false) {
			i = -1;
		}
		return i;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nombre, apellidos, DNI;
		String[] historialMovimientos;
		Cuenta cuentas[];
		Cliente cliente;
		int numeroCuenta, cantCuentas, opcion, iNroCuenta;
		double saldo, cantidadDinero;
		
		LocalDate fechaAlta = LocalDate.now();
		
		System.out.print("Introduzca nombre de cliente: ");
		nombre = sc.next();
		
		System.out.print("\nIntroduzca apellidos del cliente: ");
		apellidos = sc.next();
		
		System.out.print("\nIntroduzca DNI del cliente: ");
		DNI = sc.next();
		
		System.out.print("\nIntroduzca cantidad de cuentas que posee: ");
		cantCuentas = sc.nextInt();
		
		System.out.println("\n");
		
		cuentas = new Cuenta[cantCuentas];  //Creamos array de cuentas con el numero de cuentas del cliente
		
		for(int i = 0; i < cuentas.length; i++) {
			System.out.print("Introduzca el "+(i+1)+"º numero de cuenta: ");
			numeroCuenta = sc.nextInt();
			
			System.out.print("\nIntroduzca el saldo de la cuenta: ");
			saldo = sc.nextDouble();
			
			cuentas[i] = new Cuenta(numeroCuenta, saldo);
		}
		
		cliente = new Cliente (nombre, apellidos, DNI, fechaAlta, cuentas);
		
		do {
			System.out.println("\nMENU");
			System.out.println("\n1. Consultar saldo de la cuenta bancaria");
			System.out.println("\n2. Depositar saldo a la cuenta bancaria");
			System.out.println("\n3. Retirar saldo de la cuenta bancaria");
			System.out.println("\n4. Consultar historico de movimientos");
			System.out.println("\n5. Salir");
			System.out.println("Eliga que desea realizar");
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					System.out.println("Introduzca el numero de cuenta");
					numeroCuenta = sc.nextInt();
					iNroCuenta = buscarNroCuenta(cuentas, numeroCuenta);
					
					if(iNroCuenta == -1) {
						System.out.println("Cuenta no encontrada, verifica su numero de cuenta");
					}else {
						System.out.println("\nSaldo disponible en su cuenta: "+cliente.consultarSaldo(iNroCuenta)+" €");
					}
					
					
					break;
			     
			    case 2:
			    	System.out.println("Introduzca el numero de cuenta");
					numeroCuenta = sc.nextInt();
					iNroCuenta = buscarNroCuenta(cuentas, numeroCuenta);
					
					if(iNroCuenta == -1) {
						System.out.println("Cuenta no encontrada, verifica su numero de cuenta");
					}else {
						System.out.println("Introduzca la cantidad a depositar");
						cantidadDinero = sc.nextDouble();
						cliente.depositarDinero(iNroCuenta, cantidadDinero);
						System.out.println("\n Deposito realizado");
						System.out.println("Saldo disponible: "+cliente.consultarSaldo(iNroCuenta)+" €");
						String registro = "Deposito realizado de "+cantidadDinero+" €";
						cliente.registrarMoviemiento(iNroCuenta, registro);
					}
			     
			    	break;
			     case 3:
			    	 
			    	System.out.println("Introduzca el numero de cuenta");
					numeroCuenta = sc.nextInt();
					iNroCuenta = buscarNroCuenta(cuentas, numeroCuenta);
						
					if(iNroCuenta == -1) {
						
						System.out.println("Cuenta no encontrada, verifica su numero de cuenta");
					}else {
						
						System.out.println("Introduzca la cantidad a retirar");
						cantidadDinero = sc.nextDouble();
						cliente.retirarDinero(iNroCuenta, cantidadDinero);
						System.out.println("\n Retiro realizado");
						System.out.println("Saldo disponible: "+cliente.consultarSaldo(iNroCuenta)+" €");
						String registro = "Retiro realizado de "+cantidadDinero+" €";
						cliente.registrarMoviemiento(iNroCuenta, registro);
						
						}
			    	 
			    	 
				     
			    	 break;
			    	 
			     case 4:
			    	 
			    	 System.out.println("Introduzca el numero de cuenta a consultar");
						numeroCuenta = sc.nextInt();
						iNroCuenta = buscarNroCuenta(cuentas, numeroCuenta);
							
						if(iNroCuenta == -1) {
							
							System.out.println("Cuenta no encontrada, verifica su numero de cuenta");
						}else {
							
							System.out.println(cliente.consultarHistorico(iNroCuenta).toString());
							
							}
			    	 
			    	 break;
			    	 
			    	 
				 case 5:
					 System.out.println("Hasta luego, gracias por confiar en nosotros.");
					 opcion = 5;
				     break;
				     
				 default:
					 System.out.println("Opcion no disponible, escriba otra opcion.");
					 break;
			
			}
			
		}while(opcion != 5);
		
	}

}
