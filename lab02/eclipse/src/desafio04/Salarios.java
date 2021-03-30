package desafio04;

import java.util.Random;

/*
Desafio 4
Uma empresa precisa realizar uma estatística do salário de seus funcionários.

Para fins de teste, os salários devem ser gerados aleatoriamente com valores variando entre
R$ 2.500 e R$ 15.000.

Escreva um programa que gere uma lista contendo os salários de 50 funcionários da empresa
e mostre no console quantos funcionários ganham salário acima da média.
*/

public class Salarios {
	
	public static final int NUM_SALARIOS = 50;

	public static void main(String[] args) {
		Random rng = new Random();
		int salarios[] = new int[Salarios.NUM_SALARIOS];

		double peso_salario = 1/(double) Salarios.NUM_SALARIOS;
		double media = 0;

		for(int i = 0; i < Salarios.NUM_SALARIOS; i++){
		    int salario = rng.nextInt(12501) + 2500; //entre 2500 e 15000 inclusive
		    salarios[i] = salario;
		    media += salario * peso_salario;
		}

		int num_acima_media = 0;

		for(int salario : salarios)
		    if(salario > media) num_acima_media += 1;

		System.out.println(num_acima_media);
	}

}
