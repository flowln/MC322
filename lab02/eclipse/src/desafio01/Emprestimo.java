package desafio01;

/*
Desafio 1 - Empréstimo
Em um financiamento com juros compostos e número de parcelas fixas parte-se dos seguintes parâmetros:

S - valor da primeira parcela
N - número de parcelas
J - percentual de juros mensal
A primeira parcela a ser paga do financiamento é sempre igual a S. A partir daí é feita uma atualização mensal da parcela, em que cada nova parcela é calculada a partir da parcela do mês anterior, conforme a fórmula:

Parcelamês = Parcelamês-1 * (1 + J / 100)

O financiamento encerra quando as N parcelas são pagas.

Exemplo:

S: 200
N: 5
J: 1%
Parcelas do financiamento: 200; 202; 204.02; 206.06; 208.12
*/

/*
Desafio 1 / Parte 1 - Escrevendo o programa sem módulos
Dado o problema descrito, escreva um programa que calcule as parcelas de um empréstimo para os seguintes valores:

S: 200
N: 5
J: 1%
Nesta versão não use outro módulo além da função principal.

SOLUÇÃO:

float parcela = 200f;
int num_parcelas = 5;
float juros = 0.01f;

for(int i = 0; i < num_parcelas; i++){
    System.out.printf("%.2f\n", parcela);
    parcela += parcela*juros;
}

*/

/*
Desafio 1 / Parte 2 - Escrevendo módulos
Reescreva o código acima de forma que seu programa faça uso de uma função que seja 
responsável pelo cálculo de uma parcela X do empréstimo. 
Podem ser usadas mais funções (métodos) conforme a necessidade.
*/

public class Emprestimo {
	public static float parcelaX(float inicial, int x, float juros){
        float resultado = inicial;
        for(int i = 0; i < x; i++){
            resultado += resultado*juros;
        }
        
        return resultado;
    }
	
	public static void main(String[] args) {
		float inicial = 200f;
		int num_parcelas = 5;
		float juros = 0.01f;

		for(int i = 0; i < num_parcelas; i++)
		    System.out.printf("%.2f\n", Emprestimo.parcelaX(inicial, i, juros));
	}
}
