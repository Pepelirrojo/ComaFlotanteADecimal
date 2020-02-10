import java.util.Scanner;

public class Funciones {
	Scanner sc = new Scanner(System.in);

	boolean esPositivo() {
		System.out.println("PROGRAMA PARA PASAR UN NUMERO EN COMA FLOTANTE DE PRECISIÓN SENCILLA A DECIMAL");
		boolean rspta = false;
		System.out.print("Dime el signo [1 o 0] : ");
		int signo = sc.nextInt();
		while (signo != 0 && signo != 1) {
			System.out.print("Dime el signo [1 o 0] : ");
			signo = sc.nextInt();
		}
		if (signo == 0) {
			rspta = true;
		}
		return rspta;
	}

	long exponente() {

		long num, aux, digit, decimal;
		int expo;
		boolean esBinario;
		do {
			System.out.print("Introduce el exponente en binario: ");
			num = sc.nextLong();
			while (num > 99999999 || num < 0) {
				System.out.print("Introduce el exponente en binario: ");
				num = sc.nextLong();
			}
			esBinario = true;
			aux = num;
			while (aux != 0) {
				digit = aux % 10;
				if (digit != 0 && digit != 1) {
					esBinario = false;
				}
				aux = aux / 10;
			}
		} while (!esBinario);
		expo = 0;
		decimal = 0;
		while (num != 0) {

			digit = num % 10;

			decimal = decimal + digit * (int) Math.pow(2, expo);

			expo++;

			num = num / 10;
		}
		decimal -= 127;
		System.out.println(decimal);
		return decimal;
		
	}

	float mantisa(long decimal) {
		System.out.print("Introduce la Mantisa: [ej: 0,x] ");
		float mant = sc.nextFloat();
		float preResult, result = 0, expCifre = 0;
		int cifre;
		while (mant > 0.2) {
			System.out.print("Introduce la Mantisa: [ej: 0,x] ");
			mant = sc.nextFloat();
		}
		mant += 1;
		preResult = (int) (mant * (Math.pow(10, decimal)));
		System.out.println(preResult);
		while (preResult != 0) {

			cifre = (int) (preResult % 10);

			result = result + cifre * (int) Math.pow(2, expCifre);

			expCifre++;

			preResult = preResult / 10;
		}
		return result;
		
	}

	void resultFinal(boolean rspta, float result) {
		if (rspta == false) {
			result -= result * 2;
			System.out.println("El numero en decimal es: " + result);
		} else {
			System.out.println("El numero en decimal es: " + result);
		}
	}
}
