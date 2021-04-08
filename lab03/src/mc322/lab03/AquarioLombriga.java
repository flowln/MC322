package mc322.lab03;

public class AquarioLombriga {
	int tam_aquario, tam_lombriga;
    int pos_cabaca;
    
    boolean para_direita = true;
    
    public AquarioLombriga(int tAquario, int tLombriga, int pos){
        tam_aquario = tAquario;
        tam_lombriga = tLombriga < tAquario ? tLombriga : tAquario;
        pos_cabaca = (pos < tAquario && pos > 0) ? pos + tam_lombriga - 1 : tam_lombriga;
    }
    
    public void crescer(){
        if(para_direita){
            if(pos_cabaca - tam_lombriga > 0)
                tam_lombriga += 1;
        }
        else{
            if(pos_cabaca + tam_lombriga <= tam_aquario)
                tam_lombriga += 1;
        }
    }
    
    public void virar(){
        if(para_direita)
            pos_cabaca -= tam_lombriga - 1;
        else
            pos_cabaca += tam_lombriga - 1;
        
        para_direita = !para_direita;
    }
    
    public void mover(){
        if(para_direita){
            if(pos_cabaca < tam_aquario) 
                pos_cabaca += 1;
            else
                virar();
        }
        else{
            if(pos_cabaca > 1)
                pos_cabaca -= 1;
            else
                virar();
        }
    }
    
    public String apresenta(){
        String res = "";
        
        int antes;
        int depois;
        
        if(para_direita){
            antes = pos_cabaca - tam_lombriga;
            depois = tam_aquario - pos_cabaca;
        }
        else{
            antes = pos_cabaca - 1;
            depois = tam_aquario - antes - tam_lombriga;
        }
        
        int i;
        
        for(i = 0; i < antes; i++) res += "#"; //aquario antes da lombriga
        if(para_direita){
            for(i = 0; i < tam_lombriga - 1; i++) res += "@";
            res += "O";
        }
        else{
            res += "O";
            for(i = 0; i < tam_lombriga - 1; i++) res += "@";
        }
        for(i = 0; i < depois; i++) res += "#"; //aquario depois da lombriga
        
        return res;
        
    }
}
