package desafio03;

/*Desafio 3
Uma molécula de DNA pode ser definida a partir de uma cadeia que representa a sequência de suas bases:
 A - Adenina C - Citisina G - Guanina T - Tinina

Desse modo, uma string pode ser usada para representar um segmento do DNA da seguinte maneira: ATTACGCGCAAAC.

Escreva uma função (método) que codifique a cadeia de RNA produzida a partir de uma cadeia de DNA.
A função deve ser genérica o suficiente para ser aplicável a qualquer cadeia.
A entrada é uma string (DNA) e o retorno é uma string (RNA).

Escreva um programa que teste esta função com uma cadeia de DNA de sua escolha.
*/

public class Genetica {
	
	public static String DNAtoRNA(String DNA){
        DNA = DNA.toUpperCase(); //faz da funcao case-insensitive
        String RNA = "";
        int len = DNA.length();
        for(int i = 0; i < len; i++){
            char base = DNA.charAt(i);
            
            switch(base){
                case('A'):
                    RNA += "U";
                    break;
                case('C'):
                    RNA += "G";
                    break;
                case('G'):
                    RNA += "C";
                    break;
                case('T'):
                    RNA += "A";
                    break;
            }
        }
        
        return RNA;
    }
	
	public static void main(String[] args) {
		String DNA = "CATAGATATACAGATA";

		System.out.println("DNA: " + DNA);
		System.out.println("RNA: " + Genetica.DNAtoRNA(DNA));
	}

}
