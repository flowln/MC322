package mc322.lab05;

public class Dama {
  private static Tabuleiro tab;

  private boolean isPreto;

  private int x, y;

  public Dama(boolean isPreto, int x, int y) {
    this.isPreto = isPreto;
    this.x = x;
    this.y = y;
  }

  /*
    Retorna -1 se não houver nenhuma peça no caminho, 0 se houver uma peça 
    da mesma cor, e um inteiro 'n' se houver peça de cor distinta, indicando
    a distância até tal peça pela diagonal
  */
  private int temPecaNaDiagonal(int xNew, int yNew) {
    int dist = -1;

    if (yNew > y) {
      if (xNew > x) {
        for (int n = 1; n < xNew - x; n++){
          if (tab.temPecaDaCor(x + n, y + n, isPreto))
            return 0;
          if(tab.temPecaDaCor(x + n, y + n, !isPreto))
            dist = n;
        }
      }

      if (xNew < x) {
        for (int n = 1; n <  x - xNew; n++){
          if (tab.temPecaDaCor(x - n, y + n, isPreto))
            return 0;
          if(tab.temPecaDaCor(x - n, y + n, !isPreto))
            dist = n;
        }
      }
    }

    if (yNew < y) {
      if (xNew > x) {
        for (int n = 1; n < xNew - x; n++){
          if (tab.temPecaDaCor(x + n, y - n, isPreto))
            return 0;
          if(tab.temPecaDaCor(x + n, y - n, !isPreto))
            dist = n;
        }
      }

      if (xNew < x) {
        for (int n = 1; n < x - xNew; n++){
          if (tab.temPecaDaCor(x - n, y - n, isPreto))
            return 0;
          if(tab.temPecaDaCor(x - n, y - n, !isPreto))
            dist = n;
        }
      }
    }
    
    return dist;
  }

  public boolean mover(int xNew, int yNew, boolean deveComer){
    // Checa se esta dentro do tabuleiro
    if(xNew < 0 || xNew > 7 || yNew < 0 || yNew > 7) return false;

    if(isPreto != tab.turnoDasPretas()) return false;

    // Checa se tem peca no destino
    if(tab.temPeca(xNew, yNew)) return false;

    // Verifica se o movimento foi na diagonal e se ha uma peca no meio do trajeto
    if (Math.abs(x-xNew) == Math.abs(y-yNew)){
      int n = temPecaNaDiagonal(xNew, yNew);

      if(n == 0) return false;
      if(n == -1){
        if(deveComer) return false;
        else return true;
      }

      if (yNew > y) {
        if (xNew > x) tab.comerPeca(x+n, y+n);
        else tab.comerPeca(x-n, y+n);
      }

      else if (yNew < y) {
        if (xNew > x) tab.comerPeca(x+n, y-n);
        else tab.comerPeca(x-n, y-n);
      }

      return true;
    }

    return false;
  }

  public static void setTabuleiro(Tabuleiro t){
    Dama.tab = t;
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public boolean cor(){
    return isPreto;
  }

  public char repr() {
    return isPreto ? 'P' : 'B';
  }
}