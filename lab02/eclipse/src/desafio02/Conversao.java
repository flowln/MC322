package desafio02;

import java.util.Random;

/*
Desafio 2
Escreva um programa que sorteie um número inteiro entre 0 e 9999 o número deve ser mostrado, 
em seguida convertido para binário e a versão binária deve ser apresentada no console. 
A conversão decimal/binário deve ser computada por um programa feito por você.
*/

public class Conversao {
	 public static String toBinary(int decimal){
	        String res = "";
	        int n = 1;
	        
	        while(n <= decimal){
	            if((n & decimal) != 0) res = "1" + res; //bit masking
	            else res = "0" + res;
	            
	            n = n << 1;
	        }
	        
	        return res;
	    }

	public static void main(String[] args) {
		Random rng = new Random();

		int valor = rng.nextInt(10000);

		System.out.println(valor);
		System.out.println(Conversao.toBinary(valor));
	}
}
