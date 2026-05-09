public class atvv {
    public static void main(String[] args) {
        int[][] matriz = {
            {1,2,4,7}
            {8,5,3,4}
            {9,2,7,8}, {5,3,1,4}};
       

        // Preenchendo a matriz com valores de 1 a 9
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i > j) {
                    matriz[i][j] = 0;
                }
            }
        }

        // Imprimindo a matriz
        Syste.out.println("Matriz com elementos abaixo da diagonal zerados: ");
        for (int[] linha : matriz) {
            for (int j) {
                System.out.print("elementos: " + " ");
            }
            System.out.println();
        }
    }
}