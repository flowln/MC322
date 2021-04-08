package mc322.lab03;

public class Animacao {
AquarioLombriga obj;
    
    int frame = 0;
    int total_frames;
    String sequencia;
    
    public Animacao(String args){
        int taq = Integer.parseInt(args.substring(0, 2));
        int tlo = Integer.parseInt(args.substring(2, 4));
        int pos = Integer.parseInt(args.substring(4, 6));
        
        sequencia = args.substring(6);
        total_frames = sequencia.length();
        obj = new AquarioLombriga(taq, tlo, pos);
    }
    
    public String apresenta(){
        return obj.apresenta();
    }
    
    public void passo(){
        if(frame == total_frames) return;
        
        char comando = sequencia.charAt(frame);
        frame += 1;
        
        switch(comando){
            case 'C':
                obj.crescer();
                break;
            case 'M':
                obj.mover();
                break;
            case 'V':
                obj.virar();
                break;
            default:
                System.out.println("Comando inválido!");
        }
    }
}
