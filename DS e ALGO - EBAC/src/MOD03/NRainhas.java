package MOD03;

public class NRainhas {

    private static boolean temAtaque(int x , int y, int[][] tab){
        for (int j = 0; j < tab.length; j++) {
            if (tab[x][j] == 1){
                return true;
            }

        }

        for (int i = 0; i < tab.length; i++) {
            if (tab[i][y] == 1){
                return true;
            }

        }

//        se a soma dos pontos do alvo X+Y = |X+Y| do ponto da diagonal , então é diagonal esquerda
//        se a soma dos pontos do alvo X-Y = |X-Y| do ponto da diagonal , então é diagonal direita

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                int indEsq = i + j;
                int indDir = i - j;

                if (indEsq == (x + y)){
                    if (tab[i][j] == 1){
                        return true;
                    }
                }
                if (indDir== (x - y)){
                    if (tab[i][j] == 1){
                        return true;
                    }
                }


            }

        }



        return false;
    }

    private static void imprimir(int [][] tab){
        for (int i = 0; i < tab.length ; i++) {
            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[i][j]);

            }
            System.out.println();

        }
    }
    
    private static boolean resolveNrainhas(int[][] tab, int n ){
        if (n == 0){
            return true;
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length ; j++) {
                if (temAtaque(i,j, tab)){
                    continue;
                }

                tab[i][j] = 1;

                if (resolveNrainhas(tab, n-1)){
                    return true;
                }

                tab[i][j] = 0;

            }
            
        }
        
        
        return false;
        
                
    }

    public static void main(String[] args) {
        int[][] tab = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}



        };

        int n = 14;
//        complexidade tempo: O(demora pra porra)

         boolean resultado = resolveNrainhas(tab, n);
         if (resultado){
             imprimir(tab);
         } else {
             System.out.println("sem solução");
         }
    }
}
