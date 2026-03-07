public class TrianguloPascal{
    public static void main(String[] args){
        int [][] trianguloPascal = crearArray(9);
        rellenar(trianguloPascal);
    }
    public static int [][] crearArray(int alt){
        int[][] array = new int[alt][];
        for(int i = 0; i < alt; i++)
            array[i] = new int[i+1];

        array[0][0] = array[1][0]= array[1][1] = 1;
        return array;
    }
    public static void rellenar(int[][] array){
        int esp = array.length;
        for(int i = 0; i < array.length; i++){
            for(int k = 0; k < esp - 1; k++)
                System.out.print(" ");
                for(int j = 0; j < array[i].length; j++){
                if(j == 0 || j == array[i].length-1){
                    array[i][j] = 1;
                    System.out.print(array[i][j] + " ");
                }
                else{
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                    System.out.print(array[i][j] + " ");
                }
            }
            esp--;
            System.out.println();
        }
    }
}