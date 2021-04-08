package mc322.lab03;

public class AppLab03 {
	public static void main(String[] args) {
		String animacao = "080403MCMVM";

		Animacao a = new Animacao(animacao);
		int j = a.total_frames + 1;

		for(int i = 0; i < j; i++){
		    System.out.println(a.apresenta());
		    a.passo();
		}
	}
}
